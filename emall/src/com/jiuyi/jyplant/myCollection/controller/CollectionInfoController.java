package com.jiuyi.jyplant.myCollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.myCollection.service.CollectionInfoService;
import com.jiuyi.jyplant.utils.PageResults;

/***
 * 我的收藏管理
 * 
 * @author baizilin
 * 
 */
@Controller
@RequestMapping("/collect/mng/")
public class CollectionInfoController {

	@Autowired
	private CollectionInfoService collectionInfoService;
	
	/**
	 * 进收藏管理查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query() {
		return "/pages/collect/c_list";
	}
	
	/**
	 * 分页查询邮件信息
	 * @param collectionInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="ajaxQuery")
	@ResponseBody
	public PageResults<CollectionInfo>  ajaxQuery( @ModelAttribute("collectionInfo") CollectionInfo collectionInfo,Integer page , Integer rows){
		PageResults<CollectionInfo> pageResults = null;
		if(null==page){
			pageResults = new PageResults<CollectionInfo>(1  ,10);
		}else{
			pageResults = new PageResults<CollectionInfo>(page , rows);
		}
		pageResults = collectionInfoService.queryPageCollectionInfo(collectionInfo ,pageResults);
		return pageResults;
	}


}
