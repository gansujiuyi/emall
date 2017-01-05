package com.jiuyi.jyplant.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.category.service.CategoryInfoService;
import com.jiuyi.jyplant.utils.PageResults;


@Controller
@RequestMapping(value="/category/mng")
public class CategoryInfoController {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryInfoController.class);
	@Autowired
	private CategoryInfoService categoryInfoService;
	/**
	 * 进入商品分类信息
	 * @return
	 */
	@RequestMapping("/query")
	public String query(){
		LOGGER.info("开始进入商品分类信息查询！");
		return "/pages/category/categoryInfoList";
		
	}
	/**
	 * 分页查询商品分类信息
	 * @param request
	 * @param roles
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/ajaxQueryAllCatagory")
	@ResponseBody
	public PageResults<CategoryInfo> ajaxQueryAllCatagory(HttpServletRequest request,
			@ModelAttribute("categoryInfo") CategoryInfo categoryInfo, Integer page, Integer rows) {
		PageResults<CategoryInfo> pageResults = null;
		if (null == page) {
			pageResults = new PageResults<CategoryInfo>(1, 10);
		} else {
			pageResults = new PageResults<CategoryInfo>(page, rows);
		}
		pageResults = categoryInfoService.queryPageCategorys(pageResults, categoryInfo);
		return pageResults;
	}
	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	@RequestMapping(value = "/querAllCategoryInfo")
	@ResponseBody
	public List<CategoryInfo> querAllCategoryInfo(){
		List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
		return categoryInfos;
	}
	/**
	 * 根据id查询商品分类信息
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/queryCategoryInfoById")
	@ResponseBody
	public CategoryInfo queryCategoryInfoById(@ModelAttribute("categoryInfo") CategoryInfo categoryInfo){
		CategoryInfo categroyInfo = categoryInfoService.queryById(categoryInfo);
		return categroyInfo;
	}
	/**
	 * 保存商品分类信息
	 * @param categoryInfo
	 * @return
	 */
	@RequestMapping(value = "/saveCategoryInfo")
	@ResponseBody
	public String saveCategoryInfo(@ModelAttribute("categoryInfo") CategoryInfo categoryInfo) {
		if("".equals(categoryInfo.getT_categoryId())){
			categoryInfo.setT_checkStatus("0");
			if("--请选择--".equals(categoryInfo.getT_categoryType())){
				categoryInfo.setT_categoryType("0");
			}
			categoryInfo.setT_categoryId(null);
        }
		categoryInfoService.saveCategoryInfo(categoryInfo);
		return "true";
	}
	/**
	 * 删除商品分类信息
	 * @param categoryInfo
	 * @return
	 */
	@RequestMapping(value = "/delCategoryInfo")
	@ResponseBody
	public String delCategoryInfo(String categoryId){
		if(categoryInfoService.deleteCategoryInfo(categoryId)){
			return "true";
		}
		return "false"; 
	}
	/**
	 * 校验用户信息是否重复
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/chechInfo")
	@ResponseBody
	public String chechInfo(@ModelAttribute("categoryInfo") CategoryInfo categoryInfo) {
		if(categoryInfoService.chechInfo(categoryInfo)){
			return "true";
		}
		return "false";
	}
	/**
	 * 启|禁用分类信息
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/updateCategoryInfoStatus")
	@ResponseBody
	public String updateCategoryInfoStatus(String t_categoryId ,String t_checkStatus) {
		if(categoryInfoService.updateCategoryInfoStatus(t_categoryId ,t_checkStatus)){
			return "true";
		}
		return "false"; 
	}
	
	
	
	
	
}
