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
    
    <title>所有货架</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
	       #gomed{
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
            <i><td>货架编号</td>
             <td>货架名称</td>
                <td>容量</td>
                <td>剩余容量</td></i>
          </tr>
       <c:forEach items="${list1}" var="s">
           <tr>
             <td>${s.sheId}</td>
             <td>${s.sheName}</td>
             <td>${s.sheCap}</td>
             <td>${s.sheCurrentCap}</td>
             <td><a href="javascript:if(confirm('是否删除？将会把该货架所有药品删除')){location.href='she.do?type=del&sheId=${s.sheId}'}">删除</a></td>
             <td><a href="she.do?type=findById&sheId=${s.sheId}">修改</a></td>
         </tr>
       </c:forEach>
     </table>
     <br>
     <div id="gomed">药品管理</div>
    <div id="add">增加货架</div>
    <div id="returnmain">返回主页</div>
  </body>
  <script>
    var gomed = document.getElementById('gomed');
    var add = document.getElementById('add');
    var returnmain = document.getElementById('returnmain');
    add.onclick = function(){
        location.href="shelveadd.jsp";
    }
    gomed.onclick = function(){
        location.href="med.do";
    }
    returnmain.onclick = function(){
        location.href="med.do?type=main";
    }
    
</script>
</html>
