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
<script type="text/javascript" src="<%=path%>/js/business/emaillInfo/emaillInfo.js?ctx=<%=path%>"></script>
<script type="text/javascript">
	$(function() {
		loademaillInfoDataGrid();
	});
</script>

<title>邮件列表</title>
</head>
<body class="easyui-layout">
	<!-- 新增窗口结束-->
     <!-- 查询条件开始 -->
	<div region="north"  style="height:10%;border:false">
	<table class="easyui-panel" fit="true" loadMsg="正在查询...">
		<tr>
		 <td style="width: 55px;">邮件主题:</td><td style="width: 100px;"><input id="emTitle" name="emTitle" value="${emaillInfo.emTitle}" type="text"/></td>
		 <td style="padding-left:70px;"><a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
		</tr>
	</table>
	</div>  
	 <!-- 查询条件结束 -->
	  <!-- 数据展现开始 -->
	 <div region="center">
	   <table id="emaillInfos"></table>  
	 </div>
</body>
</html>