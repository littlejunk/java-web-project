$(function(){
	window.onload = function () {
		showmedicine();
		var flag = true;
		var liC = document.querySelectorAll(".navBox li h2");
		// 主导航nav点击事件
		for (var i = 0; i < liC.length; i++) {
			liC[i].onclick = function () {
				if (flag) {
					// 节流阀
					flag = false;
					setTimeout(function () {
						flag = true;
					}, 500);
					// 自点
					if (this.className === "obFocus") {
						this.querySelector("i").classList.remove("arrowRot");
						getNext(this).style.height = "0";
						this.classList.add("obtain");
						this.classList.remove("obFocus");
						return
					}

					var sec = getNext(this);
					var sib = siblings(sec.parentNode);
					var otherArr = [];
					var arrowClass = [];
					// 排他 secondary arrowRot obFocus
					for (var j = 0; j < sib.length; j++) {
						var sibSec = sib[j].getElementsByTagName('*');
						for (var i = 0; i < sibSec.length; i++) {
							if (sibSec[i].className == "secondary") {
								otherArr.push(sibSec[i]);
							}
							if (sibSec[i].className == "arrowRot") {
								arrowClass.push(sibSec[i]);
							}
							if (sibSec[i].className == "obFocus") {
								sibSec[i].classList.remove("obFocus");
								sibSec[i].classList.add("obtain");

							}
						}
					}
					for (var i = 0; i < otherArr.length; i++) {
						otherArr[i].style.height = "0";
					}
					if (arrowClass[0]) {
						arrowClass[0].classList.remove("arrowRot");
					}

					// 留自己
					sec.style.height = 2.5078 + "rem";
					this.getElementsByTagName("i")[0].classList.add("arrowRot");
					this.classList.remove("obtain");
					this.classList.add("obFocus");
				}

			};
		}

		// 子导航点击事件
//		var seconC = document.querySelectorAll(".secondary h3");
//		for (var i = 0; i < seconC.length; i++) {
//			seconC[i].onclick = function () {
//				for (var i = 0; i < seconC.length; i++) {
//					seconC[i].classList.remove("seconFocus");
//				}
//				this.classList.add("seconFocus");
//			}
//		}
//
//	 }

	$(".medicine").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		showmedicine();
		});
	$(".medicineadd").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		medicineadd();
		});
	$(".shelve").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		showshelve();
		});
	$(".shelveadd").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		shelveadd();
		});
	$(".findmedicine").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		findByKey();
		});
	$(".findnotuse").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		findnotuse();
		});
	$(".zhuxiao").live('click',function(){
		var seconC = document.querySelectorAll(".secondary h3");
		for (var i = 0; i < seconC.length; i++) {
			seconC[i].classList.remove("seconFocus");
		}
		this.classList.add("seconFocus");
		reset();
		$.post("user.do",{"type":"zhuxiao"},back,"Text");
		function back(data){
			window.location.href="newlogin.jsp";
		}
		});
	$(".rdel").live("click",function(){
		if(confirm("是否删除？")){
			var medId = $(this).attr("medId");
			$.post("all.do",{"type":"medicinedel","medId":medId},back,"Text");
			function back(data){
				if(data=='-1'){
					alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				}else if(data=='1'){
			    	alert('删除成功');
			    }else if(data=='0'){
			    	alert('删除失败');
			    }
			    reset();
			    showmedicine();
			}
		}
	});
	$(".sdel").live("click",function(){
		if(confirm("是否删除？该货架所有药品都将被删除！")){
			var sheId = $(this).attr("sheId");
			$.post("all.do",{"type":"shelvedel","sheId":sheId},back,"Text");
			function back(data){
				if(data=='-1'){
					alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				}else if(data=='1'){
			    	alert('删除成功');
			    }else if(data=='0'){
			    	alert('删除失败');
			    }
			    reset();
		    	showshelve();
			}
		}
	});
	$("#medicineaddsub").live("click",function(){
		var medName = $("#medName").val();
		var medNum = $("#medNum").val();
		var medPrice = $("#medPrice").val();
		var sheLife = $("#sheLife").val();
		var sheId = $("#sheId").val();
		var production = $("#production").val();
		$.post("all.do",{"type":"medicineadd","medName":medName,"medNum":medNum,
			"medPrice":medPrice,"sheLife":sheLife,"sheId":sheId,"production":production},back,"Text");
		function back(data){
			if(data =='1'){
				alert('添加成功');
				reset();
				showmedicine();
			}else if(data=='0'){
				alert('添加失败,查看容量是否足够');
				reset();
				showmedicine();
			}else if(data=='-1'){
				alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				reset();
				showmedicine();
			}
		}
	});
	$("#shelveaddsub").live("click",function(){
		var sheName = $("#sheName").val();
		var sheCap = $("#sheCap").val();
		$.post("all.do",{"type":"shelveadd","sheName":sheName,"sheCap":sheCap},back,"Text");
		function back(data){
			if(data =='1'){
				alert('添加成功');
				reset();
				showshelve();
			}else if(data=='0'){
				alert('添加失败');
				reset();
				showshelve();
			}else if(data=='-1'){
				alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				reset();
				showshelve();
			}
		}
	});
	$("#medicineupdatesub").live("click",function(){
		var medId = $("#medId").val();
		var medNum = $("#medNum").val();
		var medPrice = $("#medPrice").val();
		var sheId = $("#sheId").val();
		$.post("all.do",{"type":"medicineupdate","medNum":medNum,"medPrice":medPrice,"sheId":sheId,
			"medId":medId},back,"Text");
		function back(data){
			if(data =='1'){
				alert('修改成功');
				reset();
				showmedicine();
			}else if(data=='0'){
				alert('修改失败,查看货架容量是否足够');
				reset();
				showmedicine();
			}else if(data=='-1'){
				alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				reset();
				showmedicine();
			}
		}
	});
	$("#sheupdatesub").live("click",function(){
		var sheId = $("#sheId").val();
		var sheName = $("#sheName").val();
		$.post("all.do",{"type":"sheupdate","sheId":sheId,"sheName":sheName},back,"Text");
	    function back(data){
	    	if(data=='1'){
	    		alert('修改成功');
	    		reset();
	    		showshelve();
	    	}else if(data=='0'){
	    		alert('修改失败');
	    		reset();
	    		showshelve();
	    	}else if(data=='-1'){
	    		alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
	    		reset();
	    		showshelve();
	    	}
	    }
	});
	$(".rupdate").live("click",function(){
			var medId = $(this).attr("medId");
			$.post("all.do",{"type":"findmedtoupdate","medId":medId},back,"Json");
			function back(data){
				data = JSON.parse(data);
				if(data == '-1'){
					alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
				}else{
					reset();
					var s =("<div id='medicineupdate'><h1>修改药品信息</h1><form action='med.do?type=update' method='post'>"
      +"药品编号：<input type='text' readonly='on' id='medId' value='"+data["medicine"]["medId"]+"'><br>"
      +"名称：<input type='text' readonly='on' id='medName' value='"+data["medicine"]["medName"]+"'><br>"
      +"价格：<input type='text' id='medPrice' value='"+data["medicine"]["medPrice"]+"'><br>"
      +"数量：<input type='text' id='medNum' value='"+data["medicine"]["medNum"]+"'><br>"
      +"货架：<select id='sheId'>");
					for(var i=0;i<data["list"].length;i++){
						if(data["medicine"]["sheId"]==data["list"][i]["sheId"]){
							s += ("<option selected value='"+data["list"][i]["sheId"]
							+"' >"+data["list"][i]["sheName"]+"剩余容量"+data["list"][i]["sheCurrentCap"]+"</option>");
						}else{
							s += ("<option value='"+data["list"][i]["sheId"]
							+"' >"+data["list"][i]["sheName"]+"剩余容量"+data["list"][i]["sheCurrentCap"]+"</option>");
						}
					}
					s += ("</select><br><input type='button' value='提交' id='medicineupdatesub'></form></div>");
					var $node =$(s);
				    $("#content").append($node);
				}
			}
		});
	
	};
	$(".supdate").live("click",function(){
		var sheId = $(this).attr("sheId");
		reset();
		$.post("all.do",{"type":"findshetoupdate","sheId":sheId},back,"Json");
		function back(data){
			data = JSON.parse(data);
			if(data=='-1'){
				alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
			}else{
			var s = (" <div id='shelveupdate'><h1>修改货架</h1><form action='all.do?type=sheupdate' method='post'>"
             +"货架编号：<input type='text'  name='sheId' readonly='on' id='sheId' value='"+data["sheId"]+"'/><br>"
    	+"货架名称：<input type='text' name='sheName' id='sheName' value='"+data["sheName"]+"'/> <br>"
    	+"<input type='button' id='sheupdatesub' value='提交'/> <input type='reset'/><br></form></div>");
			var $node =$(s);
		    $("#content").append($node);
		}
		}
	});
	//调节菜单高度
	var mh = window.innerHeight-75;
	document.getElementById('menu').style.height = mh + 'px';
	//调节内容高度
	var ch = window.innerHeight-75;
	var cw = window.innerWidth-275;
	document.getElementById('content').style.height = ch +'px';
	document.getElementById('content').style.width = cw +'px';

	function getByClass(clsName, parent) {
		var oParent = parent ? document.getElementById(parent) : document,
				boxArr = new Array(),
				oElements = oParent.getElementsByTagName('*');
		for (var i = 0; i < oElements.length; i++) {
			if (oElements[i].className == clsName) {
				boxArr.push(oElements[i]);
			}
		}
		return boxArr;
	}
//	获取下一个兄弟元素
	function getNext(node) {
		if (!node.nextSibling) return null;
		var nextNode = node.nextSibling;
		if (nextNode.nodeType == 1) {
			return nextNode;
		}
		return getNext(node.nextSibling);
	}

//	获取除了自己以外的其他亲兄弟元素
	function siblings(elem) {
		var r = [];
		var n = elem.parentNode.firstChild;
		for (; n; n = n.nextSibling) {
			if (n.nodeType === 1 && n !== elem) {
				r.push(n);
			}
		}
		return r;
	}
	function reset(){
		$("#content").empty();
	}
	function showmedicine(){
		$.post("all.do",{"type":"medicine"},back,"Json");
		function back(data){
			data = JSON.parse(data);
				//追加到div当中
			  
			    var s =("<div id='medicine'><table><tr><i><td>药品编号</td><td>名称</td><td>价格</td><td>剩余数量</td>"
			           +"<td>生产商</td><td>保质期至</td><td>货架</td></i></tr>"); 	
				for(var i=0;i<data.length;i++){
					//1:创建节点
					s += (
							"<tr><td>"+data[i]["medId"]+"</td><td>"+data[i]["medName"]
	  						+"</td><td>"+data[i]["medPrice"]+"</td><td>"+data[i]["medNum"]+"</td><td>"
	  						+data[i]["production"]+"</td><td>"
	  						+data[i]["sheLife"]+"</td><td>"+data[i]["shelve"]["sheName"]
	  						+"</td><td>"
	  						+"<v class='rdel' medId='"+data[i]["medId"]+"'>删除</v></td>"
	  						+"<td><v class='rupdate' medId='"+data[i]["medId"]+"'>修改</v></td>"
	  						+"</tr>"
					);	
				}
				s +=("</table> </div>");
				var $node =$(s);
			    $("#content").append($node);
		}
	}
	function showshelve(){
		$.post("all.do",{"type":"shelve"},back,"Json");
		function back(data){
			data = JSON.parse(data);
				//追加到div当中
			  
			    var s =( "<div id='shelve'><table><tr><i><td>货架编号</td><td>货架名称</td><td>容量</td>"
	                  +"<td>剩余容量</td></i></tr>"); 	
				for(var i=0;i<data.length;i++){
					//1:创建节点
					s += (
							"<tr><td>"+data[i]["sheId"]+"</td><td>"+data[i]["sheName"]
	  						+"</td><td>"+data[i]["sheCap"]+"</td><td>"+data[i]["sheCurrentCap"]+"</td>"
	  					    +"<td>"+"<v class='sdel' sheId='"+data[i]["sheId"]+"'>删除</v></td>"
	  						+"<td><v class='supdate' sheId='"+data[i]["sheId"]+"'>修改</v></td>"
	  						+"</tr>"
					);	
				}
				s +=("</table> </div>");
				var $node =$(s);
			    $("#content").append($node);
		}
	}
	
	function medicineadd(){
		$.post("all.do",{"type":"findshelvetoadd"},back,"Json");  
		function back(data){
			data = JSON.parse(data);
			if(data=='-1'){
				alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
			}else{
			 var s =("<div id='medicineadd'><h1>增加药品</h1><form action='med.do?type=add' method='post'>"
				      +"名称：<input type='text' name='medName' id='medName'><br>"
				      +" 价格：<input type='text' name='medPrice' id='medPrice' ><br>"
				       +"数量：<input type='text' name='medNum' id='medNum' ><br>"
				       +"保质期至：<input type='date' name='sheLife' id='sheLife' ><br>"
				       +"生产商：<input type='text' name='production' id='production' ><br>"
				     +"药品货架：<select id='sheId'>");
			for(var i=0;i<data.length;i++){
				//1:创建节点
				s += ("<option  value='"+data[i]["sheId"]+"' >"
						+data[i]["sheName"]+"剩余容量："+data[i]["sheCurrentCap"]+"</option>");	
			}
			 s +=(" </select><br>"+"<input type='button' value='提交' id='medicineaddsub'>"+"</form></div>");
			 var $node =$(s);
			 $("#content").append($node);
		}
		}
	}
	
	function shelveadd(){
		var s =( "<div id='shelveadd'><h1>增加货架</h1><form action='she.do?type=add' method='post'>"
	    	+"货架名称：<input type='text' name='sheName' id='sheName'/> <br>"
	        +"货架容量：<input type='text' name='sheCap' id='sheCap'/>"
	    	+"<input  type='button' value='提交' id='shelveaddsub'/> <input type='reset'/><br>"
	        +"</form></div>");
		 var $node =$(s);
		 $("#content").append($node);
	}
	
	function findByKey(){
		var s = (" <div id='findmedicine'><div id='stitle'>快捷搜索"
            +"<input placeholder='输入药名或者货架名关键字' type='text' name='skey' id='skey' style='width: 250px; margin-left:20px; height:25px; border-radius: 5px;'>"  
            +"</div><div id='sresult' style='text-align: center;'><table id='rtable'><tr>"
            +"<td>编号</td><td>名称</td><td>价格</td><td>数量</td><td>货架</td><td>保质期至</td>"
            +"</tr><br></table></div></div>");
		 var $node =$(s);
		 $("#content").append($node);
	}
	$("#skey").live("input propertychange",function(){
			findbykey();
	});
	function findbykey(){
			var key = document.getElementById("skey").value;
			$.post("all.do?type=findByKey",{"keyword":key},back,"Json");
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
	function findnotuse(){
		var s =("<div id='notuse'><div style='text-align: center; font-weight: bolder; color: red;'>"
        +"以下药品将在三个月内过期，建议进行处理</div><div style='margin-left: 220px;'>"
        +"<table id='ntable'><tr>"
        +"<td>编号</td><td>名称</td><td>价格</td><td>数量</td><td>货架</td><td>保质期至</td><td>是否删除</td>"
        +"</tr><br></table><input style='margin-top: 20px; margin-left: 300px;  width: 100px; height: 40px;' type='button' value='删除' id='delnotuse'>"
        +"</div></div>");
		var $node =$(s);
		$("#content").append($node);
		find2();
	}
	
	function find2(){
			$.post("all.do",{"type":"findnotuse"},back,"Json");
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
						+ "<td><input name='delid' type='checkbox' value='"+ data[i]["medId"]
					    +"' style='width:20px; height:20px;'></td>"
						+"</tr>"
						);
						//2:追加节点
						$("#ntable").append($node);
					}
		  		  }	
		}
	$("#delnotuse").live("click",function(){
		var flag = false;
        var delId = document.getElementsByName("delid");
        for(var i=0;i<delId.length;i++){
           if(delId[i].checked){
               flag = true;
               break;
           }
        }
        var arr4="a";
        for(var i=0;i<delId.length;i++){
            if(delId[i].checked){
               arr4 +=(delId[i].value+"a");
            }
         }
        if(flag){
           if(confirm("确实要删除吗？")){
        	   $.post("all.do",{"type":"delnotuse","ids":arr4},back,"Text");
        	   function back(data){
        		   if(data=='0'){
        			   alert('删除错误');
        			   reset();
        			   findnotuse();
        		   }
        		   if(data=='1'){
        			   alert('删除成功');
        			   reset();
        			   findnotuse();
        		   }
        		   if(data=='-1'){
        			   alert('您当前不是最高管理员，申请权限或者登录最高管理员账号.');
        			   reset();
        			   findnotuse();
        		   }
        	   }
               //document.getElementsByTagName("form")[0].submit();
           }
        }else{
           alert("请选择要删除的药品！");
           return;
        }
	});
});

