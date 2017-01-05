<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="indexform" method="get" target="_parent" style="display: none;" action="<%=path%>/background/Initlogin.htmls">
</form>
<script type="text/JavaScript">
	document.getElementById("indexform").submit();
</script>