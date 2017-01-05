var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var co_Grid;

function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 

//加载datagrid
function loadcollectInfoDataGrid(){
	co_Grid = $('#collectInfo').datagrid({
		title : '会员收藏列表',
		fit:true,
		pageSize : 10,//默认选择的分页是每页5行数据
		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/collect/mng/ajaxQuery.htmls',//url调用Action方法
		loadMsg : '数据装载中......',
		singleSelect:false,//为true时只能选择单行
		fitColumns:true,//允许表格自动缩放，以适应父容器
		remoteSort : false,//服务器端排序
		rownumbers:true,//显示行号
		idField:'collectId',//主键字段 
        columns: [[
		           { field: 'ck', checkbox: true },
	                { field: 'collectPersonId', title: '收藏人', width: 180, align: 'left', sortable: true },
	                { field: 'collectTiem', title: '收藏时间', width: 200, align: 'left', sortable: true ,formatter:formatDateBoxFull },
	                { field: 'collectProductId', title: '收藏商品', width: 200, align: 'left', sortable: true ,formatter:formatDateBoxFull },
	                { field: 'collectShopId', title: '收藏店铺', width: 200, align: 'left', sortable: true }
	            ]],
//		           toolbar:
//		  			[
//		          		{
//		  					text : '取消选中',
//		  					iconCls : 'icon-undo',
//		  					handler : function() {
//		  						co_Grid.datagrid('unselectAll');
//		  					}
//		  				},'-',
//		          		{
//		  					text : '全部选中',
//		  					iconCls : 'icon-redo',
//		  					handler : function() {
//		  						co_Grid.datagrid('selectAll');
//		  					}
//		  				}  
//		          	],
		pagination : true,//分页
		rownumbers : true,//行数
		onLoadSuccess:function(data){//加载完毕后获取所有的checkbox遍历
			 $(this).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态
			 $(".easyui-tooltip").tooltip({
                 onShow: function () {
                     $(this).tooltip('tip').css({
                         borderColor: '#000'
                     });
                 }
             });
     }
	});	
}
//查询
function doSearch(){
	$('#collectInfo').datagrid('load',{
		emTitle :$('#emTitle').val(),
	});
}