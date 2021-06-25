package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;

public class StuServlet extends HttpServlet {

	StudentDao sd = new StudentDaoImpl();
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
		if("find".equals(type)){
			List<Student> list = sd.findAll(null);
			request.setAttribute("list", list);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		}else if("del".equals(type)){
			int stuId=Integer.parseInt(request.getParameter("stuId"));
			if(sd.delStudent(stuId)){
				out.print("<script>alert('删除成功.');location.href='usersb.do?type=find'</script>");
			}
		}else if ("findById".equals(type)) {
			Student stu = sd.findAll(request.getParameter("stuId")).get(0);
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if ("update".equals(type)) {
			int stuId =Integer.parseInt(request.getParameter("stuId"));
			String stuName = request.getParameter("stuName");
			String stuSex = request.getParameter("stuSex");
			int classId = Integer.parseInt(request.getParameter("classId"));
			int stuAge = Integer.parseInt(request.getParameter("stuAge"));
			//System.out.println(stuAge+stuName+stuId);
			if(sd.updStudent(new Student(stuId, stuName, stuAge, stuSex, classId))){
				out.print("<script>alert('修改成功.');location.href='usersb.do?type=find'</script>");
			}else {
				out.print("<script>alert('修改失败.');location.href='usersb.do?type=find'</script>");
			}
	}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
