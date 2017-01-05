<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0070)http://apply.shop.jd.com/apply/flow_notice_view.action?flowType=normal -->
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 </head>
 <body>
  <form name="stepForm" id="stepForm" method="post" action="<%=path %>/seller/contactWay.htmls"> 
   <div class="panel-body ruzhu-wrap"> 
    <p class="b-p01">秉承“客户为先，诚信至上”的宗旨、 “让生活变得简单，快乐！”为我们的最终目标，为广大用户提供最优质的商品及服务。 开放平台欢迎国际国内知名品牌、拥 有特色货品及垂直电商入驻。</p> 
    <dl class="help-box"> 
     <dt>
      一、请认真查阅入驻相关说明，准备入驻资质：
     </dt> 
    </dl> 
    <dl class="help-box"> 
     <dt>
      二、以下规则，对于进驻开放平台的商家至关重要,请务必仔细阅读：
     </dt> 
     <dd> 
      
     </dd> 
    </dl> 
    <dl class="help-box"> 
     <dt>
      三、为协助新商家顺利入驻，开放平台为新入驻商家提供了丰富的基础培训教程：
     </dt> 
     <dd> 
      <p class="b-p02">1、关于新商家入驻后的必修课程，请进入“卖家培训”模板查看 </p> 
     </dd> 
    </dl> 
    <dl class="help-box"> 
     <dt>
      四、了解其他运营规则及信息：
     </dt> 
     <dd> 
      <p class="b-p02">请登录商家帮助中心查看</p> 
     </dd> 
    </dl> 
   </div> 
   	<div class="btn-group ml10 t-r">
		<input type="submit" value="开始提交" class="btn" id="nextStepBtn">
	</div>
  </form>
</body>
</html>