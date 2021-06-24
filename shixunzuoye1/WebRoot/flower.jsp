<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有花卉信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
    	table {
			border-collapse: collapse;
			width: 60%;
			margin-left: 20%;
			font-size: 18px;
		}
		table,td{
			border: 1px solid black;	
			text-align: center;
		}
    </style>
  </head>
  
  <body>
      <table>
          <tr>
            <i><td>花卉编号</td>
             <td>学名</td>
              <td>野名</td>
               <td>科属</td>
                <td>价格</td>
                <td>产地</td></i>
          </tr>
       <c:forEach items="${list1}" var="s">
           <tr>
             <td>${s.id}</td>
             <td>${s.name}</td>
             <td>${s.nickName}</td>
             <td>${s.property}</td>
             <td>${s.price}</td>
             <td>${s.production}</td>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='flower.do?type=del&id=${s.id}'}">删除</a></td>
         </tr>
       </c:forEach>
          <tr> <td><a href="addflower.jsp">增加花卉</a></td>></tr>
     </table>
  </body>
</html>
