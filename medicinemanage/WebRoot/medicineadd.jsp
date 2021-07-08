<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>药品增加</title>
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
     <h1>增加药品</h1>
     <form action="med.do?type=add" method="post">
       名称：<input type="text" name="medName" id="medName"><br>
        价格：<input type="text" name="medPrice" id="medPrice" ><br>
        数量：<input type="text" name="medNum" id="medNum" ><br>
        保质期至：<input type="date" name="sheLife" id="sheLife" ><br>
        生产商：<input type="text" name="production" id="production"><br>
      药品货架：<select name="sheId">
           <c:forEach items="${shelves}" var="s">
            <option  value="${s.sheId}" >${s.sheName}剩余容量：${s.sheCurrentCap}</option>
           </c:forEach>
           </select><br>
          <input type="button" value="提交" onclick="sub()">
     </form>
  </body>
  </html>