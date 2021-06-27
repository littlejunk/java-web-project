<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改军械</title>
     <script type="text/javascript">
         function sub(){
            var typeId = document.getElementById("typeId").value;
            if(isNaN(typeId)){
                alert("请输入正确数字");
                return;
            }
            if(typeId<=0){
                alert("请输入正确范围数字");
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
   
	<style type="text/css">
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
			margin-top: 2%;
			font-size: 20px
		}
	
		form, td {
			border :1px solid black;
			text-align: center;
		}
		h1{
		 font-size:20px;
		}
	</style>
  </head>
  
  <body>
  <h1>修改军械类型</h1>
     <form action="type.do?type=update" method="post">
             <input type="hidden" name="typeId" id="typeId" value="${weapontype.typeId}"/> <br>
    	军械名称：<input type="text" name="typeName" id="typeName" value="${weapontype.typeName}"/> <br>
    	是否启用：   
    	<select name="isUse">
    	        <c:choose>
              <c:when test="${weapontype.isUse==1}">
                 <option selected value=1 >是</option>
                 <option  value=0 >否</option>
              </c:when>
              <c:otherwise>
                  <option selected value=0 >否</option>
                  <option  value=1 >是</option>
              </c:otherwise>
            </c:choose>
    	
              
           </select><br>
    	<input type="submit"/> <input type="reset"/><br>
    </form>
  </body>
</html>
