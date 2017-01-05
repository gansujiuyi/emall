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

function addTab(title, url){
	//检查session是否已经失效
	    $.ajax( {
	url : $ctx+"/background/checkSession.htmls",
	dataType : "json",
	cache : false,
	error : function(textStatus, errorThrown) {
//		$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
	},
	success : function(data, textStatus) {
		if (data==true) {
			 if ($('#center_').tabs('exists', title)){
		         $('#center_').tabs('select', title);
		        	//刷新当前tab
		            var currTab =  self.parent.$('#center_').tabs('getSelected'); //获得当前tab
		            var url_ = $(currTab.panel('options').content).attr('src');
		            if(url!=url_){
		            	url_ = url;
		             }
		              self.parent.$('#center_').tabs('update', {
		              tab : currTab,
		              options : {
		               content : '<iframe scrolling="auto" frameborder="0"  src="'+url_+'" style="width:100%;height:100%;"></iframe>'
		              }
		             });
		        } else {
		            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		            $('#center_').tabs('add',{
		                title:title,
		                content:content,
		                closable:true
		            });
		        }
		} else {
			$.messager.alert('提示信息','会话已失效!3秒后系统自动刷新页面,请重新登录系统!');
			setTimeout(refsh(), 3000 );
		}
	}
});
}

function initCahrt(){
	 Highcharts.setOptions({
         lang: {
               printChart:"打印图表",
               downloadJPEG: "下载JPEG 图片" , 
               downloadPDF: "下载PDF文档"  ,
               downloadPNG: "下载PNG 图片"  ,
               downloadSVG: "下载SVG 矢量图" , 
               exportButtonTitle: "导出图片"
         }
     });
	 
	  Highcharts.chart('container_1', {
          chart: {
              plotBackgroundColor: null,
              plotBorderWidth: null,
              plotShadow: false,
              type: 'pie'
          },
          title: {
              text: '会员注册统计'
          },
          tooltip: {
              pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
          },
          plotOptions: {
              pie: {
                  allowPointSelect: true,
                  cursor: 'pointer',
                  dataLabels: {
                      enabled: false
                  },
                  showInLegend: true
              }
          },
          series: [{
              name: '注册率',
              colorByPoint: true,
              data: [{
                  name: '互联网',
                  y: 56.33,
                  color:"#8085e9"
              }, {
                  name: '微信',
                  y: 24.03,
                  color:"#90ed7d"
//                  sliced: true
                  //selected: true
              }]
          }]
      });
	  
	  
	  Highcharts.chart('container_2', {
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '图表2'
	        },
	        subtitle: {
	            text: '子标题'
	        },
	        xAxis: {
	            type: 'category'
	        },
	        yAxis: {
	            title: {
	                text: 'Total percent market share'
	            }

	        },
	        legend: {
	            enabled: false
	        },
	        plotOptions: {
	            series: {
	                borderWidth: 0,
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.y:.1f}%'
	                }
	            }
	        },

	        tooltip: {
	            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
	        },

	        series: [{
	            name: 'Brands',
	            colorByPoint: true,
	            data: [{
	                name: 'Microsoft Internet Explorer',
	                y: 56.33,
	                drilldown: 'Microsoft Internet Explorer'
	            }, {
	                name: 'Chrome',
	                y: 24.03,
	                drilldown: 'Chrome'
	            }, {
	                name: 'Firefox',
	                y: 10.38,
	                drilldown: 'Firefox'
	            }, {
	                name: 'Safari',
	                y: 4.77,
	                drilldown: 'Safari'
	            }, {
	                name: 'Opera',
	                y: 0.91,
	                drilldown: 'Opera'
	            }, {
	                name: 'Proprietary or Undetectable',
	                y: 0.2,
	                drilldown: null
	            }]
	        }],
	        drilldown: {
	            series: [{
	                name: 'Microsoft Internet Explorer',
	                id: 'Microsoft Internet Explorer',
	                data: [
	                    [
	                        'v11.0',
	                        24.13
	                    ],
	                    [
	                        'v8.0',
	                        17.2
	                    ],
	                    [
	                        'v9.0',
	                        8.11
	                    ],
	                    [
	                        'v10.0',
	                        5.33
	                    ],
	                    [
	                        'v6.0',
	                        1.06
	                    ],
	                    [
	                        'v7.0',
	                        0.5
	                    ]
	                ]
	            }, {
	                name: 'Chrome',
	                id: 'Chrome',
	                data: [
	                    [
	                        'v40.0',
	                        5
	                    ],
	                    [
	                        'v41.0',
	                        4.32
	                    ],
	                    [
	                        'v42.0',
	                        3.68
	                    ],
	                    [
	                        'v39.0',
	                        2.96
	                    ],
	                    [
	                        'v36.0',
	                        2.53
	                    ],
	                    [
	                        'v43.0',
	                        1.45
	                    ],
	                    [
	                        'v31.0',
	                        1.24
	                    ],
	                    [
	                        'v35.0',
	                        0.85
	                    ],
	                    [
	                        'v38.0',
	                        0.6
	                    ],
	                    [
	                        'v32.0',
	                        0.55
	                    ],
	                    [
	                        'v37.0',
	                        0.38
	                    ],
	                    [
	                        'v33.0',
	                        0.19
	                    ],
	                    [
	                        'v34.0',
	                        0.14
	                    ],
	                    [
	                        'v30.0',
	                        0.14
	                    ]
	                ]
	            }, {
	                name: 'Firefox',
	                id: 'Firefox',
	                data: [
	                    [
	                        'v35',
	                        2.76
	                    ],
	                    [
	                        'v36',
	                        2.32
	                    ],
	                    [
	                        'v37',
	                        2.31
	                    ],
	                    [
	                        'v34',
	                        1.27
	                    ],
	                    [
	                        'v38',
	                        1.02
	                    ],
	                    [
	                        'v31',
	                        0.33
	                    ],
	                    [
	                        'v33',
	                        0.22
	                    ],
	                    [
	                        'v32',
	                        0.15
	                    ]
	                ]
	            }, {
	                name: 'Safari',
	                id: 'Safari',
	                data: [
	                    [
	                        'v8.0',
	                        2.56
	                    ],
	                    [
	                        'v7.1',
	                        0.77
	                    ],
	                    [
	                        'v5.1',
	                        0.42
	                    ],
	                    [
	                        'v5.0',
	                        0.3
	                    ],
	                    [
	                        'v6.1',
	                        0.29
	                    ],
	                    [
	                        'v7.0',
	                        0.26
	                    ],
	                    [
	                        'v6.2',
	                        0.17
	                    ]
	                ]
	            }, {
	                name: 'Opera',
	                id: 'Opera',
	                data: [
	                    [
	                        'v12.x',
	                        0.34
	                    ],
	                    [
	                        'v28',
	                        0.24
	                    ],
	                    [
	                        'v27',
	                        0.17
	                    ],
	                    [
	                        'v29',
	                        0.16
	                    ]
	                ]
	            }]
	        }
	    });
	  
	  
	  Highcharts.chart('container_3', {
	        title: {
	            text: '图表3',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '子标题',
	            x: -20
	        },
	        xAxis: {
	            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
	        },
	        yAxis: {
	            title: {
	                text: 'Temperature (°C)'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            valueSuffix: '°C'
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        series: [{
	            name: 'Tokyo',
	            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
	        }, {
	            name: 'New York',
	            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
	        }, {
	            name: 'Berlin',
	            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
	        }, {
	            name: 'London',
	            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
	        }]
	    });
}
//修改密码弹出框
function changePwd(){
	  $("#PasswordDlg").dialog('open').dialog('setTitle','修改密码');
}
//密码强度
function onCheck(){
	var uId = $("#uId").val();//旧密码
	var pass = $("#pass").val();//旧密码
	var pass_1 = $("#pass_1").val();//新密码
	var pass_2 = $("#pass_2").val();//重复新密码
	if(null==pass || ""==pass){
		$("#pass").focus();
		$.messager.alert('提示','旧密码不能为空!','warning');
		return;
	}
	if(null==pass_1 || ""==pass_1){
		$.messager.alert('提示','新密码不能为空!','warning');
		return;
	}else if(pass_1.length<8){
		$("#pass_1").focus();
		$.messager.alert('提示','密码长度不能少于8位!','warning');
		return;
	}
	if(null==pass_2 || ""==pass_2){
		$("#pass_2").focus();
		$.messager.alert('提示','重复密码不能为空!','warning');
		return;
	}else if(pass_2.length<8){
		$("#pass_2").focus();
		$.messager.alert('提示','密码长度不能少于8位!','warning');
		return;
	}
	if(pass ==  pass_1){
		$.messager.alert('提示','新密码不能和旧密码相同!','warning');
		return;
	}
	if(pass_1 !=  pass_2){
		$("#pass_1").focus();
		$.messager.alert('提示','2次输入的密码不一致,请检查!','warning');
		return ;
	}
	var params = {
			"userIds":uId,
			"oldPwd":pass,
			"newPwd":pass_2
		};
		$.ajax( {
				url : $ctx+"/background/user/upUserPassword.htmls",
				data : params,
				dataType : "json",
				cache : false,
				error : function(textStatus, errorThrown) {
//					$.messager.alert('消息',"系统交互错误: " + textStatus,'error');
				},
				success : function(data, textStatus) {
					if (data=="0") {
						 $.messager.alert('', '密码修改成功,请重新登录系统!', 'info', function () {  window.parent.location.href=$ctx+"/background/index.htmls"; });
						$("#PasswordDlg").dialog('close');
					} else if(data=="1") {
						$.messager.alert('提示信息','旧密码输入错误!');
					}else if(data=="2"){
						$.messager.alert('提示信息','修改密码失败!');
					}
				}
		});
}
  