<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
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
        html{
           background-image: url(images/loginbg.jpg);
           background-repeat: no-repeat;
           height: 100%;
           background-size:100% 100%;
        }
        #title{
            margin-top: 200px;
            font-size: 2em;
            text-align: center;
            color: rgb(251, 251, 255);
            letter-spacing: 10px;
            font-weight: bolder;
        }
        .input{
            width: 300px;
            height: 40px;
            border-radius: 10px;


        }
        .input:focus{
        border: 2px solid #4e6ef2;
        }
        #button{
            width: 100px;
            height: 40px;
            border-radius: 10px;
            color: white;
            margin-left: 700px;
            letter-spacing:10px;
            margin-top: 20px;
            background-color: rgb(103, 168, 253);
            font-weight: bolder;
        }
    </style>
	
  </head>
  
  <body>
    <form action="user.do?type=manlogin" method="post">
    <div id="title">管理员登录</div>
    <div style=" margin-left: 550px;margin-top: 50px;font-size: 20px;">用户名<input type="text" name="user" class="input" placeholder="请输入用户名"></div>
    <div style=" margin-left: 550px;margin-top: 20px;font-size: 20px;">密码<input type="password" name="pwd" class="input"
        style="margin-left: 19px;" placeholder="请输入密码"> </div>
    <input type="button" id="button" value="登录" onclick="sub()" style="margin-left:690px">
    </form>
  </body>
</html>
