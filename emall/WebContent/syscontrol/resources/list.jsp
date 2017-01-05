<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-W3CDTD HTML 4.01 TransitionalEN">
<html>
<head>
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/syscontrol/resources/resources.js?ctx=<%=path%>"></script>
<script type="text/javascript">
	$(function() {
		loadRoleDataGrid();
	});
</script>
</head>
    <body class="easyui-layout">
        <!-- 新增窗口开始 -->
        <div id="ccMgrDlg" class="easyui-dialog" style="width:420px;height:400px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#ccMgrDlg-buttons'">
		<form id="ccMgrForm" method="post" novalidate>
			<table align="center"  cellpadding="3" cellspacing="5" style="overflow: hidden;">
			<input type="hidden" id="id" name="id"/> 
			<input type="hidden" id="level" name="level"/> 
			<input type="hidden" id="level" name="type"/> 
				<tbody>
				<tr>
				   <th align="right"><label for=contentCode>所属资源</label></th>
				   <td>
				   <input type="text" id="parentName" name="parentName"  readonly="readonly"  style="width: 245px;" />
				   <input type="hidden" id="parentId" name="parentId"     />
				   <span  class="easyui-linkbutton" data-options="iconCls:'icon-add'" title="添加资源" onclick="javascript:loadResourceTree()"></span>
				   <span  class="easyui-linkbutton" data-options="iconCls:'icon-clear'" title="删除已选资源" onclick="javascript:removeSelect()"></span>
				   </td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>资源名称</label></th>
				   <td><input type="text" id="text" name="text"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>资源key</label></th>
				   <td><input type="text" id="resKey" name="resKey"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>资源地址</label></th>
				   <td><input type="text" id="resUrl" name="resUrl"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				  <tr>
				   <th align="right"><label for=contentCode>地址描述</label></th>
				   <td><input type="text" id="description" name="description"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
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
		 <td style="width: 55px;">资源名称:</td><td style="width: 100px;"><input id="text_" name="text_" value="${resources.text}" type="text"/></td>
		 <td style="width: 55px;padding-left:70px;">资源key:</td><td style="width: 100px;"><input id="resKey_" name="resKey_"  value="${resources.resKey}" type="text"/></td>
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
   <div id="TreeDlg" class="easyui-dialog" style="width:330px;height:450px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#TreeDlg-buttons'">
	       <div style="float: leftl; height: 100%">
	          <div id="resourceTree" class="ztree" style="margin:0; overflow:auto;"></div>
          </div>
      </div>
</body>
</html>