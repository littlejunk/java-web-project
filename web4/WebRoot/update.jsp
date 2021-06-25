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
    
    <title>学生信息修改</title>
    
    <script type="text/javascript">
         function sub(){
            var stuName = document.getElementById("stuName").value;
            var stuAge = document.getElementById("stuAge").value;
            if(stuName.length<2||stuName.length>20){
                alert("名称错误");
                return;
            }
            if(isNaN(stuAge)){
                alert("请输入正确数字");
                return;
            }
            if(stuAge>100||stuAge<15){
                alert("请输入正确年龄");
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
     <h1>修改学员信息</h1>
     <form action="stu.do?type=update" method="post">
      <input type="hidden" name="stuId"  value="${stu.stuId}">
       学生姓名：<input type="text" name="stuName" id="stuName" value="${stu.stuName}"><br>
        学生年龄：<input type="text" name="stuAge" id="stuAge" value="${stu.stuAge}"><br>
         学生性别：
          <c:choose>
            <c:when test="${stu.stuSex=='男'}">
              <input type="radio" name="stuSex" checked="checked" value="男"> 男
              <input type="radio" name="stuSex" value="女">女
             </c:when>
            <c:otherwise>
              <input type="radio" name="stuSex" value="男">男
              <input type="radio" name="stuSex" checked="checked" value="女"> 女
            </c:otherwise>
          </c:choose>
         <br>
           学生所在班级：<select name="classId">
           <c:forEach items="${classes}" var="c">
           <c:choose>
              <c:when test="${c.classId==stu.classId}">
                 <option selected value="${c.classId}" >${c.className}</option>
              </c:when>
              <c:otherwise>
                  <option value="${c.classId}" >${c.className}</option>
              </c:otherwise>
            </c:choose>
           </c:forEach>
           </select><br>
          <input type="button" value="提交" onclick="sub()">
     </form>
  </body>
  </html></i>