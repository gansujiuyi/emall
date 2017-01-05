package com.jiuyi.jyplant.emaill.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.emaill.service.EmaillInfoService;
import com.jiuyi.jyplant.utils.PageResults;


/**
 * 邮件管理
 * 
 * @author baizilin
 * @version 1.0v
 */
@Controller
@RequestMapping("/emaill/mng/")
public class EmaillController {
	
	
	Logger log = Logger.getLogger(EmaillController.class);
	
	@Autowired
	private EmaillInfoService emaillInfoService;
	
	/**
	 * 进入邮件查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query() {
		return "/pages/emaillInfo/e_list";
	}
	
	

	/**
	 * 分页查询邮件信息
	 * @param memberInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="ajaxQuery")
	@ResponseBody
	public PageResults<EmaillInfo>  ajaxQuery( @ModelAttribute("emaillInfo") EmaillInfo emaillInfo,Integer page , Integer rows){
		PageResults<EmaillInfo> pageResults = null;
		if(null==page){
			pageResults = new PageResults<EmaillInfo>(1  ,10);
		}else{
			pageResults = new PageResults<EmaillInfo>(page , rows);
		}
		pageResults = emaillInfoService.queryPageEmaillInfo(emaillInfo ,pageResults);
		return pageResults;
	}

}
