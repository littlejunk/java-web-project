<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加花卉</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style>
		form {
			width: 20%;
			height: 28%;
			margin-left: 40%;
			margin-top: 15%;
			font-size: 20px
		}
	
		form, td {
			border :1px solid black;
			text-align: center;
		}
	</style>


  </head>
  
  <body>
    <form action="flower.do?type=add" method="post">
    	id：<input type="text" name="id" id="id"/> <br>
    	学名：<input type="text" name="name" id="name"/> <br>
    	野名：<input type="text" name="nickName" id="nickName"/> <br>
    	科属：<input type="text" name="property" id="property"/> <br>
    	价格：<input type="text" name="price" id="price"/> <br>
    	产地：<input type="text" name="production" id="production"/> <br>
    	<input type="submit"/> <input type="reset"/><br>
    </form>
  </body>
</html>
