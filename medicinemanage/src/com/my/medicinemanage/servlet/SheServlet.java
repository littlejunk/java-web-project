package com.my.medicinemanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import com.my.medicinemanage.entity.Shelve;
import com.my.medicinemanage.entity.User;
import com.my.medicinemanage.services.SheService;
import com.my.medicinemanage.services.SheServiceIml;

public class SheServlet extends HttpServlet {

	SheService ss = new SheServiceIml();
	public SheServlet() {
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
			if("find".equals(type)||type==null){
				List<Shelve> list = ss.findAll(null);
				request.setAttribute("list1", list);
				request.getRequestDispatcher("shelve.jsp").forward(request, response);
			}else if("del".equals(type)){
				if(user.getUserRole() == 0){
				int sheId=Integer.parseInt(request.getParameter("sheId"));
				if(ss.delete(sheId)){
					out.print("<script>alert('删除成功.');location.href='she.do?type=find'</script>");
				}else{
					out.print("<script>alert('未删除.');location.href='she.do?type=find'</script>");
				}
				}else {
					out.print("<script>alert('您没有高级管理员权限，请申请权限或者登录高级管理员权限');location.href='she.do'</script>");
				}
			}else if("add".equals(type)){
				String sheName = request.getParameter("sheName");
				int sheCap = Integer.parseInt(request.getParameter("sheCap"));
				if(ss.add(new Shelve(0, sheCap, sheName))){
					out.print("<script>alert('添加成功.');location.href='she.do?type=find'</script>");
				}else {
					out.print("<script>alert('添加失败.');location.href='she.do?type=find'</script>");
				}
			}else if("findById".equals(type)){
				if(user.getUserRole() == 0){
				Shelve Shelve = ss.findAll(request.getParameter("sheId")).get(0);
				request.setAttribute("shelve",Shelve);
				request.getRequestDispatcher("shelveupdate.jsp").forward(request, response);
				}else {
					out.print("<script>alert('您没有高级管理员权限，请申请权限或者登录高级管理员权限');location.href='she.do'</script>");
				}
			}else if("update".equals(type)){
				if(user.getUserRole() == 0){
				Shelve shelve = ss.findAll(request.getParameter("sheId")).get(0);
				String sheName = request.getParameter("sheName");
				shelve.setSheName(sheName);
				if(ss.update(shelve)){
					out.print("<script>alert('修改成功.');location.href='she.do?type=find'</script>");
				}else {
					out.print("<script>alert('修改失败.');location.href='she.do?type=find'</script>");
				}
				}else {
					out.print("<script>alert('您没有高级管理员权限，请申请权限或者登录高级管理员权限');location.href='she.do'</script>");
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
