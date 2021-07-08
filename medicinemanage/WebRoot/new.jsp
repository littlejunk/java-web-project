<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>药房药品管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script src="js/adapter.js"></script> <!--rem适配js-->

<link rel="stylesheet" href="css/base.css"> <!--初始化文件-->
<link rel="stylesheet" href="css/menu.css"> <!--主样式-->
<link rel="stylesheet" href="css/bzd.css">
  </head>
  <body>
     <div id="title">
        药房药品管理系统
</div>
<div id="menu">
    <!--隐藏菜单-->
    <div id="ensconce">
        <h2>
            <img src="images/show.png" alt="">
            打开菜单栏
        </h2>
    </div>

    <!--显示菜单-->
    <div id="open">
        <div class="navH">
            菜单栏
            <span><img class="obscure" src="images/obscure.png" alt=""></span>
        </div>
        <div class="navBox">
            <ul>
                <li>
                    <h2 class="obtain">药品操作<i></i></h2>
                    <div class="secondary">
                        <h3 class="medicine">查看所有药品</h3>
                        <h3 class="medicineadd">增加药品</h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">货架操作<i></i></h2>
                    <div class="secondary">
                        <h3 class="shelve">查看货架</h3>
                        <h3 class="shelveadd">增加货架</h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">查询<i></i></h2>
                    <div class="secondary">
                        <h3 class="findmedicine">搜索药品</h3>
                        <h3 class="findnotuse">搜索即将过期药品</h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">登录操作<i></i></h2>
                    <div class="secondary">
                        <h3 class="zhuxiao">注销</h3>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="content">
   
</div>

<script src="js/menu.js"></script> <!--控制js-->
     
  </body>
</html>
