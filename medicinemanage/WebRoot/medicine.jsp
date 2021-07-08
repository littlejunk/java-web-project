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
    
    <title>所有药品</title>
    
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
     <table>
          <tr>
            <i><td>药品编号</td>
             <td>名称</td>
              <td>价格</td>
               <td>剩余数量</td>
               <td>生产商</td>
               <td>保质期至</td>
                <td>货架</td></i>
          </tr>
       <c:forEach items="${list}" var="s">
           <tr>
             <td>${s.medId}</td>
             <td>${s.medName}</td>
             <td>${s.medPrice}</td>
             <td>${s.medNum}</td>
             <td>${s.production}</td>
             <td>${s.sheLife}</td>
             <td>${s.shelve.sheName}</td>
             <td><a href="javascript:if(confirm('是否删除？')){location.href='med.do?type=del&medId=${s.medId}'}">删除</a></td>
             <td><a href="med.do?type=findById&medId=${s.medId}">修改</a></td>
         </tr>
       </c:forEach>
     </table>
     <br>
     <div id="goshe">货架管理</div>
    <div id="add">增加药品</div>
    <div id="returnmain">返回主页</div>
  </body>
  <script>
    var goshe = document.getElementById('goshe');
    var add = document.getElementById('add');
    var returnmain = document.getElementById('returnmain');
    add.onclick = function(){
        location.href="med.do?type=findByIdd";
    }
    goshe.onclick = function(){
        location.href="she.do";
    }
    returnmain.onclick = function(){
        location.href="med.do?type=main";
    }
    
</script>
</html>
