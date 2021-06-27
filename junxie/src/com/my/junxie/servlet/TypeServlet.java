package com.my.junxie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.junxie.entity.WeaponType;
import com.my.junxie.services.TypeServices;
import com.my.junxie.services.TypeServicesIml;


public class TypeServlet extends HttpServlet {
    
	TypeServices ts = new TypeServicesIml();
	public TypeServlet() {
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
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if("find".equals(type)||type==null){
			List<WeaponType> list = ts.findAll(null);
			request.setAttribute("list1", list);
			request.getRequestDispatcher("type.jsp").forward(request, response);
		}else if("del".equals(type)){
			int typeId=Integer.parseInt(request.getParameter("typeId"));
			if(ts.delete(typeId)){
				out.print("<script>alert('删除成功.');location.href='type.do?type=find'</script>");
			}else{
				out.print("<script>alert('未删除.');location.href='type.do?type=find'</script>");
			}
		}else if("add".equals(type)){
			String typeName = request.getParameter("typeName");
			int typeId = Integer.parseInt(request.getParameter("typeId"));
		    int isUse = Integer.parseInt(request.getParameter("isUse"));
			if(ts.add(new WeaponType(typeId, typeName, isUse))){
				out.print("<script>alert('添加成功.');location.href='type.do?type=find'</script>");
			}else {
				out.print("<script>alert('添加失败.');location.href='type.do?type=find'</script>");
			}
		}else if("findById".equals(type)){
			WeaponType weaponType = ts.findAll(request.getParameter("typeId")).get(0);
			request.setAttribute("weapontype",weaponType);
			request.getRequestDispatcher("typeupdate.jsp").forward(request, response);
		}else if("update".equals(type)){
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			int isUse = Integer.parseInt(request.getParameter("isUse"));
			String typeName = request.getParameter("typeName");
			if(ts.update(new WeaponType(typeId, typeName, isUse))){
				out.print("<script>alert('修改成功.');location.href='type.do?type=find'</script>");
			}else {
				out.print("<script>alert('修改失败.');location.href='type.do?type=find'</script>");
			}
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
