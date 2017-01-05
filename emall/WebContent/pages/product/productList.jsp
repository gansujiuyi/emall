<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/themes/icon.css">
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/categoryAndProduct/product.js?ctx=<%=path%>"></script>
<script type="text/javascript">
</script>
</head>
<body class="easyui-layout">
        <!-- 新增窗口开始 -->
        <div id="ccMgrDlg" class="easyui-dialog" style="width:390px;height:350px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#ccMgrDlg-buttons'">
		<form id="ccMgrForm" method="post" novalidate>
			<table align="center"  cellpadding="3" cellspacing="5" style="overflow: hidden;" id="categoryTab">
				<input type="hidden" id="t_productId" name="t_productId"/> 
				<tbody>
				 <tr>
				   <th align="right"><label for=contentCode>商品名称:</label></th>
				   <td><input type="text" id="t_productName" name="t_productName"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				  <tr>
				   <th align="right"><label for=contentCode>原价:</label></th>
				   <td><input type="text" id="t_purchasePrice" name="t_purchasePrice"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				  <tr>
				   <th align="right"><label for=contentCode>折扣价:</label></th>
				   <td><input type="text" id="t_discountPrice" name="t_discountPrice"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				  <tr>
				   <th align="right"><label for=contentCode>商品库存:</label></th>
				   <td><input type="text" id="t_productNum" name="t_productNum"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				   <tr>
				   <th align="right"><label for=contentCode>产地:</label></th>
				   <td><input type="text" id="t_origin" name="t_origin"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				<tr>
				 	<th>所属类别:</th>
				 	<td>
				 	   <input class="easyui-combobox" id="categoryType" name="t_categoryType" style="width:100px" data-options="valueField:'id', textField:'text', panelHeight:'auto'" >  
				 	 </td>
				 </tr>
				   <tr>
				   <th align="right"><label for=contentCode>商品说明:</label></th>
				   <td><input type="text" id="t_desc" name="t_desc"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				</tbody>
			</table>
         </form>  
	</div>
	  <div id="ccMgrDlg-buttons">
		<a href="javascript:void(0)" id="saveCC" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="saveCC()">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="javascript:$('#ccMgrDlg').dialog('close')">取消</a>
	</div>
	<!-- 新增窗口结束-->
     <!-- 查询条件开始 -->
	<div region="north"  split="false" style="height:42px;">
	<table class="easyui-panel" style="width:100%;height:40px" loadMsg="正在查询...">
		<tr>
		 <td style="width: 45px;">商品名:</td><td style="width: 100px;"><input id="productName" name="productInfo.t_productName" value="${productInfo.t_productName}" type="text"/></td>
		 <td style="padding-left:70px;"><a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
		</tr>
	</table>
	</div>  
	 <!-- 查询条件结束 -->
	  <!-- 数据展现开始 -->
	 <div region="center">
	   <table id="tt"></table>  
	 </div>
   <!-- 数据展现结束 --> 
</body>
</html>