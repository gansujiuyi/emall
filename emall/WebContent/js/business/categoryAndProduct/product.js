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
 		title : '商品信息',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/product/mng/ajaxQueryAllProduct.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : true,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'t_productId',//主键字段 
 		frozenColumns: [[
 		                { field: 'ck', checkbox: true },
 		                { title: '商品名称', field: 't_productName', width: 160, align: 'left', sortable: true }
 		            ]],
 		            columns: [[
 		                {field: 't_purchasePrice',title:'原价',width:160,align:'left',sortable:true },
 		                {field: 't_discountPrice',title:'折扣价',width:160,align:'left',sortable:true },
 		                {field: 't_productNum',title:'商品库存',width:160,align:'left',sortable:true },
 		                {field: 't_origin', title:'产地', width:160,align:'left',sortable:true },
 		                {field: 't_onSellTime', title:'上架时间',width:160, align:'left',sortable:true,formatter:formatDateBoxFull },
 		                {field: 't_offSellTime', title:'下架时间',width:160, align:'left',sortable:true,formatter:formatDateBoxFull },
 		                {field: 't_categoryType', title: '所属分类',width:160, align:'left',sortable:true },
 		                {field: 't_typeName', title: '所属分类名称',width:160,align:'left',sortable:true },
 		                {field: 't_desc', title: '商品说明', width:160,align:'left',sortable:true },
 		                {field: 't_productImg', title: '展示图片',width:160,align:'left',sortable:true },
 		                {field: 't_checkStatus', title: '审核状态',width:160,align:'left', sortable: true,
							 formatter:function(val,rec){ 
									if (val=="1"){ 
									return '<span>已上架</span>'; 
									} else { 
										return '<span>已下架</span>';  
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
 		  					text : '上架',
 		  					iconCls:'icon-ok',
 		  					handler : function() {
 		  						onSellOrOffSell("1");
 		  					}
 		  				},'-',
 		          		{
 		  					text : '下架',
 		  					iconCls:'icon-no',
 		  					handler : function() {
 		  						onSellOrOffSell("0");
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
 		rownumbers : true//行数
 	});	
	
});
//搜素按钮
function doSearch(){
	$('#tt').datagrid('load',{
		t_productName :$('#productName').val()
	});
}
//商品上架||商品下架
function onSellOrOffSell(checkStatus){
	 var rows = ccGrid.datagrid('getSelections');  
    var ids = "";  
    $.each(rows,function(i,n){  
        if(i==0)   
            ids += "'"+n.t_productId+"'";  
        else  
            ids += ","+"'"+n.t_productId+"'";  
    });  
if(rows.length > 0){
	$.messager.confirm('确认','确定要操作所选吗!?',function(r){
		if (r){
			var params = {
				"t_productId" : ids,
				"checkStatus":checkStatus
			};
			$.ajax( {
					url : "/emall/background/product/onSellOrOffSell.htmls",
					data : params,
					dataType : "json",
					cache : false,
					error : function(textStatus, errorThrown) {
//						$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
					},
					success : function(data, textStatus) {
						if (data==true) {
							ccGrid.datagrid('reload');
							if(checkStatus==1){
								$.messager.alert('提示信息','上架成功!');	
							}else{
								$.messager.alert('提示信息','下架成功!');
							}
						} else {
							$.messager.alert('提示信息','操作失败!');
						}
					}
			});
		}
	});
}else{
	$.messager.alert('提示信息','请先选择需要上架的商品!');
}
}
//新建
function newCC(){
	//清空表单
	ccMgrForm.form('clear');
	//查询所有分类信息名称
	ccMgrDlg.dialog('open').dialog('setTitle','新建');
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
		$("#t_productId").val(rowData.t_productId);
		$("#t_productName").val(rowData.t_productName);
		$("#t_purchasePrice").val(rowData.t_purchasePrice);
		$("#t_discountPrice").val(rowData.t_discountPrice);
		$("#t_productNum").val(rowData.t_productNum);
		$("#t_origin").val(rowData.t_origin);
		$("#t_categoryType").val(rowData.t_categoryType);
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
		var t_productId = ccMgrForm.find("#t_productId").val();
		var t_productName = $.trim($("#t_productName").val());
//		alert(t_productName);
//		if(null==t_productName){
//			alert('提示信息','您输入不正确!');
////		}
		var t_purchasePrice = ccMgrForm.find("#t_purchasePrice").val();
//		var reg = "^[0-9]*$";
//		if(!reg.is(t_purchasePrice.value)){
//			alert('提示信息','您输入不正确!');
//		}
		var t_discountPrice = ccMgrForm.find("#t_discountPrice").val();
//		var reg2="^[0-9]*$";
//		if(!reg2.is(t_discountPrice.value)){
//			alert('提示信息','您输入不正确!');
//			if(t_discountPrice.value<=t_purchasePrice.value){
//				alert('提示信息','折扣价不能大于原价!');
//			}
//		}
		var t_productNum = ccMgrForm.find("#t_productNum").val();
//		var reg3="^\\d+$";
//		if(!reg3.is(t_productNum.value)){
//			alert('提示信息','您输入不正确!');
//		}
		var t_origin = ccMgrForm.find("#t_origin").val();
//		var reg4="/[\u4E00-\u9FA5]/";
//		var reg5="/[a-zA-Z]/";
//		if(!reg4.is(t_origin.value)||!reg5.is(t_origin.value)){
//			alert('提示信息','您输入不正确!');
//		}
		var t_categoryType = ccMgrForm.find("#t_categoryType").val();
//		if(null==t_categoryType){
//			alert('提示信息','您没有选择商品分类!');
//		}
		var t_desc = ccMgrForm.find("#t_desc").val();
//		if(null==t_desc){
//			alert('提示信息','您不能为空!');
//		}
		var params = {
			"t_productId" : t_productId,
			"t_productName" : t_productName,
			"t_purchasePrice":t_purchasePrice,
			"t_discountPrice":t_discountPrice,
			"t_productNum":t_productNum,
			"t_origin":t_origin,
			"t_categoryType":t_categoryType,
			"t_desc":t_desc
		};
	$.ajax({
			url :$ctx+"/product/mng/chechInfo.htmls",
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
					//编辑模式
					if(ccMgrForm.find("#id").val() != ''){
							submitForm($ctx+'/product/mng/saveProductInfo.htmls');
					}else{//增加模式
							submitForm($ctx+'/product/mng/saveProductInfo.htmls');
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
                   ids += n.t_productId;  
               else  
                   ids += ","+n.t_productId;  
           }); 
	if(rows.length > 0){
		$.messager.confirm('确认','确定要删除所选吗,同时会删除其关联的表数据!?',function(r){
			if (r){
				var params = {
					"t_productId" : ids
				};
				$.ajax( {
						url :$ctx+"/product/mng/delProductInfo.htmls",
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