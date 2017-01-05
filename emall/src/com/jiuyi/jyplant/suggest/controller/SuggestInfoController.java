package com.jiuyi.jyplant.suggest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.suggest.service.SuggestInfoService;
import com.jiuyi.jyplant.utils.PageResults;

/***
 * 我的建议
 * 
 * @author baizilin
 * 
 */
@Controller
@RequestMapping("/suggestInfo/mng/")
public class SuggestInfoController {

	@Autowired
	private SuggestInfoService suggestInfoService;
	

	/**
	 * 进我的建议查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query() {
		return "/pages/suggest/su_list";
	}

	
	/**
	 * 分页查询建议信息
	 * @param memberInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="ajaxQuery")
	@ResponseBody
	public PageResults<SuggestInfo>  ajaxQuery( @ModelAttribute("suggestInfo") SuggestInfo suggestInfo,Integer page , Integer rows){
		PageResults<SuggestInfo> pageResults = null;
		if(null==page){
			pageResults = new PageResults<SuggestInfo>(1  ,10);
		}else{
			pageResults = new PageResults<SuggestInfo>(page , rows);
		}
		pageResults = suggestInfoService.queryPageSuggestInfo(suggestInfo ,pageResults);
		return pageResults;
	}
}
