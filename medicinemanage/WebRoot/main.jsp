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
    <title>药房药品管理系统</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
   <script type="text/javascript">
  	$(function(){
  		function find(){
	  			var key = document.getElementById("skey").value;
	  			$.post("med.do?type=findByKey",{"keyword":key},back,"Json");
	  			function back(data){
	  		  		//将字符串转换成JSON对象
	  					data = JSON.parse(data);
	  					//清除数据保留第一行
	  					$("#rtable tr").not("tr:first").remove();
	  					//追加到table当中
	  					for(var i=0;i<data.length;i++){
	  						//1:创建节点
	  						var $node = $("<tr><td>"+data[i]["medId"]+"</td><td>"+data[i]["medName"]
	  						+"</td><td>"+data[i]["medPrice"]+"</td><td>"+data[i]["medNum"]+"</td><td>"
	  						+data[i]["shelve"]["sheName"]+"</td><td>"+data[i]["sheLife"]
	  						+"</td><td>"
	  						+"<v class='rdel' medId='"+data[i]["medId"]+"'>删除</v></td>"
	  						+"<td><v class='rupdate' medId='"+data[i]["medId"]+"'>修改</v></td>"
	  						+"</tr>");
	  						//2:追加节点
	  						$("#rtable").append($node);
	  					}
	  		  		  }	
	  		}
  		function find1(){
  			$.post("med.do",{"type":"findnotuse"},back,"Json");
  			function back(data){
  		  		//将字符串转换成JSON对象
  					data = JSON.parse(data);
  					//清除数据保留第一行
  					$("#ntable tr").not("tr:first").remove();
  					//追加到table当中
  					for(var i=0;i<data.length;i++){
  						//1:创建节点
  						var $node = $(
  					    "<tr><td>"+data[i]["medId"]+"</td><td>"+data[i]["medName"]
  						+"</td><td>"+data[i]["medPrice"]+"</td><td>"+data[i]["medNum"]+"</td><td>"
  						+data[i]["shelve"]["sheName"]+"</td><td>"+data[i]["sheLife"]+"</td>"
  						+ "<td><input name='delid' type='checkbox' value='"+ data[i]["medId"]+"'></td>"
  						+"</tr>"
  						);
  						//2:追加节点
  						$("#ntable").append($node);
  					}
  		  		  }	
  		}
  		$("#skey").live('input propertychange',function(){
  			find();
  			find1();
  		});
  		$(".rdel").live("click",function(){
			if(confirm("是否删除？")){
    			var medId = $(this).attr("medId");
				$.post("med.do",{"type":"ajaxdel","medId":medId},back,"Text");
				function back(data){
					if(data=='0'){
						alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
					}
					find();
					find1();
				}
			}
		});
  		$(".rupdate").live("click",function(){
  			var medId = $(this).attr("medId");
  			$.post("med.do",{"type":"ajaxfindById","medId":medId},back,"Text");
  			function back(data){
  				if(data == '0'){
  					alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
  				}else{
  					window.location.href="med.do?type=findById&medId="+medId+"&rt=yes";
  				}
  				find();
  				find1();
  			}
  		});
  	});
  </script>
    <script type="text/javascript">
         function sub(){
            var flag = false;
            var delId = document.getElementsByName("delid");
            for(var i=0;i<delId.length;i++){
               if(delId[i].checked){
                   flag = true;
                   break;
               }
            }
            if(flag){
               if(confirm("确实要删除吗？")){
                   document.getElementsByTagName("form")[0].submit();
               }
            }else{
               alert("请选择要删除的药品！");
               return;
            }
           
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
        .go1{
         position: absolute;
         left: 200px;
         font-size: 20px;
         top: 100px;
         width: 200px;
         background-color: rgb(250, 139, 207);
         text-align: center;
         border-radius: 10px;
         border: rgb(0, 0, 0) 2px solid;
     }
     .go2{
         position: absolute;
         left: 200px;
         top: 150px;
         font-size: 20px;
         background-color: rgb(133, 245, 143);
         width: 200px;
         text-align: center;
         border-radius: 10px;
         border: rgb(0, 0, 0) 2px solid;
     }
     a{
         text-decoration: none;
         color: rgb(9, 8, 112);
     }
     table {
          border: rgb(0, 0, 0) 2px solid;
          width: 600px;
          font-size: 13px;
      }
      table,td{
          text-align: center;
      }
      #notuse{
          text-align: center;
          position: absolute;
          width: 600px;
          top: 100px;
          left: 800px;
      }
      #stitle{
          font-size: 1em;
          position: absolute;
          left: 210px;
          top: 230px;
      }
      #sresult{
          position: absolute;
          left: 100px;
          top: 250px;
      }
    </style>
  
  </head>
  
  <body>
      <div id="zhuxiao" style="position: absolute; background-color: red; width: 100px; height: 28px; text-align: center; border-radius: 5px;
      color:white;">
                        注销
    </div>
    <div style="font-size: 30px; text-align: center; font-weight: bolder; letter-spacing: 15px; margin-top: 15px;">
        欢迎进入药房药品管理系统
    </div>
   
    <div class="go1">
       <a href="med.do">药品管理</a>
    </div>
    <div class="go2">
        <a href="she.do">货架管理</a>
    </div>
    <div id="notuse">
        <div style="text-align: center; font-weight: bolder; color: red;">
            以下药品将在三个月内过期，建议进行处理
        </div>
      <form action="med.do?type=delnotuse" method="post">
      <table id="ntable">
          <tr>
              <td>编号</td>
              <td>名称</td>
              <td>价格</td>
              <td>数量</td>
              <td>货架</td>
              <td>保质期至</td>
              <td>是否删除</td>
          </tr>
          <c:forEach items="${list}" var="s">
           <tr>
             <td>${s.medId}</td>
             <td>${s.medName}</td>
             <td>${s.medPrice}</td>
             <td>${s.medNum}</td>
             <td>${s.shelve.sheName}</td>
             <td>${s.sheLife}</td>
             <td><input name="delid" type="checkbox" value="${s.medId}"></td>
         </tr>
         <br>
       </c:forEach>
       <br>
       </table>
       <input style="margin-top: 20px; width: 100px; height: 40px;" type="button" value="删除" onclick="sub()">
      </form>
    </div>
     <div id="stitle">
        快捷搜索
        <input placeholder="输入药名或者货架名关键字" type="text" name="skey" id="skey" style="width: 170px; height:25px; border-radius: 5px;">  
        </div>
     <div id="sresult" style="text-align: center;">
        <form action="med.do?type=delnotuse" method="post">
            <table id="rtable">
                <tr>
                    <td>编号</td>
                    <td>名称</td>
                    <td>价格</td>
                    <td>数量</td>
                    <td>货架</td>
                    <td>保质期至</td>
                </tr>
             <br>
             </table>
            </form>
     </div>
     <div id="account" style="font-weight: bolder;"></div>
  </body>
  <script type="text/javascript">
   var zhuxiao = document.getElementById('zhuxiao');
   var account = document.getElementById('account');
   if(${user.userRole}==0){
	   account.innerHTML = '欢迎，高级管理员';
   }else{
	   account.innerHTML = '欢迎，管理员';
   }
   zhuxiao.onclick = function(){
	   location.href="user.do?type=zhuxiao";
   };
  </script>
</html>
