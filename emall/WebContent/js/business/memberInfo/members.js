var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var m_Grid;

function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 

//加载datagrid
function loadMemberDataGrid(){
	m_Grid = $('#memberInfos').datagrid({
 		title : '会员列表列表',
 		fit:true,
 		pageSize : 10,//默认选择的分页是每页5行数据
 		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
 		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
 		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/memberInfo/member/ajaxQuery.htmls',//url调用Action方法
 		loadMsg : '数据装载中......',
 		singleSelect:false,//为true时只能选择单行
 		fitColumns:true,//允许表格自动缩放，以适应父容器
 		remoteSort : false,//服务器端排序
 		rownumbers:true,//显示行号
 		idField:'memberId',//主键字段 
 		frozenColumns: [[
  		                { field: 'ck', checkbox: true },
  		                { title: '会员名称', field: 'memberName', width: 160, align: 'left', sortable: true }
  		            ]],
  		            columns: [[
  		                { field: 'memberEmail', title: '会员邮箱', width: 160, align: 'left', sortable: true },
  		                { field: 'memberRealName', title: '真实姓名', width: 160, align: 'left', sortable: true },
  		                { field: 'memberSex', title: '会员性别', width: 200, align: 'left', sortable: true ,
							 formatter:function(val,rec){ 
									if (val=='0'){ 
									return '<span>男</span>'; 
									} else { 
										return '<span>女</span>';  
									}  }},
  		                { field: 'memberRegTime', title: '注册时间', width: 200, align: 'left', sortable: true ,formatter:formatDateBoxFull },
  		                { field: 'memberStatus', title: '会员状态', width: 200, align: 'left', sortable: true ,
							 formatter:function(val,rec){ 
									if (val=="0"){ 
									   return '<span>禁用</span>'; 
									} else if(val=="1") { 
										return '<span>启用</span>';  
									}else if(val=="2"){
										return '<span>待激活</span>';  
									}
								}
  		                }
  		            ]],
 		           toolbar:
 		  			[
 		          		{
 		  					text : '取消选中',
 		  					iconCls : 'icon-undo',
 		  					handler : function() {
 		  						m_Grid.datagrid('unselectAll');
 		  					}
 		  				},'-',
 		          		{
 		  					text : '全部选中',
 		  					iconCls : 'icon-redo',
 		  					handler : function() {
 		  						m_Grid.datagrid('selectAll');
 		  					}
 		  				},'-',
 		          		{
 		  					text : '启用',
 		  					iconCls : 'icon-ok',
 		  					handler : function() {
 		  						restMember("1");
 		  					}
 		  				},'-',
 		          		{
 		  					text : '禁用',
 		  					iconCls : 'icon-no',
 		  					handler : function() {
 		  						restMember("0");
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
	$('#memberInfos').datagrid('load',{
		memberName :$('#memberName').val()
	});
}
//启|禁用会员
function restMember(v){
	 var rows = m_Grid.datagrid('getSelections');  
     var ids = "";  
     $.each(rows,function(i,n){  
         if(i==0)   
             ids += "'"+n.memberId+"'";  
         else  
             ids += ","+"'"+n.memberId+"'";  
     });  
if(rows.length > 0){
	$.messager.confirm('确认','确定要操作所选吗!?',function(r){
		if (r){
			var params = {
				"memberIds" : ids,
				"enable":v
			};
			$.ajax( {
					url : $ctx+"/memberInfo/member/restMemberStatus.htmls",
					data : params,
					dataType : "json",
					cache : false,
					error : function(textStatus, errorThrown) {
						//$.messager.alert('消息',"系统交互错误:" ,'error');
					},
					success : function(data, textStatus) {
						if (data==true) {
							m_Grid.datagrid('reload');
							if(val==1){
								$.messager.alert('提示信息','启用成功!');	
							}else{
								$.messager.alert('提示信息','禁用成功!');
							}
						} else {
							$.messager.alert('提示信息','操作失败!');
						}
					}
			});
		}
	});
}else{
	$.messager.alert('提示信息','请先选择需要启用会员的行!');
}
}