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
<script type="text/javascript" src="<%=path%>/js/business/cpevaluate/cpevaluateInfo.js?ctx=<%=path%>"></script>
<title>评价管理</title>
<script type="text/javascript">
	$(function() {
		loadcpevaluateInfoDataGrid();
	});
</script>
</head>
<body class="easyui-layout">
	  <!-- 数据展现开始 -->
	   <table id="cpevaluateInfo"></table>  
</body>
</html>