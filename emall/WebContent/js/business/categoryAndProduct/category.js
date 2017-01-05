var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var suggest_Grid;

function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 
var ccMgrForm;
	var ccGrid;
	var ccMgrDlg;
	var ccRuleDialog;
$(function() {
	ccMgrForm = $("#ccMgrForm").form();
	ccMgrDlg = $("#ccMgrDlg");
	ccRuleDialog = $("#ccRuleDialog");
	ccGrid = $('#tt').datagrid({
		title : '分类信息',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/category/mng/ajaxQueryAllCatagory.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : true,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'t_categoryId',//主键字段 
 		frozenColumns: [[
 		                {field: 'ck', checkbox: true },
 		                {title: '分类名称', field: 't_categoryName', width: 160, align: 'left', sortable: true }
 		            ]],
 		            columns: [[
 		                {field: 't_categoryType', title: '所属类别', width: 160, align: 'left', sortable: true,
 		                	 formatter:function(val,rec){ 
									if (val=="null"){ 
									return '<span></span>'; 
									} else { 
										return '<span>'+val+'</span>';  
									} 
								}},
 		                {field: 't_desc', title: '分类描述', width: 160, align: 'left', sortable: true },
 		                {field: 't_checkStatus', title: '审核状态', width: 160, align: 'left', sortable: true,
							 formatter:function(val,rec){ 
									if (val=="1"){ 
									return '<span>已启用</span>'; 
									} else { 
										return '<span>已停用</span>';  
									} 
								}
						}
 		            ]],
 		           toolbar:
 		  			[
 		  				{  
 		              		text:'新建',  
 		              		iconCls:'icon-add',
 		              		handler:function(){  
 		                  		newCC();  
 		              		}  
 		          		},'-',
 		          		{  
 		              		text:'编辑',  
 		              		iconCls:'icon-edit',  
 		              		handler:function(){  
 		                  		editCC();  
 		              	}  
 		          		},'-',
 		          		{  
 		              		text:'删除',  
 		             			iconCls:'icon-remove',
 		              		handler:function(){  
 		                  		removeCC();  
 		              		}  
 		          		},'-',
 		          		{
 		  					text : '启用',
 		  					iconCls:'icon-ok',
 		  					handler : function() {
 		  						updateCategoryInfoStatus("1");
 		  					}
 		  				},'-',
 		          		{
 		  					text : '停用',
 		  					iconCls:'icon-no',
 		  					handler : function() {
 		  						updateCategoryInfoStatus("0");
 		  					}
 		  				},'-',
 		          		{
 		  					text : '取消选中',
 		  					iconCls : 'icon-undo',
 		  					handler : function() {
 		  						ccGrid.datagrid('unselectAll');
 		  					}
 		  				}
 		          	],
 		pagination : true,//分页
 		rownumbers : true,//行数
 		onLoadSuccess:function(data){//加载完毕后获取所有的checkbox遍历
			 $(this).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态
      }
 	});	
	
});
//搜索按钮功能
function doSearch(){
	$('#tt').datagrid('load',{
		t_categoryName :$('#categoryName').val()
	});
}
//启用分类信息 |停用分类信息
function updateCategoryInfoStatus(t_checkStatus){
	 var rows = ccGrid.datagrid('getSelections');  
     var ids = "";  
     $.each(rows,function(i,n){  
         if(i==0)   
             ids += "'"+n.t_categoryId+"'";  
         else  
             ids += ","+"'"+n.t_categoryId+"'";  
     });
     //alert(''+ids);
if(rows.length > 0){
	$.messager.confirm('确认','确定要操作所选吗!?',function(r){
		if (r){
			var params = {
				"t_categoryId" : ids,
				"t_checkStatus":t_checkStatus
			};
			$.ajax( {
					url : $ctx+"/category/mng/updateCategoryInfoStatus.htmls",
					data : params,
					dataType : "json",
					cache : false,
					error : function(textStatus, errorThrown) {
//						$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
					},
					success : function(data, textStatus) {
						if (data==true) {
							ccGrid.datagrid('reload');
							if(t_checkStatus=="1"){
								$.messager.alert('提示信息','启用成功!');	
							}else{
								$.messager.alert('提示信息','停用成功!');
							}
						} else {
							$.messager.alert('提示信息','操作失败!');
						}
					}
			});
		}
	});
}else{
	$.messager.alert('提示信息','请先选择需要启用分类信息!');
}
}
//新建
function newCC(){
	//查询所有分类信息名称
	ccMgrDlg.dialog('open').dialog('setTitle','新建');
	ccMgrForm.form('clear');
	$('#categoryType').combobox({ 
	    url:$ctx+'/category/mng/querAllCategoryInfo.htmls', 
	    editable:false, //不可编辑状态
	    cache: false,
	    panelHeight: 'auto',//自动高度适合
	    valueField:'t_categoryId',   
	    textField:'t_categoryName'
	   });
	//设置默认值
	$('#categoryType').combobox('setValue',"--请选择--");
	
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
		$("#t_categoryId").val(rowData.t_categoryId);
		$("#t_categoryName").val(rowData.t_categoryName);
		$("#t_desc").val(rowData.t_desc);
		$('#categoryType').combobox({ 
		    url:$ctx+'/category/mng/querAllCategoryInfo.htmls', 
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    valueField:'t_categoryId',   
		    textField:'t_categoryName',
		    onLoadSuccess:function(){
		    	if("null"!=rowData.t_categoryType){
		    		$('#categoryType').combobox('select',rowData.t_categoryType);
		    	}else{
		    		$('#categoryType').combobox('setValue',"--请选择--");
		    	}
		    	
		    }
		   });
		$("#desc").val(rowData.desc);
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
		var categoryId = ccMgrForm.find("#t_categoryId").val();
		var categoryName = $.trim($("#t_categoryName").val());
		var categoryType = ccMgrForm.find("#categoryType").val();
		var desc = ccMgrForm.find("#t_desc").val();
		var creationTime = ccMgrForm.find("#t_creationTime").val();
		//alert(''+categoryId+categoryName+categoryType+desc+creationTime);
		var params = {
			"t_categoryId" : categoryId,
			"t_categoryName" : categoryName,
			"t_categoryType":categoryType,
			"t_desc":desc,
			"t_creationTime":creationTime
		};
	$.ajax({
			url : $ctx+'/category/mng/chechInfo.htmls',
			data : params,
			type:'post',
			dataType : "json",
			cache : false,
			error : function(textStatus, errorThrown) {
//				$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
			},
			success : function(data, textStatus) {
				if (data == true) {
                 $.messager.alert('提示信息','已经存在,请更正!');
				 $("#contentCode").focus();
				} else{
					//alert('保存');
					//编辑模式
					if(ccMgrForm.find("#id").val() != ''){
							submitForm('saveCategoryInfo.htmls');
					}else{//增加模式
							submitForm('saveCategoryInfo.htmls');
					}
				}
			}
	});
	}
}
//删除
function removeCC(){
	 var rows = ccGrid.datagrid('getSelections');  
           var ids = "";  
           $.each(rows,function(i,n){  
               if(i==0)   
                   ids += n.t_categoryId;  
               else  
                   ids += ","+n.t_categoryId;  
           }); 
	if(rows.length > 0){
		$.messager.confirm('确认','确定要删除所选吗,同时会删除其关联的表数据!?',function(r){
			if (r){
				var params = {
					"categoryId" : ids
				};
				$.ajax( {
						url :$ctx+'/category/mng/delCategoryInfo.htmls',
						data : params,
						dataType : "json",
						cache : false,
						error : function(textStatus, errorThrown) {
//							$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
						},
						success : function(data, textStatus) {
							if (data==true) {
								ccGrid.datagrid('reload');
								$.messager.alert('提示信息','删除成功!');
							} else {
								$.messager.alert('提示信息','删除失败!');
							}
						}
				});
			}
		});
	}else{
		$.messager.alert('提示信息','请先选择需要删除的行!');
	}
}