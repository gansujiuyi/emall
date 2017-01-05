package com.jiuyi.jyplant.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.member.service.MemberInfoService;
import com.jiuyi.jyplant.utils.PageResults;

/**
 * 会员管理
 * 
 * @author baizilin
 * @version 1.0v
 */
@Controller
@RequestMapping("/memberInfo/member/")
public class MemberInfoControl {

	Logger log = Logger.getLogger(MemberInfoControl.class);

	@Autowired
	private MemberInfoService memberInfoService;

	/**
	 * 进入会员查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query() {
		return "/pages/memberInfo/m_list";
	}
	
	
	/**
	 * 分页查询会员信息
	 * @param memberInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="ajaxQuery")
	@ResponseBody
	public PageResults<MemberInfo>  ajaxQuery( @ModelAttribute("memberInfo") MemberInfo memberInfo,Integer page , Integer rows){
		PageResults<MemberInfo> pageResults = null;
		if(null==page){
			pageResults = new PageResults<MemberInfo>(1  ,10);
		}else{
			pageResults = new PageResults<MemberInfo>(page , rows);
		}
		pageResults = memberInfoService.queryPageMemberInfo(memberInfo ,pageResults);
		return pageResults;
	}
	
	/**
	 * 启|禁用会员
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/restMemberStatus")
	@ResponseBody
	public String restMemberStatus(String memberIds ,String enable) {
		if(memberInfoService.updateMemberStatus(memberIds ,enable)){
			return "true";
		}
		return "false"; 
	}

	/***
	 * 会员激活
	 */
	@RequestMapping(value = "/memberOpt")
	@ResponseBody
	public ModelAndView memberOpt(HttpServletRequest request,HttpServletResponse response , MemberInfo memberInfo){
		ModelAndView modelAndView = new ModelAndView();
		 String action = request.getParameter("action");
		 if("register".equals(action)) {
	            //注册
	            if(memberInfoService.processregister(memberInfo)){
	            	//发邮箱激活
	            	modelAndView.addObject("message","注册成功");
	 	            modelAndView.setViewName("register/register_success");
	            }else{
	            	modelAndView.addObject("message","注册失败");
	 	            modelAndView.setViewName("register/register_fail");
	            }
	        } 
		 else if("activate".equals(action)) {
	            //激活
	            String email = request.getParameter("email");//获取email
	            String validateCode = request.getParameter("validateCode");//激活码

	            try {
	               String msg =   memberInfoService.processActivate(email , validateCode);//调用激活方法
	               log.info("邮件验证信息"+msg);
	                 modelAndView.addObject("message",msg);
	                modelAndView.setViewName("register/activate_success");
	            } catch (Exception e) {
	                request.setAttribute("message" , e.getMessage());
	                modelAndView.setViewName("register/activate_failure");
	            }
	        }
		return modelAndView;
	}
}
