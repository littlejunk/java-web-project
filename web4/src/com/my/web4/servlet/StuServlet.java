package com.my.web4.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.CSS;

import com.my.web4.dao.ClassDao;
import com.my.web4.dao.ClassDaoIml;
import com.my.web4.dao.StudentDao;
import com.my.web4.dao.StudentDaoImpl;
import com.my.web4.entity.ClassInfo;
import com.my.web4.entity.Student;
import com.my.web4.services.ClassServices;
import com.my.web4.services.ClassServicesIml;
import com.my.web4.services.StudentServices;
import com.my.web4.services.StudentServicesIml;


public class StuServlet extends HttpServlet {

	StudentServices ss = new StudentServicesIml();
	ClassServices cs = new ClassServicesIml();
	public StuServlet() {
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
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("find".equals(type) || type==null){
			List<Student> list = ss.findAll(null);
			request.setAttribute("list", list);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		}else if("del".equals(type)){
			int stuId=Integer.parseInt(request.getParameter("stuId"));
			if(ss.delStudent(stuId)){
				out.print("<script>alert('删除成功.');location.href='stu.do?type=find'</script>");
			}
		}else if ("findById".equals(type)) {
			Student stu = ss.findAll(request.getParameter("stuId")).get(0);
			List<ClassInfo> list = cs.findAll(null);
			request.setAttribute("classes", list);
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if ("update".equals(type)) {
			int stuId =Integer.parseInt(request.getParameter("stuId"));
			String stuName = request.getParameter("stuName");
			String stuSex = request.getParameter("stuSex");
			int classId = Integer.parseInt(request.getParameter("classId"));
			int stuAge = Integer.parseInt(request.getParameter("stuAge"));
			//System.out.println(stuAge+stuName+stuId);
			if(ss.updStudent(new Student(stuId, stuName, stuAge, stuSex, classId))){
				out.print("<script>alert('修改成功.');location.href='stu.do?type=find'</script>");
			}else {
				out.print("<script>alert('修改失败.');location.href='stu.do?type=find'</script>");
			}
	}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
