<i><%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>军械信息增加</title>
    <script type="text/javascript">
         function sub(){
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

   <style>
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
			margin-top: 1%;
			font-size: 20px
		}
	
		form, td {
			border :1px solid black;
			text-align: center;
		}
	</style>

  </head>
  
  <body>
     <h1>增加军械信息</h1>
     <form action="arm.do?type=add" method="post">
      军械编号：<input type="text" name="armId"><br>
       军械名称：<input type="text" name="armName" id="armName"><br>
        弹药：<input type="text" name="bullet" id="bullet" ><br>
        射程：<input type="text" name="shotRange" id="shotRange" ><br>
      军械类型：<select name="typeId">
           <c:forEach items="${weapontype}" var="c">
            <option  value="${c.typeId}" >${c.typeName}</option>
           </c:forEach>
           </select><br>
          <input type="button" value="提交" onclick="sub()">
     </form>
  </body>
  </html></i>