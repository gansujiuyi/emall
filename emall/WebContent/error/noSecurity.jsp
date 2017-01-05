<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
${message}
</div>
</div>
</div>
</div>
</div>
</BODY>
