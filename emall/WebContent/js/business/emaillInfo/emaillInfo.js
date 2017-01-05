var js=document.scripts;  
var url=js[js.length-1].src;  
var $ctx=getQueryString(url,'ctx'); 
var e_Grid;

function getQueryString(url,name){  
    var reg = new RegExp("(\\?|&)"+ name +"=([^&]*)(&|$)");  
    var r = url.substr(1).match(reg);  
    if(r!=null)return unescape(r[2]); return null;  
} 

//加载datagrid
function loademaillInfoDataGrid(){
	e_Grid = $('#emaillInfos').datagrid({
		title : '会员列表列表',
		fit:true,
		pageSize : 10,//默认选择的分页是每页5行数据
		pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
		nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		striped : true,//设置为true将交替显示行背景。
		url:$ctx+'/emaill/mng/ajaxQuery.htmls',//url调用Action方法
		loadMsg : '数据装载中......',
		singleSelect:false,//为true时只能选择单行
		fitColumns:true,//允许表格自动缩放，以适应父容器
		remoteSort : false,//服务器端排序
		rownumbers:true,//显示行号
		idField:'emId',//主键字段 
		frozenColumns: [[
		                { field: 'ck', checkbox: true },
		                { title: '邮件主题', field: 'emTitle', width: 200, align: 'left', sortable: true,
		                	formatter: function (value, data, index) {
	                		      if(value.length>20){
	                		    	  var con = value.substr(0,20)+"......";
	                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+con+'</span>' ;
	                		      }else{
	                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+value+'</span>' ;
	                		      }
	                		}
	                    }
		            ]],
		            columns: [[
		                { field: 'toWhere', title: '接收人', width: 180, align: 'left', sortable: true },
		                { field: 'emContent', title: '邮件内容', width: 400, align: 'left', sortable: true,
		                	formatter: function (value, data, index) {
		                		      if(value.length>20){
		                		    	  var con = value.substr(0,20)+"......";
		                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+con+'</span>' ;
		                		      }else{
		                		    	  return '<span title="'+value+'"  class="easyui-tooltip">'+value+'</span>' ;
		                		      }
		                		}
		                    },
		                { field: 'emTimes', title: '创建时间', width: 200, align: 'left', sortable: true ,formatter:formatDateBoxFull },
		                { field: 'emStimes', title: '发送时间', width: 200, align: 'left', sortable: true ,formatter:formatDateBoxFull },
		                { field: 'emStatus', title: '发送状态', width: 200, align: 'left', sortable: true ,
							 formatter:function(val,rec){ 
									if (val==0){ 
									return '<span>未发送</span>'; 
									} else { 
										return '<span>已发送</span>';  
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
		  						e_Grid.datagrid('unselectAll');
		  					}
		  				},'-',
		          		{
		  					text : '全部选中',
		  					iconCls : 'icon-redo',
		  					handler : function() {
		  						e_Grid.datagrid('selectAll');
		  					}
		  				}  
		          	],
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
	$('#emaillInfos').datagrid('load',{
		emTitle :$('#emTitle').val(),
	});
}