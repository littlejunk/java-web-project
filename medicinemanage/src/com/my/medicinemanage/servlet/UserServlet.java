package com.my.medicinemanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.medicinemanage.dao.UserDao;
import com.my.medicinemanage.dao.UserDaoIml;
import com.my.medicinemanage.entity.Manager;
import com.my.medicinemanage.entity.Medicine;
import com.my.medicinemanage.entity.User;

public class UserServlet extends HttpServlet {


	public UserServlet() {
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
		UserDao ud = new UserDaoIml(); 
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		User user = ud.login(request.getParameter("user"), request.getParameter("pwd"));
		Manager manager = ud.manlogin(request.getParameter("user"), request.getParameter("pwd"));
		if("login".equals(type)){
			if(user!=null){
				session.setAttribute("user", user);
				response.sendRedirect("med.do?type=main");
			}else {
				out.print("<script>alert('µÇÂ¼Ê§°Ü£¬ÇëÊäÈëÕýÈ·ÕË»§ÃÜÂë');location.href='login.jsp'</script>");
			}
		}else if("zhuxiao".equals(type)) {
			session.invalidate();
			out.print("<script>alert('·µ»ØµÇÂ¼Ò³Ãæ£¿');location.href='newlogin.jsp'</script>");
		}else if("login2".equals(type)){
			if(user!=null){
				session.setAttribute("user", user);
				response.sendRedirect("all.do");
			}else {
				out.print("<script>alert('µÇÂ¼Ê§°Ü£¬ÇëÊäÈëÕýÈ·ÕË»§ÃÜÂë');location.href='newlogin.jsp'</script>");
			}
		}else if("manlogin".equals(type)){
			if(manager!=null){
				session.setAttribute("user", manager);
				response.sendRedirect("user.do?type=main");
			}else {
				out.print("<script>alert('µÇÂ¼Ê§°Ü£¬ÇëÊäÈëÕýÈ·ÕË»§ÃÜÂë');location.href='manlogin.jsp'</script>");
			}
		}else if("main".equals(type)){
			Manager m1 = (Manager)session.getAttribute("user");
			if(m1 != null){
				List<User> list = ud.findAll(null);
				request.setAttribute("list", list);
				request.getRequestDispatcher("user.jsp").forward(request, response);
			}else{
				out.print("<script>alert('Î´µÇÂ¼');location.href='manlogin.do'</script>");
			}
		}else if("del".equals(type)){
			Manager m1 = (Manager)session.getAttribute("user");
			if(m1 != null){
				int userId=Integer.parseInt(request.getParameter("userId"));
				if(ud.delete(userId)){
					out.print("<script>alert('É¾³ý³É¹¦.');location.href='user.do?type=main'</script>");
				}else{
					out.print("<script>alert('Î´É¾³ý.');location.href='user.do?type=main'</script>");
				}
			}else {
				out.print("<script>alert('Î´µÇÂ¼');location.href='manlogin.do'</script>");
			}
		}else if("findById".equals(type)){
			Manager m1 = (Manager)session.getAttribute("user");
			if(m1 != null){
				User user2 = ud.findAll(request.getParameter("userId")).get(0);
				request.setAttribute("usertoupdate", user2);
				request.getRequestDispatcher("userupdate.jsp").forward(request, response);
			}else{
				out.print("<script>alert('Î´µÇÂ¼');location.href='manlogin.do'</script>");
			}
		}else if("update".equals(type)){
			Manager m1 = (Manager)session.getAttribute("user");
			if(m1 != null){
				if(ud.update(new User(1, request.getParameter("userName"), null, Integer.parseInt(request.getParameter("userRole"))))){
					out.print("<script>alert('ÐÞ¸Ä³É¹¦.');location.href='user.do?type=main'</script>");
				}else{
					out.print("<script>alert('ÐÞ¸ÄÊ§°Ü.');location.href='user.do?type=main'</script>");
				}
			}else{
				out.print("<script>alert('Î´µÇÂ¼');location.href='manlogin.do'</script>");
			}
		}else if("add".equals(type)){
			Manager m1 = (Manager)session.getAttribute("user");
			if(m1 != null){
				if(ud.add(new User(0, request.getParameter("userName"),request.getParameter("password"),
						Integer.parseInt(request.getParameter("userRole"))))){
					out.print("<script>alert('Ìí¼Ó³É¹¦.');location.href='user.do?type=main'</script>");
				}else{
					out.print("<script>alert('Ìí¼ÓÊ§°Ü.');location.href='user.do?type=main'</script>");
				}
			}else{
				out.print("<script>alert('ÐÞ¸ÄÊ§°Ü.');location.href='user.do?type=main'</script>");
			}
		}
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
