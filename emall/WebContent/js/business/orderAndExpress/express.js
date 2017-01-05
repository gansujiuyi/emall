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
 		title : '快递信息',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/background/express/ajaxQuery.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : false,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'expressId',//主键字段 
 		frozenColumns: [[
 		                {field: 'ck', checkbox: true },
 		                {title: '收件人姓名', field: 'recipientsName', width: 160, align: 'left', sortable: true }
 		            ]],
 		            columns: [[
 		                {field: 'recipientRddress', title: '收件地址', width: 160, align: 'left', sortable: true },
 		                {field: 'recipientTel', title: '收件人电话', width: 160, align: 'left', sortable: true },
 		                {field: 'orderNum', title: '订单编号', width: 160, align: 'left', sortable: true },
 		                {field: 'expressNum', title: '快递编号', width: 160, align: 'left', sortable: true },
 		                {field: 'corporateName', title: '快递公司', width: 160, align: 'left', sortable: true },
 		                {field: 'sendTime', title: '发货日期', width: 160, align: 'left', sortable: true,formatter:formatDateBoxFull },
 		                {field: 'receiveTime', title: '签收日期', width: 160, align: 'left', sortable: true,formatter:formatDateBoxFull },
 		                {field: 'sendStatus', title: '发货状态', width: 160, align: 'left', sortable: true,
 		                	formatter:function(val,rec){ 
								if (val==0){ 
								return '<span>未发货</span>'; 
								} else{ 
									return '<span>已发货</span>';  
								} 
							}
 		                },
 		                {field: 'expressStatus', title: '快递状态', width: 160, align: 'left', sortable: true,
 		                	formatter:function(val,rec){ 
								if (val==0){ 
								return '<span>未签收</span>'; 
								} else if(val==1){ 
									return '<span>已签收</span>';  
								} else if(val==2){ 
									return '<span>快递中*</span>';  
								} 
							}
 		                },
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

//查询
function doSearch(){
	$('#tt').datagrid('load',{
		orderNum:$('#orderNum_').val(),
		expressNum:$("#expressNum_").val()
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
		 $("#expressId").val(rowData.expressId);
		 $("#userId").val(rowData.userId);
		 $("#orderNum").val(rowData.orderNum);
		 $("#expressNum").val(rowData.expressNum);
		 $("#corporateName").val(rowData.corporateName);
		 $("#recipientsName").val(rowData.recipientsName);
		 $("#recipientRddress").val(rowData.recipientRddress);
		 $("#receiveTime").val(rowData.receiveTime);
		 $("#sendTime").val(rowData.sendTime);
		 $("#recipientTel").val(rowData.recipientTel);
		 if("0"==rowData.sendStatus){
			 $("#sendStatus").val("未发货");
		 }else{
			 $("#sendStatus").val("已发货");
		 }
		 if("0"==rowData.expressStatus){
			 $("#expressStatus").val("未签收");
		 }else if("1"==rowData.expressStatus){
			 $("#expressStatus").val("已签收"); 
		 }else if("2"==rowData.expressStatus){
			 $("#expressStatus").val("快递中");
		 }			 
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
//		var roleName = $.trim($("#roleName").val());
		var expressId = ccMgrForm.find("#expressId").val();
		var userId = ccMgrForm.find("#userId").val();
		var orderNum = ccMgrForm.find("#orderNum").val();
		var expressNum = ccMgrForm.find("#expressNum").val();
		var corporateName = ccMgrForm.find("#corporateName").val();
		var recipientsName = ccMgrForm.find("#recipientsName").val();
		var recipientRddress = ccMgrForm.find("#recipientRddress").val();
		var recipientTel = ccMgrForm.find("#recipientTel").val();
		var sendStatus = ccMgrForm.find("#sendStatus").val();
		var expressStatus = ccMgrForm.find("#expressStatus").val();	
		var sendTime = ccMgrForm.find("#sendTime").val();	
		var receiveTime = ccMgrForm.find("#receiveTime").val();	
		var params = {
			"expressId" : expressId,
			"userId" : userId,
			"orderNum" : orderNum,
			"expressNum" : expressNum,
			"corporateName":corporateName,
			"recipientsName":recipientsName,
			"recipientRddress":recipientRddress,
			"recipientTel":recipientTel,
			"sendStatus":sendStatus,
			"expressStatus":expressStatus,
			"receiveTime":receiveTime,
			"sendTime":sendTime
			
		};
		alert(""+params);
		submitForm($ctx+'/background/express/saveExpressInfo.htmls');
	}
}
