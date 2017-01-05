package com.jiuyi.jyplant.syscontrol.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.ResourcesService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

@Controller
@RequestMapping(value="/background/resources/")
public class ResourceController {

	private static final Logger LOGGER = Logger.getLogger(ResourceController.class);

	@Autowired
	private ResourcesService resourcesService;


	/**
	 * 根据用户获取资源
	 * 
	 * @param session
	 * @param resources
	 * @return
	 */
	@RequestMapping(value="/queryResourcesInfos")
	@ResponseBody
	public List<Resources> queryResourcesInfos(HttpSession session ,HttpServletRequest request) {
		LOGGER.info("查询资源");
		Users s_user = (Users) session.getAttribute("user");
		List<Resources> userInfos = resourcesService.queryResourceListById(s_user.getUserId(), request.getParameter("parentId"));
		return userInfos;
	}
	
	
	/**
	 * 进入查询页面
	 * @return
	 */
	@RequestMapping("/query")
	public String query(){
		return "/syscontrol/resources/list";
	}
	/**
	 * 分页查询
	 * @param resources
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/ajaxQuery")
	@ResponseBody
	public PageResults<Resources>  ajaxQuery( @ModelAttribute("roles") Resources resources,Integer page , Integer rows){
		PageResults<Resources> pageResults = null;
		if(null==page){
			pageResults = new PageResults<Resources>(1  ,10);
		}else{
			pageResults = new PageResults<Resources>(page , rows);
		}
		pageResults = resourcesService.queryPageResources(resources ,pageResults);
		return pageResults;
	}
	
	
	/**
	 * 根据角色查询资源树
	 * @param resources
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/queryResourcesTree")
	@ResponseBody
	public List<TreeVo> queryResourcesTree(String roleIds , String pid) {
		List<TreeVo> treeVos = resourcesService.resourcesVos(roleIds , pid);
		return treeVos;
	}
	
	/**
	 * 重复项校验
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/chechInfo")
	@ResponseBody
	public String chechInfo(@ModelAttribute("resources") Resources resources) {
		if(resourcesService.chechInfo(resources)){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 删除资源
	 * @param resourceIds
	 * @return
	 */
	@RequestMapping(value = "/deleteResources")
	@ResponseBody
	public String deleteResources(String resourceIds) {
		if(resourcesService.deleteResources(resourceIds)){
			return "true";
		}
		return "false"; 
	}
	
	/***
	 * 保存数据
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/saveResources")
	@ResponseBody
	public String saveResources(@ModelAttribute("resources") Resources resources) {
         if("".equals(resources.getId())){
        	 resources.setId(null);
        	 resources.setLevel("1");
        	 resources.setType("1");
        	 if(null==resources.getParentId() || "".equals(resources.getParentId())){
        		 resources.setParentId("1010");
        		 resources.setParentName("根目录");
        	 }
         }
         resourcesService.saveResources(resources);
		return "true";
	}
	
}
