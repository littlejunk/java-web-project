package com.my.junxie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.junxie.entity.Arm;
import com.my.junxie.entity.WeaponType;
import com.my.junxie.services.ArmServices;
import com.my.junxie.services.ArmServicesIml;
import com.my.junxie.services.TypeServices;
import com.my.junxie.services.TypeServicesIml;


public class ArmServlet extends HttpServlet {

    ArmServices as = new ArmServicesIml();
    TypeServices ts = new TypeServicesIml();
	public ArmServlet() {
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
		if("find".equals(type) || type==null){
			List<Arm> list = as.findAll(null);
			request.setAttribute("list", list);
			request.getRequestDispatcher("arm.jsp").forward(request, response);
		}else if("del".equals(type)){
			String armId=request.getParameter("armId");
			if(as.delete(armId)){
				out.print("<script>alert('删除成功.');location.href='arm.do?type=find'</script>");
			}else{
				out.print("<script>alert('未删除.');location.href='arm.do?type=find'</script>");
			}
		}else if ("findById".equals(type)) {
			Arm arm = as.findAll(request.getParameter("armId")).get(0);
			List<WeaponType> list = ts.findInUse();
			request.setAttribute("weapontype", list);
			request.setAttribute("arm", arm);
			request.getRequestDispatcher("armupdate.jsp").forward(request, response);
		}else if ("update".equals(type)) {
			int armId = Integer.parseInt(request.getParameter("armId"));
			String armName = request.getParameter("armName");
			String bullet = request.getParameter("bullet");
			int shotRange = Integer.parseInt(request.getParameter("shotRange"));
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			if(as.update(new Arm(armId, armName, bullet, shotRange, typeId))){
				out.print("<script>alert('修改成功.');location.href='arm.do?type=find'</script>");
			}else {
				out.print("<script>alert('修改失败.');location.href='arm.do?type=find'</script>");
			}
	    }else if("findByIdd".equals(type)) {
	    	List<WeaponType> list = ts.findInUse();
			request.setAttribute("weapontype", list);
			request.getRequestDispatcher("armadd.jsp").forward(request, response);
		}else if("add".equals(type)) {
			int armId = Integer.parseInt(request.getParameter("armId"));
			String armName = request.getParameter("armName");
			String bullet = request.getParameter("bullet");
			int shotRange = Integer.parseInt(request.getParameter("shotRange"));
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			if(as.add(new Arm(armId, armName, bullet, shotRange, typeId))){
				out.print("<script>alert('添加成功.');location.href='arm.do?type=find'</script>");
			}else {
				out.print("<script>alert('添加失败.');location.href='arm.do?type=find'</script>");
			}
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
