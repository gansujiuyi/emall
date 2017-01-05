var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var cpcpe_Grid;

function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 

//加载datagrid
function loadcpevaluateInfoDataGrid(){
	cpe_Grid = $('#cpevaluateInfo').datagrid({
		title : '会员评价列表',
		fit:true,
		pageSize : 10,//默认选择的分页是每页5行数据
		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/cpevaluate/mng/ajaxQuery.htmls',//url调用Action方法
		loadMsg : '数据装载中......',
		singleSelect:false,//为true时只能选择单行
		fitColumns:true,//允许表格自动缩放，以适应父容器
		remoteSort : false,//服务器端排序
		rownumbers:true,//显示行号
		idField:'evalId',//主键字段 
		columns: [[
		                { field: 'ck', checkbox: true },
		                { title: '评价内容', field: 'evalContent', width: 300, align: 'left', sortable: true,
		                	formatter: function (value, data, index) {
	                		      if(value.length>20){
	                		    	  var con = value.substr(0,20)+"......";
	                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+con+'</span>' ;
	                		      }else{
	                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+value+'</span>' ;
	                		      }
	                		}
	                    },
	                    { field: 'evalTime', title: '评价时间', width: 160, align: 'left', sortable: true ,formatter:formatDateBoxFull },
	                    { field: 'evalPersonId', title: '评价人', width: 100, align: 'left', sortable: true},
	                    { field: 'evalProducdId', title: '评价商品', width: 200, align: 'left', sortable: true},
	                    { field: 'evalScore', title: '评价分数', width: 100, align: 'left', sortable: true}
		            ]],
//		           toolbar:
//		  			[
//		          		{
//		  					text : '取消选中',
//		  					iconCls : 'icon-undo',
//		  					handler : function() {
//		  						cpe_Grid.datagrid('unselectAll');
//		  					}
//		  				},'-',
//		          		{
//		  					text : '全部选中',
//		  					iconCls : 'icon-redo',
//		  					handler : function() {
//		  						cpe_Grid.datagrid('selectAll');
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
	$('#cpevaluateInfo').datagrid('load',{
		emTitle :$('#emTitle').val(),
	});
}