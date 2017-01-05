<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
${msg}
</div>
</div>
<ul>
<li><a href="<%=path%>/background/index.htmls" >返回首页</a></li>
<li><a href="javascript:history.go(-1);">返回上一页</a></li>
</ul>
</div>
</div>
</div>
</BODY>
