package com.jiuyi.jyplant.syscontrol.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.UserService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

@Controller
@RequestMapping(value = "/background/user/")
public class UsersController {

	private static final Logger LOGGER = Logger
			.getLogger(UsersController.class);

	@Autowired
	private UserService userService;

	/**
	 * 进入查询
	 * 
	 * @param model
	 * @param resources
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value = "/query")
	public String query() {
		LOGGER.info("进入用户列表页面");
		return "/syscontrol/user/list";
	}

	/**
	 * Ajax分页查询
	 * 
	 * @param request
	 * @param users
	 * @param model
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/ajaxQuery")
	@ResponseBody
	public PageResults<Users> ajaxQuery(HttpServletRequest request,
			@ModelAttribute("users") Users users, Model model, Integer page,
			Integer rows) {
		PageResults<Users> pageResults = null;
		if (null == page) {
			pageResults = new PageResults<Users>(1, 10);
		} else {
			pageResults = new PageResults<Users>(page, rows);
		}
		pageResults = userService.queryPageUsers(users, pageResults);
		return pageResults;
	}

	/**
	 * 查询用户树
	 * 
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/queryUserTree")
	@ResponseBody
	public List<TreeVo> queryUserTree(String roleIds) {
		List<TreeVo> treeVos = userService.userVos(roleIds);
		return treeVos;
	}

	/**
	 * 启|停用户状态
	 * 
	 * @param userIds
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/restUserStatus")
	@ResponseBody
	public String restUserStatus(String userIds, String status) {
		if (userService.updateUserStatus(userIds, status)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 修改密码
	 * 
	 * @param userIds
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/upUserPassword")
	@ResponseBody
	public String upUserPassword(HttpServletRequest request,String userIds, String oldPwd, String newPwd) {
		try {
			request.getSession().removeAttribute("user");
		return 	userService.upUserPassword(userIds, oldPwd, newPwd);
			
		} catch (Exception e) {
			return "2"; 
		}
	}
}
