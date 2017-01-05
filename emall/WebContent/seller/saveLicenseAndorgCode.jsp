<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + ":"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
   <html>
 <head></head>
 <body>
  <form name="stepForm" id="stepForm" method="post" action="<%=path %>/seller/bankInfo.htmls"> 
   <div class="panel-body"> 
   	<input type="hidden" name="venderId"/>
    <div class="callout mb10"> 
     <div class="content">
       1. 信息提交前，请务必先了解
      <br /> 2. 公司类信息需填项较多，建议先查看
      <br /> 3. 公司信息请严格按照相关证件信息进行确认填写；
      <br /> 4. 以下所需要上传电子版资质仅支持JPG、GIF、PNG格式的图片，大小不超过1M，且必须加盖企业彩色公章。 
     </div> 
     <div class="remi-dialog" id="checkSecretDialog">
      审核通过秘诀
     </div> 
    </div> 
    <div class="m"> 
     <div class="mt"> 
      <h4 class="title">营业执照信息</h4> 
     </div> 
     <div class="mc"> 
      <dl class="horizontal fl"> 
       <dt>
        <span class="red">*</span>执照类型
       </dt> 
       <dd> 
        <input type="radio" class="input" name="licenseType" id="licenseType1" value="1" checked="checked" /> 
        <label for="licenseType1">普通执照</label> 
       </dd> 
       <dt>
        <span class="red">*</span>公司名称
       </dt> 
       <dd> 
        <input type="text" class="input" name="companyName"  /> 
        <p class="msg-text">请按照营业执照上登记的完整名称填写</p> 
       </dd> 
       <dt>
        <span class="red">*</span>营业执照注册号
       </dt> 
       <dd> 
        <input type="text" class="input" name="businessLicense"  /> 
        <p class="msg-text" zhizhaotype="1" style="display: block;">请按照营业执照上的注册号进行填写</p> 
        <p class="msg-text hidden" zhizhaotype="2" display="none" style="display: none;">请按照营业执照上的统一社会信用代码进行填写</p> 
       </dd> 
       <dt>
        <span class="red">*</span>营业执照所在地
       </dt> 
       <dd> 
        <input type="text" id="licenceRegAddrSubmit" name="licenseAddrIds" /> 
       </dd> 
       <dt>
        <span class="red">*</span>营业执照详细地址
       </dt> 
       <dd> 
        <input type="text" name="licenseAdd" id="address-co" /> 
       </dd> 
       <dt>
        <span class="red">*</span>营业期限
       </dt> 
       <dd> 
        <input id="startDate" type="text" name="licenseExpDateStart" /> — 
        <input id="endDate" type="text"   name="licenseExpDateEnd" /> 
        <input type="checkbox" name="isForEver" id="forever" value="1" />
        <label for="forever">长期</label> 
        <span class="error" id="dateSpan"> </span> 
       </dd> 
      
       <dt>
        <span class="red">*</span>经营范围
       </dt> 
       <dd> 
        <textarea name="licenseArea" style="font-size: 12px; width:300px; height: 70px;"></textarea> 
        <p class="msg-text">请与营业执照或企业信息公示网的经营范围保持一致</p> 
       </dd> 
<!--        <dt> -->
<!--         <span class="red">*</span>营业执照电子版 -->
<!--        </dt>  -->
<!--        <dd id="licenseFilePath"">  -->
<!--         <input type="file" name="upFile" class="fileupload"/> -->
<!--         <p class="msg-text">图片尺寸请确保800px*800px以上，文件大小1MB以内，支持JPG、GIF、PNG格式，最多可上传2张</p>  -->
<!--        </dd>  -->
      </dl> 
     </div> 
    </div> 
    <div class="m"> 
     <div class="mt"> 
      <h4 class="title">组织机构代码证</h4> 
     </div> 
     <div class="mc"> 
      <dl class="horizontal fl"> 
       <dt>
        <span class="red">*</span>组织机构代码
       </dt> 
       <dd> 
        <input type="text" class="input" name="orgCode" /> 
        <p class="msg-text"  style="display: block;">请按照组织机构代码证上的代码填写，不要省略“—”</p> 
        <p class="msg-text hidden"  style="display: none;">三证合一请填写统一社会信用代码</p> 
       </dd> 
       <dt>
        <span class="red">*</span>组织机构代码证有效期
       </dt> 
       <dd> 
        <input id="org_exp_date_start" type="text" name="orgExpDateStart" /> — 
        <input id="org_exp_date_end" type="text" name="orgExpDateEnd" /> 
        <input type="checkbox" name="isForEver" value="1" />
        <label for="forever">长期</label> 
        <span class="error"></span> 
       </dd> 
<!--        <dt> -->
<!--         <span class="red">*</span>组织机构代码证电子版 -->
<!--        </dt>  -->
<!--        <dd id="orgFilePath" >  -->
<!--         <input type="file" name="upFile" class="fileupload"/> -->
<!--        </dd>  -->
      </dl> 
     </div> 
    </div> 
    <div class="btn-group t-r"> 
    <input type="submit" > 
    </div> 
   </div> 
  </form>
 </body>
</html>