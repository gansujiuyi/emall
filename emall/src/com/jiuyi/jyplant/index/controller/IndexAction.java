package com.jiuyi.jyplant.index.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "index")
public class IndexAction {

	private static final Logger logger = Logger.getLogger(IndexAction.class);


	@RequestMapping(value = "/index")
	public String queryInfo() {
		logger.info("首页查询信息...");
		return "/index/index";
	}

	 
}
