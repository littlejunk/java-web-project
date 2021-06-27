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
    
    <title>所有军械</title>
    
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
		#div1{
		   width:100%;
		   text-align:center;
		   font-size: 18px;
		}
    </style>

  </head>
  
  <body>
     <table>
          <tr>
            <i><td>军械编号</td>
             <td>名称</td>
              <td>弹药</td>
               <td>射程(米)</td>
               <td>类型编号</td>
                <td>类型名称</td></i>
          </tr>
       <c:forEach items="${list}" var="s">
           <tr>
             <td>${s.armId}</td>
             <td>${s.armName}</td>
             <td>${s.bullet}</td>
             <td>${s.shotRange}</td>
             <td>${s.typeId}</td>
             <td>${s.weaponType.typeName}</td>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='arm.do?type=del&armId=${s.armId}'}">删除</a></td>
             <td><a href="arm.do?type=findById&armId=${s.armId}">修改</a></td>
         </tr>
       </c:forEach>
       <tr> <td><a href="arm.do?type=findByIdd">增加军械</a></td></tr>
     </table>
     <br>
     <div id="div1">
         <a href="type.do">军械类型操作</a>
     </div>
  </body>
</html>
