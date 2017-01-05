<%@ page language="java"
	import="java.util.*,com.jiuyi.jyplant.syscontrol.entity.Users"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文件上传</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/themes/icon.css">
 <link type="text/css" rel="stylesheet" href="<%=path%>/js/jquery-file-upload/bootstrap.min.css">
<script type="text/javascript" src="<%=path%>/js/jquery-file-upload/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="<%=path%>/js/jquery-file-upload/css/jquery.fileupload.css">
<script  type="text/javascript" src="<%=path%>/js/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
<script  type="text/javascript" src="<%=path%>/js/jquery-file-upload/js/jquery.iframe-transport.js"></script>
<script  type="text/javascript" src="<%=path%>/js/jquery-file-upload/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-file-upload/bootstrap.min.js"></script>
  <script type="text/javascript">
function generateFileupload(maxLimitedSize) {
    $('.fileupload').fileupload({
        dataType: 'json',
        add: function (e, data) {
			var file = data.files[0];
			if (file.size > maxLimitedSize) {
				alert("图片过大");
			} else {
				data.submit();
			}
        },
		submit: function (e, data) {
			var $this = $(this);
			data.jqXHR = $this.fileupload('send', data);
			$(this).parent('.btn').attr('disabled', true);
			$(this).parent('.btn').removeClass('btn-success');
			return false;
		},
        done: function (e, data) {
			var id = data.result.id;

			var imgId = data.formData.imgId;
			var btnId = data.formData.btnId;
			var viewUrl = data.formData.viewUrl + id + '&_=' + new Date().getTime();

			$("#" + imgId).html('<img src="' + viewUrl + '" style="width:50px;">');
			$('#' + btnId).attr('disabled', false);
			$('#' + btnId).addClass('btn-success');
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            ).html(progress + '%');
        }
    });
}
$(function () {
	generateFileupload(1024 * 1024);
});
    </script>
</head>
<body class="easyui-layout">
	<div id="p" class="easyui-panel" title="文件上传" fit="true">
        <span id="avatarImage">
		  <img src="user-base-avatar.do?id=11111111111" style="width:50px;">
	  </span>
        <span id="avatarButton" class="btn btn-success fileinput-button">
		<span>上传头像</span>
		<input type="file" name="avatar" class="fileupload"
		  data-no-uniform="true"
		  data-url="user-base-upload.htmls"
		  data-form-data='{"id":"${model.id}","imgId":"avatarImage","btnId":"avatarButton","viewUrl":"user-base-avatar.htmls?id="}'>
	  </span>
	  <div id="progress" class="progress" style="width:200px;margin-top:5px;height:20px;margin-bottom:0px;">
        <div class="bar bar-success"></div>
      </div>     
	</div>
</body>
</html>