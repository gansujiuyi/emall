<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/business/syscontrol/users/users.js?ctx=<%=path%>"></script>
	<script type="text/javascript">
	$(function() {
		loadRoleDataGrid();
	});
</script>
</head>
<body class="easyui-layout">
   <!-- 新增窗口开始 -->
        <div id="ccMgrDlg" class="easyui-dialog" style="width:390px;height:250px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#ccMgrDlg-buttons'">
		<form id="ccMgrForm" method="post" novalidate>
			<table align="center"  cellpadding="3" cellspacing="5" style="overflow: hidden;">
			<input type="hidden" id="userId" name="userId"/> 
				<tbody>
				 <tr>
				   <th align="right"><label for=contentCode>角色名称</label></th>
				   <td><input type="text" id="roleName" name="name"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>角色key</label></th>
				   <td><input type="text" id="roleKey" name="roleKey"  class="easyui-validatebox"  data-options="required:true" style="width: 245px;" /></td>
				 </tr>
				 <tr>
				   <th align="right"><label for=contentCode>角色描述</label></th>
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
	<div region="north"   split="false" style="height:10%;border:false">
	<table class="easyui-panel" fit="true" loadMsg="正在查询...">
		<tr>
		 <td style="width: 45px;">角色名:</td><td style="width: 100px;"><input id="userName_"  value="${users.userName}" type="text"/></td>
		 <td style="width: 55px;padding-left:70px;">手机号码:</td><td style="width: 100px;"><input id="userPhone_"   value="${users.userPhone}" type="text"/></td>
		 <td style="width: 55px;padding-left:70px;">电子邮箱:</td><td style="width: 100px;"><input id="userMail_"    value="${users.userMail}" type="text"/></td>
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
    <!-- 加载角色树开始-->
     <div id="TreeDlg" class="easyui-dialog" style="width:230px;height:300px;" data-options="iconCls:'',resizable:false,closed:true,modal:true,collapsible:false,maximizable:false,buttons:'#TreeDlg-buttons'">
	       <div style="float: left; height: 100%">
	          <div id="rolesTree" class="ztree" style="margin:0; overflow:auto;"></div>
          </div>
      </div>
      <div id="TreeDlg-buttons">
		<a href="javascript:void(0)" id="saveCC" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="javascript:onCheck()">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="javascript:$('#TreeDlg').dialog('close')">取消</a>
	</div>  
    <!-- 加载用户树结束-->
</body>
</html>