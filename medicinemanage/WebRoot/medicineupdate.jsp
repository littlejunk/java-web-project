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
    
    <title>修改药品信息</title>
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
     <h1>修改药品信息</h1>
     <form action="med.do?type=update" method="post">
      药品编号：<input type="text" name="medId"  readonly="on"  value="${medicine.medId}"><br>
       名称：<input type="text" name="medName"  readonly="on"  id="medName" value="${medicine.medName}"><br>
        价格：<input type="text" name="medPrice" id="medPrice" value="${medicine.medPrice}"><br>
        数量：<input type="text" name="medNum" id="medNum" value="${medicine.medNum}"><br>
      货架：<select name="sheId">
           <c:forEach items="${shelves}" var="c">
           <c:choose>
              <c:when test="${c.sheId==medicine.sheId}">
                 <option selected value="${c.sheId}" >${c.sheName}剩余容量${c.sheCurrentCap}</option>
              </c:when>
              <c:otherwise>
                  <option value="${c.sheId}" >${c.sheName}剩余容量${c.sheCurrentCap}</option>
              </c:otherwise>
            </c:choose>
           </c:forEach>
           </select><br>
          <input type="button" value="提交" onclick="sub()">
     </form>
  </body>
  </html>