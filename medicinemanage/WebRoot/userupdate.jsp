<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户权限</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
	<style type="text/css">
	 body{
            background-color: rgb(161, 223, 252);
        }
	    h1{
            border :1px solid black;
			text-align: center;
			margin-left: 40%;
			width: 20%;
        }
	
		form {
			width: 20%;
			height: 28%;
			margin-left: 40%;
			margin-top: 2%;
			font-size: 20px
		}
	
		form, td {
			border :1px solid black;
			text-align: center;
		}
		h1{
		 font-size:20px;
		}
	</style>
  </head>
  
  <body>
  <h1>修改用户权限</h1>
     <form action="user.do?type=update" method="post">
             用户名：<input type="text"  name="userName" readonly="on" id="userName" value="${usertoupdate.userName}"/> <br>
    	用户权限
    	<select name="userRole">
    	 <c:choose>
              <c:when test="${usertoupdate.userRole=='0'}">
                 <option selected value="0" >权限：增删改查</option>
                 <option value="1" >权限：查</option>
              </c:when>
              <c:otherwise>
                  <option value="0" >权限：增删改查</option>
                  <option  selected value="1" >权限：查</option>
              </c:otherwise>
            </c:choose>
    	</select> 
    	<br>
    	<input type="submit"/> <input type="reset"/><br>
    </form>
  </body>
</html>
