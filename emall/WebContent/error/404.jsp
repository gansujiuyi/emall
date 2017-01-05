<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<STYLE type=text/css>
body{
	margin:0 auto;
	background:#FFF;
	text-align:center;
	}
a:link{
	text-decoration:none ; 
	color:#03F;
  }
a:visited {
	text-decoration:none ; 
	color: #F60;
	}
a:hover {
	text-decoration:underline ; 
	color: #F60;
	}
a:active {
	text-decoration:none ;
    colorwhite;}
.main{
	margin:0 auto;
	}
.con{
	margin:0 auto;
	width:540px;
	}
.errorPic{
	margin:0 auto;
	width:329px;
	height:211px;
	padding:10px;
	}
.errorNotes{
    
}
.errorNotes ul{
	height:30px;
}
.errorNotes li{
	float:left;
	width:150px;
	text-align:center;
	line-height:30px;
	list-style:none;
}
.re{
	margin:0 auto;
	width:280px;
	text-align:center;
}
.re .title{
	text-align:center;
	line-height:30px;
	font-size:20px;
	font-weight:bold;
	color:#F00;
}
.re dt{
	text-align:left;
	line-height:30px;
}
</STYLE>
<BODY>
<div class="main">
<div class="con">
<div class="errorPic">
<img src="<%=path%>/images/errordocs/error.gif" >
</div>
<div class="errorNotes">
<div class="re">
<div class="title">
抱歉，找不到您要的页面……
</div>
<dl>
<dt>1、可能是您访问的内容不存在</dt>
<dt>2、可能是您访问的内容已过期</dt>
<dt>3、可能是您访问的网址有误</dt>
</dl>
</div>
<ul>
<li><a href="<%=path%>/background/index.htmls" >返回首页</a></li>
<li><a href="javascript:history.go(-1);">返回上一页</a></li>
</ul>
</div>
</div>
</div>