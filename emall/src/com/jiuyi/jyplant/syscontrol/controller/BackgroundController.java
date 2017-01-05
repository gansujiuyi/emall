package com.jiuyi.jyplant.syscontrol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.ResourcesService;
import com.jiuyi.jyplant.syscontrol.service.UserService;
import com.jiuyi.jyplant.utils.MD5;

/**
 * 进行管理后台框架界面的类
 * 
 * @author baizilin
 * @version 1.0v
 */
@Controller
@RequestMapping("/background")
public class BackgroundController {

	Logger log = Logger.getLogger(BackgroundController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private ResourcesService resourcesService;

	/**
	 * 登录检查
	 * @return
	 */
	@RequestMapping(value = "/loginCheck")
	public String loginCheck(HttpServletRequest request, HttpSession session) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("message", "支持POST方法提交！");
			}
			if (null == username || null == password || "".equals(username)
					|| "".equals(password)) {
				log.info("用户名或密码为空.....");
				request.setAttribute("message", "用户名或密码不能为空！");
				return "/syscontrol/login";
			}
			// 验证用户账号与密码是否正确
			password = MD5.HPEncode(password, "GBK");
			Users users = this.userService.querySingleUser(username);
			if (users == null || !users.getUserPassword().equals(password)) {
				log.info("用户或密码不正确.....");
				request.setAttribute("message", "用户或密码不正确！");
				return "/syscontrol/login";
			}
			if ("0".equals(users.getUstatus())) {
				request.setAttribute("message", "账户已锁定,请联系管理员解锁！");
				log.info("获取的用户信息已锁定.....");
				return "/syscontrol/login";
			}
			// 当验证都通过后，把用户信息放在session里
			session.setAttribute("user", users);
		} catch (AuthenticationException ae) {
			request.setAttribute("message", "登录异常，请联系管理员！");
			return "/syscontrol/login";
		}
		return "redirect:index.htmls";
	}
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value = "/Initlogin")
	public String Initlogin(HttpServletRequest request, HttpSession session,
			String username, String password) {
		return "/syscontrol/login";
	}

	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpSession session,
			String username, String password) {
		// //重新登录时销毁该用户的Session
		Object o = request.getSession().getAttribute("user");
		if (null != o) {
			request.getSession().removeAttribute("user");
		}
		return "redirect:loginCheck.htmls";
	}

	/**
	 * session检查
	 * @return
	 */
	@RequestMapping(value = "/checkSession")
	@ResponseBody
	public String checkSession(HttpServletRequest request) {
		// //重新登录时销毁该用户的Session
		Object o = request.getSession().getAttribute("user");
		if (null != o) {
			return "true";
		}
		return "false";
	}

	/**
	 * 退出系统
	 * 
	 * @param session
	 *            Session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除Session
		session.invalidate();

		return "redirect:index.htmls";
	}

	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping(value ="/index")
	public String index(Model model, HttpSession session) {
		Users s_user = (Users) session.getAttribute("user");
		if (null != s_user) {
			// 获取当前用户的所有资源树
			List<Resources> modules = null;
			List<Resources> menus = resourcesService.queryResourceListById(
					s_user.getUserId(), "1010");
			if (menus.size() > 0) {
				modules = new ArrayList<Resources>();
				for (int i = 0; i < menus.size(); i++) {
					Resources temp = menus.get(i);
					List<Resources> tempModules = resourcesService
							.queryResourceListById(s_user.getUserId(),
									temp.getId());
					if (tempModules.size() > 0) {
						modules.addAll(tempModules);
					}
				}
			}
			model.addAttribute("menus", menus);
			model.addAttribute("modules", modules);
			return "/syscontrol/main";
		} else {
			return "/syscontrol/login";
		}
	}
}