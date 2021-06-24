package flowerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlowerDao;
import dao.FlowerDaoIml;
import entity.Flower;


public class FlowerServlet extends HttpServlet {
     
	FlowerDao fd = new FlowerDaoIml();
	
	public FlowerServlet() {
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
			List<Flower> list = fd.findAll();
			request.setAttribute("list1", list);
			request.getRequestDispatcher("flower.jsp").forward(request, response);
		}else if("del".equals(type)){
			int id=Integer.parseInt(request.getParameter("id"));
			if(fd.delete(id)){
				out.print("<script>alert('删除成功.');location.href='flower.do?type=find'</script>");
			}
		}else if("add".equals(type)){
			String name = request.getParameter("name");
			int id = Integer.parseInt(request.getParameter("id"));
			String nickName = request.getParameter("nickName");
			String property = request.getParameter("property");
			float price = Float.parseFloat(request.getParameter("price"));
			String production = request.getParameter("production");
			if(fd.insert(new Flower(id, name, nickName, property, price, production))){
				out.print("<script>alert('添加成功.');location.href='flower.do?type=find'</script>");
			}
		}
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
