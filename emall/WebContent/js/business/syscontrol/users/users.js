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
//加载数据
function loadRoleDataGrid(){
	ccMgrForm = $("#ccMgrForm").form();
	ccMgrDlg = $("#ccMgrDlg");
	ccRuleDialog = $("#ccRuleDialog");
	ccGrid =$('#tt').datagrid({
		title : '用户列表',
 		fit : true,
 		method:'post',
		autoRowHeight: true,
 		pageSize : 10,//默认选择的分页是每页10行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/background/user/ajaxQuery.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : false,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'userId',//主键字段 
		sortOrder: 'asc',
 		toolbar:
			[
				{  
            		text:'启用',  
            		iconCls:'icon-ok',
            		handler:function(){  
            			setUserStatus("1");
            		}  
        		},'-',
        		{  
            		text:'停用',  
            		iconCls:'icon-no',  
            		handler:function(){  
            			setUserStatus("0");
            	}  
        		},'-',
	          		{
	  					text : '用户授权',
	  					iconCls:'icon-man',
	  					handler : function() {
	  						loadRolesTree();
	  					}
	  			},'-',
        		{
					text : '全部选中',
					iconCls : 'icon-redo',
					handler : function() {
						ccGrid.datagrid('selectAll');
						
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
 		        frozenColumns: [[
 		                { field: 'ck', checkbox: true },
 		                { title: '用户名', field: 'userName', width: 160, align: 'left', sortable: true }
 		            ]],
 		            columns: [[
 		                { field: 'userNickname', title: '昵称', width: 160, align: 'left', sortable: true },
 		                { field: 'userRealname', title: '真实姓名', width: 160, align: 'left', sortable: true },
 		                { field: 'userSex', title: '性别', width: 160, align: 'left', sortable: true,
 		                	 formatter:function(val,rec){ 
									if (val==0){ 
									return '<span>男</span>'; 
									} else { 
										return '<span>女</span>';  
									} 
								}},
 		                { field: 'userPhone', title: '联系电话', width: 200, align: 'left', sortable: true },
 		                { field: 'userMail', title: '电子邮箱', width: 200, align: 'left', sortable: true },
 		                { field: 'regTime', title: '注册时间', width: 200, align: 'left', sortable: true,formatter:formatDateBoxFull},
 		                { field: 'ustatus', title: '用户状态', width: 200, align: 'left', sortable: true,
							 formatter:function(val,rec){ 
									if (val==0){ 
									return '<span>禁用</span>'; 
									} else { 
										return '<span>启用</span>';  
									} 
								}}
 		               
 		            ]],
 		pagination : true,//分页
 		rownumbers : true,//行数 
 		onLoadSuccess:function(data){//加载完毕后获取所有的checkbox遍历
 			 $(this).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态
            if (data.rows.length > 0) {
                //循环判断操作为新增的不能选择
                for (var i = 0; i < data.rows.length; i++) {
                    //根据operate让某些行不可选
                    if (data.rows[i].userName == "Administrator") {
                        //$("input[type='checkbox']")[i + 1].disabled = true;
                    }
                }
            }
        },
        onSelectAll : function(rows) {  
            //根据status值  全选时某些行不选中  
            $.each(rows, function(i, n) {  
                if (n.userName == "Administrator") {  
                    $('#tt').datagrid('unselectRow', i);  
                }  
            });  
        }  
 	});	
}
function doSearch(){
	$('#tt').datagrid('load',{
		userName :$('#userName_').val(),
		userPhone:$('#userPhone_').val(),
		userMail:$('#userMail_').val()
	});
}

//点击清空按钮出发事件
function clearSearch() {
    $("#tt").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
    $("#searchForm").find("input").val("");//找到form表单下的所有input标签并清空
}

//启用|停用用户
function setUserStatus(v){
	 var rows = ccGrid.datagrid('getSelections');  
     var ids = "";  
     $.each(rows,function(i,n){  
         if(i==0)   
             ids += "'"+n.userId+"'";  
         else  
             ids += ","+"'"+n.userId+"'";  
     });
if(rows.length > 0){
	$.messager.confirm('确认','确定要操作所选吗?',function(r){
		if (r){
			var params = {
				"userIds" : ids,
				"status":v
			};
				$.ajax( {
						url : $ctx+"/background/user/restUserStatus.htmls",
						data : params,
						dataType : "json",
						cache : false,
						error : function(textStatus, errorThrown) {
//							$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
						},
						success : function(data, textStatus) {
							if (data==true) {
								ccGrid.datagrid('reload');
								$.messager.alert('提示信息','操作成功!');
							} else {
								$.messager.alert('提示信息','操作失败!');
							}
						}
				});
			}
		});
	}else{
		$.messager.alert('提示信息','请先选择需要操作的行!');
	}
}

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
	            rootId : 0  
	        }    
	        },    
	    check:{
	        chkboxType: { "Y": "ps", "N": "ps" },
	        chkStyle: "checkbox",//复选框类型
	        enable: true //每个节点上是否显示 CheckBox 
	    },
	    callback: {
	        beforeClick: function(treeId, treeNode) {
	            zTree = $.fn.zTree.getZTreeObj("rolesTree");
	            if (treeNode.isParent) {
	                zTree.expandNode(treeNode);//如果是父节点，则展开该节点
	            }else{
	                zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
	            }
	        },
	        onCheck:onCheck_1
	    }
	};

function loadRolesTree(){
	var rows = ccGrid.datagrid('getSelections');
	var rowData = ccGrid.datagrid('getSelected');
	if(rows.length==0){  
         $.messager.alert('提示信息','请选择你要授权的数据!');
   		 return;  
	}else if (rows.length != 1 && rows.length > 0) {
		var names = [];
		for ( var i = 0; i < rows.length; i++) {
			names.push(rows[i].name);
		}
		$.messager.alert('提示信息','只能选择一个进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个');
	}else if (rowData){
		$("#TreeDlg").dialog('open').dialog('setTitle','角色授权');
		var params = {"userId" : "'"+rowData.userId+"'" };
		$("#userId").val("'"+rowData.userId+"'");
	var treeNodes_1="";
    $.ajax({
        async:false,//是否异步
        cache:false,//是否使用缓存
        type:'POST',//请求方式：post
        dataType:'json',//数据传输格式：json
        data : params,
        url:$ctx+"/background/role/queryRolesTree.htmls",//请求的action路径
        error:function(){
            //请求失败处理函数
       $.messager.alert('提示信息','获取数据失败!');
        },
        success:function(data){
            //请求成功后处理函数
            treeNodes_1 = data;//把后台封装好的简单Json格式赋给treeNodes
        }
    });
    
	    var t = $("#rolesTree");
	    t = $.fn.zTree.init(t, setting_1, treeNodes_1);
  }
}
//获取选中的值
function onCheck_1(e,treeId,treeNode){
	var roleIds="";
	    var treeObj=$.fn.zTree.getZTreeObj("rolesTree"),
	       nodes=treeObj.getCheckedNodes(true);
	    for(var i=0;i<nodes.length;i++){
	    	roleIds+="'"+nodes[i].mid+"'"+","; //获取选中节点的值
	    }
//	    return  roleIds;
	    var temp =null;
	    if(roleIds.lastIndexOf(",")>0){
	    	temp=roleIds.substring(0, roleIds.lastIndexOf(","));
	    }
	    return  temp;
}
    
function onCheck(){
	var roleIds = onCheck_1();
//	if(""==roleIds){
//		$.messager.alert('提示信息','请选择需要授权的资源!');
//		return;
//	}
	var params = {
			"resourceIds":null,
			"roleIds_":roleIds,
			 userIds:$("#userId").val(),
			 optType:"userRole",
		};
		$.ajax( {
				url : $ctx+"/background/role/saveUserResourceByRole.htmls",
				data : params,
				dataType : "json",
				cache : false,
				error : function(textStatus, errorThrown) {
//					$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
				},
				success : function(data, textStatus) {
					if (data==true) {
						ccGrid.datagrid('reload');
						 $.messager.alert('', '授权成功,请重新登录系统!', 'info', function () {  window.parent.location.href=$ctx+"/background/index.htmls"; });
						$("#TreeDlg").dialog('close');
					} else {
						$.messager.alert('提示信息','授权失败!');
					}
				}
		});
}