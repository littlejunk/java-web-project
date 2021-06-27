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
            <i><td>军械类型编号</td>
             <td>军械名称</td>
                <td>是否可用</td></i>
          </tr>
       <c:forEach items="${list1}" var="s">
           <tr>
             <td>${s.typeId}</td>
             <td>${s.typeName}</td>
             <c:choose>
            <c:when test="${s.isUse==1}">
              <td>是</td>
             </c:when>
            <c:otherwise>
              <td>否</td>
            </c:otherwise>
          </c:choose>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='type.do?type=del&typeId=${s.typeId}'}">删除</a></td>
             <td><a href="type.do?type=findById&typeId=${s.typeId}">修改</a></td>
         </tr>
       </c:forEach>
          <tr> <td><a href="addtype.jsp">增加军械类型</a></td></tr>
     </table>
     <br>
     <div id="div1">
         <a href="arm.do">军械操作</a>
     </div>
  </body>
</html>
