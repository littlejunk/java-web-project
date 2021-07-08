package com.my.medicinemanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.my.medicinemanage.services.SheService;
import com.my.medicinemanage.services.SheServiceIml;

public class TotalServlet extends HttpServlet {
	MedService ms = new MedServiceIml();
	SheService ss = new SheServiceIml();
	public TotalServlet() {
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
			if("medicine".equals(type)){
				List<Medicine> list = ms.findAll(null);
				out.print(JSON.toJSONString(list));
			}else if("shelve".equals(type)){
				List<Shelve> list = ss.findAll(null);
				out.print(JSON.toJSONString(list));
			}else if ("findshelvetoadd".equals(type)) {
				if(user.getUserRole()==0){
					List<Shelve> list = ss.findAll(null);
					out.print(JSON.toJSONString(list));
				}else{
					out.print("-1");
				}
			}else if("medicinedel".equals(type)){
				if(user.getUserRole()==0){
					String medId = request.getParameter("medId");
					if(ms.delete(medId)){
						out.print("1");
					}else{
						out.print("0");
					}
				}else {
					out.print("-1");
				}
			}else if("medicineadd".equals(type)){
				if(user.getUserRole()==0){
					String medName = request.getParameter("medName");
					float medPrice = Float.parseFloat(request.getParameter("medPrice"));
					int medNum = Integer.parseInt(request.getParameter("medNum"));
					int sheId = Integer.parseInt(request.getParameter("sheId"));
					String production = request.getParameter("production");
					String sheLife = request.getParameter("sheLife");
					if(ms.add(new Medicine(0, medName, medPrice, medNum, production, sheLife, sheId))){
						out.print("1");
					}else{
						out.print("0");
					}
				}else {
					out.print("-1");
				}
			}else if("findmedtoupdate".equals(type)){
				if(user.getUserRole()==0){
					Medicine medicine = ms.findAll(request.getParameter("medId")).get(0);
					List<Shelve> list = ss.findAll(null);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("list", list);
					map.put("medicine", medicine);
					out.print(JSON.toJSONString(map));
				}else {
					out.print("-1");
				}
			}else if("medicineupdate".equals(type)){
				if(user.getUserRole()==0){
					Medicine medicine = ms.findAll(request.getParameter("medId")).get(0);
					float medPrice = Float.parseFloat(request.getParameter("medPrice"));
					int medNum = Integer.parseInt(request.getParameter("medNum"));
					int sheId = Integer.parseInt(request.getParameter("sheId"));
					medicine.setMedPrice(medPrice);
					medicine.setMedNum(medNum);
					medicine.setSheId(sheId);
					if(ms.update(medicine)){
						out.print("1");
					}else{
						out.print("0");
					}
				}else {
					out.print("-1");
				}
			}else if("shelvedel".equals(type)){
				if(user.getUserRole()==0){
					int sheId=Integer.parseInt(request.getParameter("sheId"));
					if(ss.delete(sheId)){
						out.print("1");
					}else{
						out.print("0");
					}
				}else{
					out.print("-1");
				}
			}else if("shelveadd".equals(type)){
				if(user.getUserRole()==0){
					String sheName = request.getParameter("sheName");
					int sheCap = Integer.parseInt(request.getParameter("sheCap"));
					if(ss.add(new Shelve(0, sheCap, sheName))){
						out.print("1");
					}else {
						out.print("0");
					}
				}else {
					out.print("-1");
				}
			}else if("findshetoupdate".equals(type)){
				if(user.getUserRole()==0){
					Shelve shelve = ss.findAll(request.getParameter("sheId")).get(0);
					out.print(JSON.toJSONString(shelve));
				}else{
					out.print("-1");
				}
			}else if("sheupdate".equals(type)){
				if(user.getUserRole()==0){
					Shelve shelve = ss.findAll(request.getParameter("sheId")).get(0);
					String sheName = request.getParameter("sheName");
					shelve.setSheName(sheName);
					if(ss.update(shelve)){
						out.print("1");
					}else {
						out.print("0");
					}
				}else{
					out.print("-1");
				}
			}else if("findByKey".equals(type)){
				if(!"".equals(request.getParameter("keyword"))){
					List<Medicine> list = ms.findByKey(request.getParameter("keyword"));
					out.print(JSON.toJSONString(list));
				}
			}else if("findnotuse".equals(type)){
				List<Medicine> list = ms.findNotuse();
				out.print(JSON.toJSONString(list));
			}else if("delnotuse".equals(type)){
				if(user.getUserRole()==0){
					boolean flag = false;
					List<Integer> list = toInt(request.getParameter("ids"));
					for(int i=0;i<list.size();i++){
						if(!ms.delete(" "+list.get(i))){
							flag = true;
							break;
						}
					}
					if(flag){
						out.print("0");
					}else{
						out.print("1");
					}
				}else{
					out.print("-1");
				}
			}else if(type==null) {
				out.print("<script>location.href='new.jsp'</script>");
			}
		}else{
			out.print("<script>alert('Î´µÇÂ¼£¡');location.href='newlogin.jsp'</script>");
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}
	public List<Integer> toInt(String s){
		List<Integer> list = new ArrayList<Integer>();
		String[] s1 = s.split("a");
		for(int i=0;i<s1.length;i++){
			if(!"".equals(s1[i])){
				list.add(Integer.parseInt(s1[i]));
			}
		}
		return list;
	}

}
