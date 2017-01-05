package com.jiuyi.jyplant.cpEvaluate.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.cpEvaluate.service.EvaluateService;
import com.jiuyi.jyplant.utils.PageResults;


/***
 * 评价管理
 * @author baizilin
 *
 */

@Controller
@RequestMapping("/cpevaluate/mng/")
public class EvaluateController {
	
	Logger log = Logger.getLogger(EvaluateController.class);
	
	@Autowired
	private EvaluateService evaluateService;
	
	/**
	 * 进评价查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query() {
		return "/pages/cpevaluate/cp_list";
	}

	
	/**
	 * 分页查询评价信息
	 * @param evaluateInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="ajaxQuery")
	@ResponseBody
	public PageResults<EvaluateInfo>  ajaxQuery( @ModelAttribute("evaluateInfo") EvaluateInfo evaluateInfo,Integer page , Integer rows){
		PageResults<EvaluateInfo> pageResults = null;
		if(null==page){
			pageResults = new PageResults<EvaluateInfo>(1  ,10);
		}else{
			pageResults = new PageResults<EvaluateInfo>(page , rows);
		}
		pageResults = evaluateService.queryPageEvaluateInfo(evaluateInfo ,pageResults);
		return pageResults;
	}
}
