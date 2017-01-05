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
<script type="text/javascript" src="<%=path%>/js/business/orderAndExpress/express.js?ctx=<%=path%>"></script>
	<script type="text/javascript">
	$(function() {
		loadRoleDataGrid();
	});
</script>
</head>
<body class="easyui-layout">
<input type="hidden" id="roleIds"/>
        <!-- 新增窗口开始 -->
        <div id="ccMgrDlg" class="easyui-dialog" style="width:390px;height:250px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#ccMgrDlg-buttons'">
		<form id="ccMgrForm" method="post" novalidate>
			<table align="center"  cellpadding="3" cellspacing="5" style="overflow: hidden;">
			<input type="hidden" id="expressId" name="expressId"/> 
			<input type="hidden" id="userId" name="userId"/> 
				<tbody>
				 <tr>
				   <th align="right"><label for=contentCode>订单编号</label></th>
				   <td><input type="text" id="orderNum" name="orderNum"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>快递编号</label></th>
				   <td><input type="text" id="expressNum" name="expressNum"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>快递公司</label></th>
				   <td><input type="text" id="corporateName" name="corporateName"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>收件人</label></th>
				   <td><input type="text" id="recipientsName" name="recipientsName"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>收件地址</label></th>
				   <td><input type="text" id="recipientRddress" name="recipientRddress"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>收件人联系方式</label></th>
				   <td><input type="text" id="recipientTel" name="recipientTel"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>发货日期</label></th>
				   <td><input type="text" id="sendTime" name="sendTime"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>签收日期</label></th>
				   <td><input type="text" id="receiveTime" name="receiveTime"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>发货状态</label></th>
				   <td><input type="text" id="sendStatus" name="sendStatus"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>快递状态</label></th>
				   <td><input type="text" id="expressStatus" name="expressStatus"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" readonly="readonly"/></td>
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
		 <td style="width: 55px;">订单编号:</td><td style="width: 100px;"><input id="orderNum_" name="expressInfo.orderNum" value="${expressInfo.orderNum}" type="text"/></td>
		 <td style="width: 55px;padding-left:70px;">快递单号:</td><td style="width: 100px;"><input id="expressNum_" name="expressInfo.expressNum"  value="${expressInfo.expressNum}" type="text"/></td>
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
   <!-- 加载用户树开始-->
     <div id="TreeDlg" class="easyui-dialog" style="width:230px;height:100%;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#TreeDlg-buttons'">
	       <div style="float: leftl; height: 100%">
	          <div id="resourceTree" class="ztree" style="margin:0; overflow:auto;"></div>
          </div>
      </div>
      <div id="TreeDlg-buttons">
		<a href="javascript:void(0)" id="saveCC" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="javascript:onCheck()">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="javascript:$('#TreeDlg').dialog('close')">取消</a>
	</div>  
    <!-- 加载用户树结束-->
</body>
</html>