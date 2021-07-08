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
    
    <title>修改货架</title>
     <script type="text/javascript">
         function sub(){
            var sheId = document.getElementById("sheId").value;
            if(isNaN(sheId)){
                alert("请输入正确数字");
                return;
            }
            if(sheId<=0){
                alert("请输入正确范围数字");
                return;
            }
            document.getElementsByTagName("form")[0].submit();
         }
    </script>
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
  <h1>修改货架</h1>
     <form action="she.do?type=update" method="post">
             货架编号：<input type="text"  name="sheId" readonly="on" id="sheId" value="${shelve.sheId}"/> <br>
    	货架名称：<input type="text" name="sheName" id="sheName" value="${shelve.sheName}"/> <br>
    	<input type="submit"/> <input type="reset"/><br>
    </form>
  </body>
</html>
