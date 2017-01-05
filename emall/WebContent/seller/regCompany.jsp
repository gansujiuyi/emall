<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0055)http://apply.shop.jd.com/apply/flow_contact_view.action -->
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>公司信息</title>
 </head>
 <body>
  <form name="stepForm" id="stepForm" method="post" action="<%=path %>/seller/qualifications.htmls"> 
   <div class="textarea"> 
    <div class="agreement"> 
     <div class="m"> 
      <div class="mt"> 
       <h4 class="title">入驻联系人信息</h4> 
       <br /> 
      </div> 
      <div class="mc"> 
       <dl class="horizontal fl"> 
        <dt>
         <span class="red">*</span> 联系人姓名
        </dt> 
        <dd>
         <input type="text" class="input_txt valid" name="contactName" />
        </dd> 
        <dt>
         <span class="red">*</span> 联系人手机
        </dt> 
        <dd> 
         <input type="text" class="input" name="contactPhone" /> 
        </dd> 
        <dt>
         <span class="red">*</span> 联系人电子邮箱
        </dt> 
        <dd> 
         <input type="text" class="input" name="contactEmail" /> 
        </dd> 
        <dd>
         <span class="lh-30">用于入驻过程中接收京东审核结果、开店账号密码信息，请务必正确填写。</span>
        </dd> 
        <dt>
        <span class="red">*</span>法定代表人姓名
       </dt> 
       <dd> 
        <input type="text" class="input" name="legalRepresentative"  /> 
        <p class="msg-text">请按照营业执照上登记的法人填写</p> 
       </dd> 
<!--        <dt> -->
<!--         <span class="red">*</span>成立日期 -->
<!--        </dt>  -->
<!--        <dd>  -->
<!--         <input id="establishDate" type="text" name="establishDate" />  -->
<!--        </dd>  -->
         <dt>
        <span class="red">*</span>注册资本
       </dt> 
       <dd>
        <input type="text" class="input" name="registeredCapital"  />万元 
       </dd> 
       <dt>
        <span class="red">*</span>公司所在地
       </dt> 
       <dd> 
        <input type="hidden"  name="comAddrIds" id="comAddrIds" /> 
       </dd> 
        <dt>
        <span class="red">*</span>公司详细地址
       </dt> 
       <dd> 
        <input type="text" class="input" name="addr"  /> 
       </dd> 
        <dt>
        <span class="red">*</span>公司电话
       </dt> 
       <dd> 
        <input type="text" class="input" name="contactTel"  /> 
       </dd> 
        <dt>
        <span class="red">*</span>公司紧急联系人
       </dt> 
       <dd> 
        <input type="text" class="input" name="tentactr"  /> 
       </dd> 
       <dt>
        <span class="red">*</span>公司紧急联系人手机
       </dt> 
       <dd> 
        <input type="text" name="tentactrPhone"  /> 
       </dd> 
       <dt>
        <span class="red">*</span>法定代表人证件类型
       </dt> 
       <dd> 
        <input type="radio" class="input" name="cardType" id="cardType1" checked="checked" value="1" /> 
        <label for="cardType1">大陆身份证</label> 
       </dd> 
       <dt> 
        <span class="card" >*法定代表人身份证号</span> 
       </dt> 
       <dd> 
        <input type="text" class="input card" name="personalNo" /> 
        <span class="error" id="cardInfo"> </span> 
       </dd> 
       <dt> 
        <span class="bank">*对公结算银行账号</span> 
       </dt> 
       <dd> 
        <input type="text" class="input card" name="accountNum"/> 
        <span class="error" id="cardInfo"> </span> 
       </dd> 
       <dt> 
        <span class="bank">*开户银行支行名称</span> 
       </dt> 
       <dd> 
        <input type="text" class="input card" name="bankName"  /> 
        <span class="error" id="cardInfo"> </span> 
       </dd> 
<!--         <dt>  -->
<!--         <span class="red">*</span> 法人身份证电子版  -->
<!--        </dt>  -->
<!--        <dd id="comFilePath" class="deletePane b-upload-wrap">  -->
<!--         <p class="msg-text">图片尺寸请确保800px*800px以上，文件大小1MB以内，支持JPG、GIF、PNG格式，最多可上传2张</p>  -->
<!--       	<input type="file" name="upFile" class="fileupload"/> -->
<!--        </dd>  -->
       </dl> 
    	 <input type="submit" value="开始提交" class="btn" id="nextStepBtn"/>
      </div> 
     </div> 
    </div> 
   </div> 
  </form> 
 </body>
</html>