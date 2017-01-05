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
 		title : '角色列表',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/background/resources/ajaxQuery.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : false,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'id',//主键字段 
 		frozenColumns: [[
  		                { field: 'ck', checkbox: true },
  		                { title: '资源名称', field: 'text', width: 160, align: 'left', sortable: true }
  		            ]],
  		            columns: [[
  		                { field: 'resKey', title: '资源key', width: 160, align: 'left', sortable: true },
  		                { field: 'description', title: '资源描述', width: 160, align: 'left', sortable: true },
  		                { field: 'resUrl', title: '资源地址', width: 200, align: 'left', sortable: true },
  		                { field: 'parentName', title: '所属资源', width: 200, align: 'left', sortable: true }
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
 		  				}  
 		          	],
 		pagination : true,//分页
 		rownumbers : true,//行数
 		onLoadSuccess:function(data){//加载完毕后获取所有的checkbox遍历
			 $(this).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态
       }
 	});	
}
//查询
function doSearch(){
	$('#tt').datagrid('load',{
		text :$('#text_').val(),
		resKey:$("#resKey_").val()
	});
}
//新建
function newCC(){
	ccMgrDlg.dialog('open').dialog('setTitle','新建');
	//清空表单
	ccMgrForm.form('clear');
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
			names.push(rows[i].text);
		}
		$.messager.alert('提示信息','只能选择一个进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个');
	}else if (rowData){
		ccMgrDlg.dialog('open').dialog('setTitle','编辑');
		 $("#id").val(rowData.id);
		 $("#level").val(rowData.level);
		 $("#type").val(rowData.type);
		 $("#parentName").val(rowData.parentName);
		 $("#parentId").val(rowData.parentId);
		 $("#text").val(rowData.text);
		 $("#resKey").val(rowData.resKey);
		 $("#resUrl").val(rowData.resUrl);
		 $("#description").val(rowData.description);
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
		var text = $.trim($("#text").val());
		var roleKey = ccMgrForm.find("#roleKey").val();
		var description = ccMgrForm.find("#description").val();
		var id = ccMgrForm.find("#id").val();
		var enable = ccMgrForm.find("#enable").val();
		var level = ccMgrForm.find("#level").val();
		var params = {
			"id" : id,
			"name" : text,
			"roleKey" : roleKey,
			"description" : description,
			"enable":enable,
			"level":level
		};
	$.ajax({
			url : $ctx+"/background/resources/chechInfo.htmls",
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
				 $("#text").focus();
				 $("#roleKey").focus();
				 return;
				} else{
					//编辑模式
					if(ccMgrForm.find("#id").val() != ''){
							submitForm($ctx+'/background/resources/saveResources.htmls');
					}else{//增加模式
							submitForm($ctx+'/background/resources/saveResources.htmls');
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
                   ids += "'"+n.id+"'";  
               else  
                   ids += ","+"'"+n.id+"'";  
           });  
	if(rows.length > 0){
		$.messager.confirm('确认','确定要删除所选吗,同时会删除其关联的表数据!?',function(r){
			if (r){
				var params = {
					"resourceIds" : ids
				};
				$.ajax( {
						url : $ctx+"/background/resources/deleteResources.htmls",
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
//加载资源树
var setting_1 = {
	    view: {
	        dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
	        showLine: true,//是否显示节点之间的连线
	        fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
	        selectedMulti: false //设置是否允许同时选中多个节点
	    },
	    data:{ // 必须使用data    
	        simpleData : {    
	            enable : true,    
	            idKey : "mid", // id编号命名     
	            pIdKey : "pId", // 父id编号命名      
	            rootId : "1010"  
	        },
	        keep: {
				parent: true
			}    
	        },    
	    check:{
	        chkStyle: "radio",//复选框类型
	        radioType: "all",
	        enable: true //每个节点上是否显示 CheckBox 
	    },
	    callback: {
	        beforeClick: function(treeId, treeNode) {
	            zTree = $.fn.zTree.getZTreeObj("user_tree");
	            if (treeNode.isParent) {
	                zTree.expandNode(treeNode);//如果是父节点，则展开该节点
	            }else{
	                zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
	            }
	        },
	        onCheck:onCheck_1
	    }
};
//获取选中的值
function onCheck_1(e,treeId,treeNode){
//	if(treeNode.parent){
	    var treeObj=$.fn.zTree.getZTreeObj("resourceTree"),
	       nodes=treeObj.getCheckedNodes(true);
	       $("#parentName").val(nodes[0].name);
	       $("#parentId").val(nodes[0].mid);
	      $("#TreeDlg").dialog('close');		
//	}else{
//		$.messager.alert('提示信息','请选择父节点!');
//	}
}
function loadResourceTree(){
	$("#TreeDlg").dialog('open').dialog('setTitle','添加资源');
	var treeNodes_1="";
    $.ajax({
        async:false,//是否异步
        cache:false,//是否使用缓存
        type:'POST',//请求方式：post
        dataType:'json',//数据传输格式：json
        url:$ctx+"/background/resources/queryResourcesTree.htmls",//请求的action路径
        error:function(){
            //请求失败处理函数
       $.messager.alert('提示信息','获取数据失败!');
        },
        success:function(data){
            //请求成功后处理函数
            treeNodes_1 = data;//把后台封装好的简单Json格式赋给treeNodes
        }
    });
    
	    var t = $("#resourceTree");
	    t = $.fn.zTree.init(t, setting_1, treeNodes_1);
}
//清空选择的资源
function removeSelect(){
	 $("#parentName").val('');
     $("#parentId").val('');
}