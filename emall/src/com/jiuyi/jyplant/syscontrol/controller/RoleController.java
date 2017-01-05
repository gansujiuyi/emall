package com.jiuyi.jyplant.syscontrol.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.syscontrol.entity.Roles;
import com.jiuyi.jyplant.syscontrol.service.RoleService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

@Controller
@RequestMapping(value = "/background/role/")
public class RoleController {

	private static final Logger LOGGER = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	/**
	 * 进入查询页面
	 * 
	 * @return
	 */
	@RequestMapping("/query")
	public String query() {
		LOGGER.info("开始进入角色查询页面......");
		return "/syscontrol/role/list";
	}

	/**
	 * 分页查询角色列表数据
	 * @param request
	 * @param roles
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/ajaxQuery")
	@ResponseBody
	public PageResults<Roles> ajaxQuery(HttpServletRequest request,
			@ModelAttribute("roles") Roles roles, Integer page, Integer rows) {
		PageResults<Roles> pageResults = null;
		if (null == page) {
			pageResults = new PageResults<Roles>(1, 10);
		} else {
			pageResults = new PageResults<Roles>(page, rows);
		}
		pageResults = roleService.queryPageRoles(roles, pageResults);
		return pageResults;
	}

	/***
	 * 保存角色信息
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/saveRole")
	@ResponseBody
	public String saveRole(@ModelAttribute("roles") Roles roles) {
         if("".equals(roles.getId())){
        	 roles.setEnable("0");
        	 roles.setId(null);
         }
		roleService.saveRole(roles);
		return "true";
	}
	/**
	 * 重复项校验
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/chechInfo")
	@ResponseBody
	public String chechInfo(@ModelAttribute("roles") Roles roles) {
		if(roleService.chechInfo(roles)){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 根据角色ID查找角色
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/queryRoleById")
	@ResponseBody
	public Roles queryRoleById(@ModelAttribute("roles") Roles roles) {
		Roles temp = roleService.queryRoleById(roles);
		return temp;
	}
	
	/**
	 * 删除角色
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/deleteRole")
	@ResponseBody
	public String deleteRole(String roleIds) {
		if(roleService.deleteRole(roleIds)){
			return "true";
		}
		return "false"; 
	}
	
	/**
	 * 启|禁用角色
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/restRole")
	@ResponseBody
	public String restRole(String roleIds ,String enable) {
		if(roleService.restRole(roleIds ,enable)){
			return "true";
		}
		return "false"; 
	}
	
	/**
	 * 角色授权(用户、资源)
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/saveUserResourceByRole")
	@ResponseBody
	public String saveUserResourceByRole(HttpServletRequest request,String resourceIds, String roleIds_ ,String userIds) {
		String optType =  request.getParameter("optType");
		if(roleService.saveUserResourceByRole(resourceIds,userIds, roleIds_ , optType)){
			request.getSession().removeAttribute("user");
			return "true";
		}
		return "false"; 
	}
	
	/**
	 * 获取角色树
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/queryRolesTree")
	@ResponseBody
	public List<TreeVo> queryRolesTree(String userId) {
		List<TreeVo> treeVos = roleService.rolesVos(userId);
		return treeVos;
	}
}
