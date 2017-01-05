<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<jsp:directive.include file="/base/tag.inc" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/collect/collectInfo.js?ctx=<%=path%>"></script>
<title>收藏管理</title>
<script type="text/javascript">
	$(function() {
		loadcollectInfoDataGrid();
	});
</script>
</head>
<body class="easyui-layout">
	   <table id="collectInfo"></table>  
</body>
</html>