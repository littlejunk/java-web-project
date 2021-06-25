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
    
    <title>所有学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
            <i><td>学生编号</td>
             <td>姓名</td>
              <td>年龄</td>
               <td>性别</td>
                <td>班级</td></i>
          </tr>
       <c:forEach items="${list}" var="s">
           <tr>
             <td>${s.stuId}</td>
             <td>${s.stuName}</td>
             <td>${s.stuAge}</td>
             <td>${s.stuSex}</td>
             <td>${s.classId}</td>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='usersb.do?type=del&stuId=${s.stuId}'}">删除</a></td>
             <td><a href="usersb.do?type=findById&stuId=${s.stuId}">修改</a></td>
         </tr>
       </c:forEach>
     </table>
  </body>
</html>
