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
  <form name="stepForm" id="stepForm" method="post" action="http://apply.shop.jd.com/apply/flow_com_new_doSaveBank.action?"> 
   <div class="panel-body"> 
    <div class="callout mb10"> 
     <div class="content">
       1. 信息提交前，请务必先了解 
      <a href="http://help.jd.com/Vender/viewQuestion-1004-2597.html" class="link-blue" target="_blank">京东开放平台招商资质标准细则；</a> 
      <br /> 2. 公司类信息需填项较多，建议先查看 
      <a href="http://help.jd.com/Vender/viewQuestion-779-2553.html" class="link-blue" target="_blank">公司信息注意事项</a>再进行填写； 
      <br /> 3. 公司信息请严格按照相关证件信息进行确认填写； 
      <br /> 4. 以下所需要上传电子版资质仅支持JPG、GIF、PNG格式的图片，大小不超过1M，且必须加盖企业彩色公章。 
     </div> 
     <div class="remi-dialog" id="checkSecretDialog">
       审核通过秘诀 
     </div> 
    </div> 
    <div class="m"> 
     <div class="mt"> 
      <h4 class="title">税务登记证</h4> 
     </div> 
     <div class="mc"> 
      <dl class="horizontal fl"> 
       <dt> 
        <span class="red">*</span>纳税人类型 
       </dt> 
       <dd> 
        <select name="taxType" id="taxType" class="select"> <option value="">请选择</option> <option value="GENERAL_TAXPAYER">一般纳税人 </option> <option value="SMALL_TAXPAYERS">小规模纳税人 </option> <option value="NON_VAT_TAXPAYER">非增值税纳税人 </option> </select> 
       </dd> 
       <dt> 
        <span class="tax" taxtype="1" style="display: block;"><span class="red">*</span>纳税人识别号</span> 
        <span class="tax" taxtype="2" style="display: none;"><span class="red">*</span>税号</span> 
       </dt> 
       <dd> 
        <input type="text" class="input" name="taxNo" value="" /> 
        <p class="msg-text">三证合一的请填写统一社会信用代码</p> 
       </dd> 
       <dt> 
        <span class="red">*</span>纳税类型税码 
       </dt> 
       <dd> 
        <select name="taxNum" class="select" id="taxsNum"> <option value="">请选择</option> <option value="0">0%</option> <option value="11">11%</option> <option value="13">13%</option> <option value="13M">图书13%免税</option> <option value="17">17%</option> <option value="3">3%</option> <option value="6">6%</option> <option value="7">7%</option> </select> 
       </dd> 
       <dt> 
        <span class="red">*</span>税务登记证电子版 
       </dt> 
       <dd id="taxFilePath" class="deletePane b-upload-wrap"> 
        <p class="upload-msg">请同时上传国税、地税的税务登记证，两者缺一不可，复印件加盖公司红章，<a href="http://img30.360buyimg.com/popshop/jfs/t3424/328/182189182/85079/40211f0a/580589b9Nedc31771.jpg" target="_blank" class="link-blue">[国地税合一示例]</a>&nbsp;&nbsp;<a href="http://img30.360buyimg.com/popshop/jfs/t3811/325/35717947/160242/885f8d7b/58058b02Nbc611ce4.jpg" target="_blank" class="link-blue">[国地税非合一示例]</a> 如贵司所在地区已推行“三证合一”，此处请上传营业执照副本电子版。</p> 
        <ul id="taxFilePath_container" class="upload-wrap"> 
         <li id="taxFilePath_btn" class="li-item upload-btn" style="z-index: 0;"> 
          <s class="icon-upload"></s> </li> 
        </ul> 
        <p id="taxFilePath_msg" class="msg-error"></p> 
        <p class="msg-text">图片尺寸请确保800px*800px以上，文件大小1MB以内，支持JPG、GIF、PNG格式，最多可上传1张</p> 
       </dd> 
       <dt>
         一般纳税人资格证电子版 
       </dt> 
       <dd>
     	<input type="file" name="upFile" class="fileupload"/> 
       </dd>
      </dl> 
     </div> 
    </div> 
    <input type="submit" value="进入店铺注册"/>
    </div> 
  </form>  
 </body>
</html>