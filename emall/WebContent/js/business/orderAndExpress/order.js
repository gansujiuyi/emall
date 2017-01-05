var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var ccMgrForm;
var ccGrid;
var ccMgrDlg;
var ccRuleDialog;


function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 
//加载datagrid
function loadRoleDataGrid(){
	ccMgrForm = $("#ccMgrForm").form();
	ccMgrDlg = $("#ccMgrDlg");
	ccRuleDialog = $("#ccRuleDialog");
	ccGrid = $('#tt').datagrid({
 		title : '订单列表',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/order/mng/ajaxQuery.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : false,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'orderId',//主键字段 
 		frozenColumns: [[
 		                { field: 'ck', checkbox: true },
 		                { title: '订单编号', field: 'orderNum', width: 160, align: 'left', sortable: true }
 		            ]],
 		            columns: [[
 		                {field: 'purchaser', title: '收件人', width: 160, align: 'left', sortable: true },
 		                {field: 'purchaserTel', title: '联系电话', width: 160, align: 'left', sortable: true },
 		                {field: 'purchaseRaddress', title:'发货地址', width: 160, align: 'left', sortable: true },
 		                {field: 'aggregateAmount', title:'订单金额', width: 160, align: 'left', sortable: true },
 		                {field: 'payStatus', title: '支付状态', width: 160, align: 'left', sortable: true,
 		                	formatter:function(val,rec){ 
								if (val==1){ 
									return '<span>支付成功</span>'; 
								} else { 
									return '<span>支付失败</span>';  
								} 
							}
 		                
 		                },
	                	{field: 'orderStatus', title: '订单状态', width: 160, align: 'left', sortable: true,
 		                	formatter:function(val,rec){ 
								if (val==1){ 
									return '<span>下单成功</span>'; 
								} else { 
									return '<span>下单失败</span>';  
								} 
							}
	                	},
	                	{field: 'creationTime', title: '下单时间', width: 160, align: 'left', sortable: true,formatter:formatDateBoxFull },
	                	{field: 't_productId', title: '商品信息', width: 160, align: 'left', sortable: true,
	                		formatter:function(val,rec){ 
								return '<span><a href=javascript:findProductInfoById("'+val+'");>商品详情</a></span>';  
						}
	                	
	                	},
	                	{field: 'expressId', title: '快递信息', width: 160, align: 'left', sortable: true,
	                		formatter:function(val,rec){ 
									return '<span><a href=javascript:findExpressInfoById("'+val+'");>快递详情</a></span>';  
							}
	                	},
	                	{field: 't_desc', title: '备注', width: 160, align: 'left', sortable: true },
 		            ]],
 		           toolbar:
 		  			[
 		          		{  
 		              		text:'编辑',  
 		              		iconCls:'icon-edit',  
 		              		handler:function(){  
 		                  		editCC();  
 		              	}  
 		          		},'-',
 		          		{
 		  					text : '取消选中',
 		  					iconCls : 'icon-undo',
 		  					handler : function() {
 		  						ccGrid.datagrid('unselectAll');
 		  					}
 		  				},'-',
 		          		{
 		  					text : '全部选中',
 		  					iconCls : 'icon-redo',
 		  					handler : function() {
 		  						ccGrid.datagrid('selectAll');
 		  					}
 		  				},'-',
 		          	],
 		pagination : true,//分页
 		rownumbers : true//行数
 	});	
}
//根据id查询快递信息
function findExpressInfoById(expressId){
	$("#expressAndProduct").dialog('open').dialog('setTitle','快递详情');
	$("#express").html('');
	var params = {"expressId":expressId};
	$.ajax({
		url : $ctx+"/background/order/queryExpressInfoById.htmls",
		data : params,
		type:'post',
		dataType : "json",
		cache : false,
		error : function(textStatus, errorThrown) {
//			$.messager.alert('消息',"查询快递信息失败！: " + textStatus,'error');
		},
		success : function(data, textStatus) {
			var html = "<table>";
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>订单编号:</label></th>';
			html+='<td><input type="text" id="orderNum" name="orderNum"  value="'+data.orderNum+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+=' </tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>快递编号:</label></th>';
			html+='<td><input type="text" id="expressNum" name="expressNum"  value="'+data.expressNum+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+='</tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>快递公司:</label></th>';
			html+='<td><input type="text" id="corporateName" name="corporateName"  value="'+data.corporateName+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+='</tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>收件人:</label></th>';
			html+='<td><input type="text" id="recipientsName" name="recipientsName"  value="'+data.recipientsName+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+='</tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>收件地址:</label></th>';
			html+='<td><input type="text" id="recipientRddress" name="recipientRddress"  value="'+data.recipientRddress+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+='</tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>收件人电话:</label></th>';
			html+='<td><input type="text" id="recipientTel" name="recipientTel"  value="'+data.recipientTel+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+='</tr>';
			html+='</table>';
			$("#express").html(html);
		}
	});
}
//根据id查询商品信息
function findProductInfoById(t_productId){
	$("#expressAndProduct").dialog('open').dialog('setTitle','商品详情');
	$("#express").html('');
	var params = {"t_productId":t_productId};
	$.ajax({
		url : $ctx+"/background/product/queryProductInfoById.htmls",
		data : params,
		type:'post',
		dataType : "json",
		cache : false,
		error : function(textStatus, errorThrown) {
//			$.messager.alert('消息',"查询快递信息失败！: " + textStatus,'error');
		},
		success : function(data, textStatus) {
			var html = "<table>";
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>商品名称:</label></th>';
			html+='<td><input type="text" id="t_productName" name="t_productName"  value="'+data.t_productName+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+=' </tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>商品折扣价:</label></th>';
			html+='<td><input type="text" id="t_discountPrice" name="t_discountPrice"  value="'+data.t_discountPrice+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+=' </tr>';
			html+='<tr>';
			html+='<th align="right"><label for=contentCode>商品说明:</label></th>';
			html+='<td><input type="text" id="t_desc" name="t_desc"  value="'+data.t_desc+'" class="easyui-validatebox"  data-options="required:true" style="width: 245px;"  readonly="readonly"/></td>';
			html+=' </tr>';
			html+='</table>';
			$("#express").html(html);
		}
	});
}
//查询
function doSearch(){
	$('#tt').datagrid('load',{
		name :$('#findOrderNum').val(),
	});
}
//编辑
function editCC(){
	//清空表单
	ccMgrForm.form('clear');
	var rows = ccGrid.datagrid('getSelections');  
	var rowData = ccGrid.datagrid('getSelected');
	if(rows.length==0){  
         $.messager.alert('提示信息','请选择你要编辑的数据!');
   		 return;  
		}else if (rows.length != 1 && rows.length > 0) {
		var names = [];
		for ( var i = 0; i < rows.length; i++) {
			names.push(rows[i].name);
		}
		$.messager.alert('提示信息','只能选择一个进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个');
	}else if (rowData){
		ccMgrDlg.dialog('open').dialog('setTitle','编辑');
		 $("#orderId").val(rowData.orderId);
		 $("#userId").val(rowData.userId);
		 $("#orderNum").val(rowData.orderNum);
		 $("#purchaser").val(rowData.purchaser);
		 $("#purchaserTel").val(rowData.purchaserTel);
		 $("#purchaseRaddress").val(rowData.purchaseRaddress);
		 $("#aggregateAmount").val(rowData.aggregateAmount);
		 if(rowData.payStatus=="1"){
			 $("#payName").val("支付成功"); 
		 }else{
			 $("#payName").val("支付失败"); 
		 }
		 if(rowData.orderStatus=="1"){
			 $("#orderName").val("下单成功"); 
		 }else{
			 $("#orderName").val("下单失败"); 
		 }
		 $("#creationTime").val(rowData.creationTime);
		 $("#t_desc").val(rowData.t_desc);
		 $("#t_productId").val(rowData.t_productId);
		 $("#expressId").val(rowData.expressId);
		 $("#payStatus").val(rowData.payStatus);
		 $("#orderStatus").val(rowData.orderStatus);
	}
}
//提交表单
function submitForm(url){
ccMgrForm.form('submit',{
	url:url,
	success: function(result){
		var map = $.parseJSON(result); 
		if (map){
				ccMgrDlg.dialog('close');		// close the dialog
				ccGrid.datagrid('reload');	// reload the user data
				$.messager.alert('提示信息','保存成功!');
		} else {
			$.messager.alert('提示信息','保存失败!');
		}
	}
 });
}
//保存
function saveCC() {
	if (ccMgrForm.form('validate')) {
		var orderId = ccMgrForm.find("#orderId").val();
		var userId = ccMgrForm.find("#userId").val();
		var purchaser = $.trim($("#purchaser").val());
		var purchaserTel = ccMgrForm.find("#purchaserTel").val();
		var purchaseRaddress = ccMgrForm.find("#purchaseRaddress").val();
		var payStatus = ccMgrForm.find("#payStatus").val();
		var orderStatus = ccMgrForm.find("#orderStatus").val();
		var params = {
			"orderId" : orderId,
			"userId" : userId,
			"purchaser" : purchaser,
			"purchaserTel" : purchaserTel,
			"purchaseRaddress" : purchaseRaddress,
			"payStatus" : payStatus,
			"orderStatus" : orderStatus,
		};
		submitForm($ctx+'/background/order/saveOrderInfo.htmls');

	}
}
