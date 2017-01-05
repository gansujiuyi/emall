<%@ page language="java" import="java.util.*,com.jiuyi.jyplant.syscontrol.entity.Users" pageEncoding="UTF-8"%>
<jsp:directive.include file="/base/tag.inc" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	Users s_user = (Users) session.getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<jsp:include page="../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/main.js?ctx=<%=path%>"></script>
<link rel="stylesheet" href="<%=path%>/css/pwd.css" type="text/css">
<title>后台管理系统</title>
<script type="text/javascript">
	$(document).ready(function() {
		$(".header_content").css("backgroundImage","url(<%=path %>/images/baner.jpg)");
		startclock();
	});
	//显示时间
	var timerID = null;
	var timerRunning = false;
	function stopclock (){
		if(timerRunning)
		clearTimeout(timerID);
		timerRunning = false;
	}
	function startclock (){
		stopclock();
		showtime();
	}
	function showtime () {
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getMonth()+1;
		var date = now.getDate();
		var hours = now.getHours();
		var minutes = now.getMinutes();
		var seconds = now.getSeconds();
		var day = now.getDay();//星期
		var week = new Array('日','一','二','三','四','五','六');		
		var timeValue = year+"-"+(month<10 ? "0" + month : month)+"-"+(date<10 ? "0" + date : date)+"&nbsp;&nbsp;&nbsp;";
		timeValue += ((hours < 10) ? "0" : "") + hours;
		timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
		timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
		timeValue += "&nbsp;&nbsp;&nbsp;星期"+week[day];
		document.getElementById("datetime").innerHTML =timeValue;
		timerID = setTimeout("showtime()",1000);
		timerRunning = true;
	}
    </script> 
   <script type="text/javascript">
$(function () {
	initCahrt();
	
	$('#pass_1').keyup(function () { 
		var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g"); 
		var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g"); 
		var enoughRegex = new RegExp("(?=.{6,}).*", "g"); 
	
		if (false == enoughRegex.test($(this).val())) { 
			$('#level_1').removeClass('pw-weak'); 
			$('#level_1').removeClass('pw-medium'); 
			$('#level_1').removeClass('pw-strong'); 
			$('#level_1').addClass(' pw-defule'); 
			 //密码小于六位的时候，密码强度图片都为灰色 
		} 
		else if (strongRegex.test($(this).val())) { 
			$('#level_1').removeClass('pw-weak'); 
			$('#level_1').removeClass('pw-medium'); 
			$('#level_1').removeClass('pw-strong'); 
			$('#level_1').addClass(' pw-strong'); 
			 //密码为八位及以上并且字母数字特殊字符三项都包括,强度最强 
		} 
		else if (mediumRegex.test($(this).val())) { 
			$('#level_1').removeClass('pw-weak'); 
			$('#level_1').removeClass('pw-medium'); 
			$('#level_1').removeClass('pw-strong'); 
			$('#level_1').addClass(' pw-medium'); 
			 //密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等 
		} 
		else { 
			$('#level_1').removeClass('pw-weak'); 
			$('#level_1').removeClass('pw-medium'); 
			$('#level_1').removeClass('pw-strong'); 
			$('#level_1').addClass('pw-weak'); 
			 //如果密码为6为及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的 
		} 
		return true; 
	});
	
	

	$('#pass_2').keyup(function () { 
		var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g"); 
		var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g"); 
		var enoughRegex = new RegExp("(?=.{6,}).*", "g"); 
	
		if (false == enoughRegex.test($(this).val())) { 
			$('#level_2').removeClass('pw-weak'); 
			$('#level_2').removeClass('pw-medium'); 
			$('#level_2').removeClass('pw-strong'); 
			$('#level_2').addClass(' pw-defule'); 
			 //密码小于六位的时候，密码强度图片都为灰色 
		} 
		else if (strongRegex.test($(this).val())) { 
			$('#level_2').removeClass('pw-weak'); 
			$('#level_2').removeClass('pw-medium'); 
			$('#level_2').removeClass('pw-strong'); 
			$('#level_2').addClass(' pw-strong'); 
			 //密码为八位及以上并且字母数字特殊字符三项都包括,强度最强 
		} 
		else if (mediumRegex.test($(this).val())) { 
			$('#level_2').removeClass('pw-weak'); 
			$('#level_2').removeClass('pw-medium'); 
			$('#level_2').removeClass('pw-strong'); 
			$('#level_2').addClass(' pw-medium'); 
			 //密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等 
		} 
		else { 
			$('#level_2').removeClass('pw-weak'); 
			$('#level_2').removeClass('pw-medium'); 
			$('#level_2').removeClass('pw-strong'); 
			$('#level_2').addClass('pw-weak'); 
			 //如果密码为6为及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的 
		} 
		return true; 
	});
});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height:80px; background: #B3DFDA;">
  <div class="header_content">
	 <div class="right_nav">
		<div class="text_right">
		<span id="show_text" style="text-align:center;">
				<strong class="colred">
				</strong> <span style="color:#2f2f2f; font-weight:bold;">欢迎您:<%=s_user.getUserRealname()%></span> &nbsp;&nbsp;
		</span>
		<span id="datetime" style="color: #2f2f2f;"></span>&nbsp;&nbsp;
		<ul class="nav_return" style="padding-top: 15px">
		<li> <a href="javascript:changePwd();"  ><img src="<%=path %>/images/topIcon/updatepsd.gif" />&nbsp;&nbsp;修改密码</a>&nbsp;&nbsp;</li>
		<li> <a href="<%=path%>/background/logout.htmls" ><img src="<%=path %>/images/topIcon/loginOut.gif" />&nbsp;&nbsp;退出系统</a>&nbsp;&nbsp;</li>
		</ul>
		</div>
	 </div>
</div>
<!-- 修改密码 -->
<div id="PasswordDlg" class="easyui-dialog" style="width:340px;height:260px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#pwd-buttons'">
	       <div style="float: left; height: 100%">
	          <form id="PasswordForm" >
	          <input type="hidden" id="uId" value="<%=s_user.getUserId()%>" />
	            <table>
	              <tr>
	                   <td align="right" class="tb-txt">旧密码:</td>
	                   <td colspan="2"><input id="pass" class="input-style" size="30" maxlength="30" name="userPassword" type="password" /></td>
	              </tr>
	              <tr style="height: 20px;">
	              </tr>
	              <tr>
	                     <td align="right" class="tb-txt">新密码:</td>
	                     <td colspan="2"><input id="pass_1" class="input-style" size="30" maxlength="30" name="userPassword_new" type="password" /></td>
	               </tr>
	               <tr align="center" style="height: 10px;">  
		            <td align="right" class="tb-txt">强度:</td>  
		           <td id="level_1" class="pw-strength">           	
						<div class="pw-bar"></div>
						<div class="pw-bar-on"></div>
						<div class="pw-txt">
						<span>弱</span>
						<span>中</span>
						<span>强</span>
						</div>
					</td>   
		         </tr> 
	              <tr>
	                   <td align="right" class="tb-txt">重复密码:</td>
	                   <td colspan="2"><input  id="pass_2" class="input-style" size="30" maxlength="30" name="userPassword_rep" type="password" /></td>
	              </tr>
	              <tr align="center" style="height: 10px;">  
		            <td align="right" class="tb-txt">强度:</td>  
		           <td id="level_2" class="pw-strength">           	
						<div class="pw-bar"></div>
						<div class="pw-bar-on"></div>
						<div class="pw-txt">
						<span>弱</span>
						<span>中</span>
						<span>强</span>
						</div>
					</td>   
		         </tr>  
	            </table>
	          </form>
          </div>
      </div>
      <div id="pwd-buttons">
		<a href="javascript:void(0)" id="saveCC" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="javascript:onCheck()">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="javascript:$('#PasswordDlg').dialog('close')">取消</a>
	</div> 
</div>
	<div data-options="region:'west',split:true,title:'&nbsp;'"
		style="width: 180px;">
		<!-- 菜单控制 -->
		<div id="menus_" class="easyui-accordion" data-options="fit:true,border:false">
			 <c:forEach items="${menus}" var="menu">
                <div  style="padding-top: 10px;" title="${menu.text}">
                    <ul id="tree${menu.id}"  class="ztree">
                        <c:forEach items="${modules}" var="module">
                            <c:if test="${menu.id==module.parentId}">
                                <li>
                                    <span style="margin-left: 20px; font-weight: bold;"><a onclick="javascript:addTab('${module.text}','<%=path%>${module.resUrl}');">${module.text}</a></span>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
                </c:forEach>
	  </div>
	</div>
	<div data-options="region:'south',border:false"
		style="height: 30px; background: #B3DFDA;">
		<span style="width:100%; height:20px; line-height:30px; text-align:center; float:left;">©2016 甘肃久义信息技术有限公司版权所有</span>
		</div>
	<div data-options="region:'center',title:'&nbsp;'">
	  <div  id="center_" class="easyui-tabs" data-options="fit:true">
			<div title="系统信息" style="padding:10px">
				  <div id="container_1" style="width: 33%; height: 70%; margin: 0 auto;float: left"></div>
				  <div id="container_2" style="width: 33%; height: 70%; margin: 0 auto;float: left"></div>
				  <div id="container_3" style="width: 33%; height: 70%; margin: 0 auto;float: left"></div>
		   </div>
	</div>
	</div>
</body>
</html>