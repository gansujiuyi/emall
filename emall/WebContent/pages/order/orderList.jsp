<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:directive.include file="/base/tag.inc" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/orderAndExpress/order.js?ctx=<%=path%>"></script>
	<script type="text/javascript">
	$(function() {
		loadRoleDataGrid();
	});
</script>
</head>
<body class="easyui-layout">
<input type="hidden" id="roleIds"/>
        <!-- 修改窗口开始 -->
        <div id="ccMgrDlg" class="easyui-dialog" style="width:390px;height:250px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#ccMgrDlg-buttons'">
		<form id="ccMgrForm" method="post" novalidate>
			<table align="center"  cellpadding="3" cellspacing="5" style="overflow: hidden;">
			<input type="hidden" id="orderId" name="orderId"/> 
			<input type="hidden" id="userId" name="userId"/> 
				<tbody>
				 <tr>
				   <th align="right"><label for=contentCode>订单编号</label></th>
				   <td><input type="text" id="orderNum" name="orderNum"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>收件人</label></th>
				   <td><input type="text" id="purchaser" name="purchaser"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>联系方式</label></th>
				   <td><input type="text" id="purchaserTel" name="purchaserTel"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>收货地址</label></th>
				   <td><input type="text" id="purchaseRaddress" name="purchaseRaddress"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"/></td>
				 </tr>
				 	 <tr>
				   <th align="right"><label for=contentCode>订单金额</label></th>
				   <td><input type="text" id="aggregateAmount" name="aggregateAmount"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"readonly="readonly"/></td>
				 </tr>
				 	 <tr>
				   <th align="right"><label for=contentCode>支付状态</label></th>
				   <td>
				   	<input type="text" id="payName"class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/>
				   	<input type="hidden" id="payStatus" name="payStatus"     />
				   </td>
				 	 <tr>
				   <th align="right"><label for=contentCode>订单状态</label></th>
				   <td>
				   	<input type="text" id="orderName"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/>
				   	<input type="hidden" id="orderStatus" name="orderStatus"     />
				   </td>
				 </tr>
				 	 <tr>
				   <th align="right"><label for=contentCode>下单时间</label></th>
				   <td><input type="text" id="creationTime" name="creationTime"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 	<tr>
				   <th align="right"><label for=contentCode>商品详情</label></th>
				   <td><input type="text" id="t_productId" name="t_productId"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"readonly="readonly" /></td>
				 </tr>
				  <tr>
				   <th align="right"><label for=contentCode>备注</label></th>
				   <td><input type="text" id="t_desc" name="t_desc"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>物流详情</label></th>
				   <td><input type="text" id="expressId" name="expressId"/></td>
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
	<div region="north"  style="height:10%;border:false">
	<table class="easyui-panel" fit="true" loadMsg="正在查询...">
		<tr>
		 <td style="width: 55px;">订单编号:</td><td style="width: 100px;"><input id="findOrderNum" name="orderInfo.orderNum" value="${orderInfo.orderNum}" type="text"/></td>
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
   <!-- 快递详情展现开始 -->
 <div id="expressAndProduct" class="easyui-dialog" style="width:390px;height:250px;" closed=true>
		   <div id="express"></div>
	</div> 
</body>
</html>