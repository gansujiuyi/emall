<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/themes/icon.css">
<link rel="stylesheet" href="<%=path%>/css/zTree/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=path%>/css/common.css" type="text/css">
<script type="text/javascript" src="<%=path%>/js/highcharts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/dateFormat.js"></script>
<script type="text/javascript" src="<%=path%>/js/youjian.js"></script>
<script type="text/javascript" src="<%=path%>/js/zTree/jquery.ztree.core-3.5.js"></script><!--则是zTree的核心js文件，这个是必须的-->
<script type="text/javascript" src="<%=path%>/js/zTree/jquery.ztree.excheck-3.5.js"></script>
<script src="<%=path%>/js/highcharts/highcharts.js"></script>
<script src="<%=path%>/js/highcharts/modules/exporting.js"></script>
<script type="text/javascript">
$(function(){ 
    //.ajaxError事件定位到document对象，文档内所有元素发生ajax请求异常，都将冒泡到document对象的ajaxError事件执行处理
    $(document).ajaxError(

            //所有ajax请求异常的统一处理函数，处理
            function(event,xhr,options,exc ){
                if(xhr.status == 'undefined'){
                    return;
                }
                switch(xhr.status){
                    case 403:
                        $.messager.alert('错误','系统拒绝：您没有访问权限!','error');
                        break;

                    case 404:
							$.messager.alert('错误','您访问的资源不存在!','error');
                        break;
                }
            }
    );
});
</script>
</head>
</html>