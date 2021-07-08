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
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	      #goshe{
            position: fixed;
            top: 100px;
            left: 1300px;
            width: 150px;
            height: 30px;
            text-align: center;
            background-color:  rgb(50, 163, 255);
            padding-top: 10px;
            border-radius: 10px;
        }
        #add{
            position: fixed;
            padding-top: 10px;
            top: 142px;
            left: 1300px;
            width: 150px;
            height: 30px;
            text-align: center;
            border-radius: 10px;
            background-color: rgb(50, 163, 255);
        }
        #returnmain{
            position: fixed;
            padding-top: 10px;
            top: 184px;
            left: 1300px;
            width: 150px;
            height: 30px;
            text-align: center;
            border-radius: 10px;
            background-color:  rgb(50, 163, 255);
        }
	     body{
            background-color: rgb(161, 223, 252);
        }
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
      
  </body>
   <table>
          <tr>
            <i><td>用户编号</td>
             <td>用户名</td>
             <td>用户权限</td>
          </tr>
       <c:forEach items="${list}" var="s">
           <tr>
             <td>${s.userId}</td>
             <td>${s.userName}</td>
             <c:choose>
            <c:when test="${s.userRole=='0'}">
              <td>增删改查</td>
             </c:when>
            <c:otherwise>
              <td>查阅</td>
            </c:otherwise>
          </c:choose>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='user.do?type=del&userId=${s.userId}'}">删除</a></td>
             <td><a href="user.do?type=findById&userId=${s.userId}">修改</a></td>
         </tr>
       </c:forEach>
     </table>
     <br>
    
    <div id="add">增加用户</div>
  </body>
  <script>
   var add = document.getElementById('add');
    add.onclick = function(){
        location.href="useradd.jsp";
    }
</script>
</html>
