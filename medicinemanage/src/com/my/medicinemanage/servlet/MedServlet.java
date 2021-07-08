package com.my.medicinemanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.my.medicinemanage.entity.Medicine;
import com.my.medicinemanage.entity.Shelve;
import com.my.medicinemanage.entity.User;
import com.my.medicinemanage.services.MedService;
import com.my.medicinemanage.services.MedServiceIml;
import com.my.medicinemanage.services.SheServiceIml;
import com.my.medicinemanage.services.SheService;

public class MedServlet extends HttpServlet {

	MedService ms = new MedServiceIml();
	SheService ss = new SheServiceIml();
	public MedServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null){
			if("find".equals(type) || type==null){
				List<Medicine> list = ms.findAll(null);
				request.setAttribute("list", list);
				request.getRequestDispatcher("medicine.jsp").forward(request, response);
			}else if("del".equals(type)){
				if(user.getUserRole() == 0){
					String medId=request.getParameter("medId");
					if(ms.delete(medId)){
						out.print("<script>alert('删除成功.');location.href='med.do?type=find'</script>");
					}else{
						out.print("<script>alert('未删除.');location.href='med.do?type=find'</script>");
					}
				}else{
					out.print("<script>alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');location.href='med.do'</script>");
				}
			}else if ("findById".equals(type)) {
				if(user.getUserRole() == 0){
					Medicine medicine = ms.findAll(request.getParameter("medId")).get(0);
					List<Shelve> list = ss.findAll(null);
					request.setAttribute("shelves", list);
					request.setAttribute("medicine",medicine);
					request.getRequestDispatcher("medicineupdate.jsp").forward(request, response);
				}else {
					out.print("<script>alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');location.href='med.do'</script>");
				}
			}else if ("update".equals(type)) {
				if(user.getUserRole() == 0){
					Medicine medicine = ms.findAll(request.getParameter("medId")).get(0);
					float medPrice = Float.parseFloat(request.getParameter("medPrice"));
					int medNum = Integer.parseInt(request.getParameter("medNum"));
					int sheId = Integer.parseInt(request.getParameter("sheId"));
					medicine.setMedPrice(medPrice);
					medicine.setMedNum(medNum);
					medicine.setSheId(sheId);
					if("yes".equals(request.getParameter("rt"))){
						if(ms.update(medicine)){
							out.print("<script>alert('修改成功.');location.href='med.do?type=find'</script>");
						}else {
							out.print("<script>alert('修改失败.建议新增货架');location.href='med.do?type=find'</script>");
						}
					}else{
						if(ms.update(medicine)){
							out.print("<script>alert('修改成功.');location.href='med.do?type=main'</script>");
						}else {
							out.print("<script>alert('修改失败.建议新增货架');location.href='med.do?type=main'</script>");
						}
					}
				}else {
					out.print("<script>alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');location.href='med.do'</script>");
				}
			}else if("findByIdd".equals(type)) {
				List<Shelve> list = ss.findAll(null);
				request.setAttribute("shelves", list);
				request.getRequestDispatcher("medicineadd.jsp").forward(request, response);
			}else if("add".equals(type)) {
				String medName = request.getParameter("medName");
				float medPrice = Float.parseFloat(request.getParameter("medPrice"));
				int medNum = Integer.parseInt(request.getParameter("medNum"));
				int sheId = Integer.parseInt(request.getParameter("sheId"));
				String production = request.getParameter("production");
				String sheLife = request.getParameter("sheLife");
				if(ms.add(new Medicine(0, medName, medPrice, medNum, production, sheLife, sheId))){
					out.print("<script>alert('添加成功.');location.href='med.do?type=find'</script>");
				}else {
					out.print("<script>alert('添加错误.查看容量是否足够');location.href='med.do?type=find'</script>");
				}
			}else if("main".equals(type)){
				List<Medicine> list = ms.findNotuse();
				request.setAttribute("list", list);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else if("delnotuse".equals(type)){
				if(user.getUserRole() == 0){
					String[] medIds = request.getParameterValues("delid");
					if(ms.delNotuse(medIds)){
						out.print("<script>alert('删除成功.');location.href='med.do?type=main'</script>");
					}else {
						out.print("<script>alert('删除未成功.');location.href='med.do?type=main'</script>");
					}
				}else {
					out.print("<script>alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');location.href='med.do?type=main'</script>");
				}

			}else if("findByKey".equals(type)){
				if(!"".equals(request.getParameter("keyword"))){
					List<Medicine> list = ms.findByKey(request.getParameter("keyword"));
					out.print(JSON.toJSONString(list));
				}
			}else if("findnotuse".equals(type)){
				List<Medicine> list = ms.findNotuse();
				out.print(JSON.toJSONString(list));
			}else if("ajaxdel".equals(type)) {
				if(user.getUserRole() == 0){
					out.print(ms.delete(request.getParameter("medId")));
				}else {
					out.print("0");
				}
			}else if("ajaxfindById".equals(type)){
				if(user.getUserRole() == 0){
					out.print("1");
				}else {
					out.print("0");
				}
			}
		}else {
			out.print("<script>alert('未登录！');location.href='login.jsp'</script>");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}


}
