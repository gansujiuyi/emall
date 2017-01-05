package com.jiuyi.jyplant.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.ResourcesService;

/**
 * 登录认证的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private ResourcesService resourcesService ;
	
	private List<String> excludeUrls;// 不需要拦截的资源
	
	private List<String> excludeLoginSuccUrls;// 登录后不需要拦截的资源
	
	

	public List<String> getExcludeLoginSuccUrls() {
		return excludeLoginSuccUrls;
	}

	public void setExcludeLoginSuccUrls(List<String> excludeLoginSuccUrls) {
		this.excludeLoginSuccUrls = excludeLoginSuccUrls;
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * Handler执行完成之后调用这个方法
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		excludeUrls = new ArrayList<String>();
		excludeUrls.add(request.getContextPath()+"/index/index.htmls");
		excludeUrls.add(request.getContextPath()+"/background/checkSession.htmls");
		excludeUrls.add(request.getContextPath()+"/background/loginCheck.htmls");
		excludeUrls.add(request.getContextPath()+"/background/checkSession.htmls");
		excludeUrls.add(request.getContextPath()+"/background/logout.htmls");
		excludeUrls.add(request.getContextPath()+"/memberInfo/member/memberOpt.htmls");
		
		
		excludeLoginSuccUrls = new ArrayList<String>();
		excludeLoginSuccUrls.add(request.getContextPath()+"/background/index.htmls");
		excludeLoginSuccUrls.add(request.getContextPath()+"/background/user/upUserPassword.htmls");
		
		
		// 获取Session
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		if (null != user) {
			//判断请求是否为Ajax
			String requestType = request.getHeader("X-Requested-With");  
			
			
			//获取当前登录用户的权限
			List<Resources> resources = resourcesService.getUserResources(String.valueOf(user.getUserId()));
			String requestUrl =request.getRequestURI();
			if(requestUrl.indexOf("?")>-1){
				requestUrl=requestUrl.substring(0,requestUrl.indexOf("?"));
			}
			if(excludeLoginSuccUrls.contains(requestUrl)){
				return true;
			}
			for (Resources res : resources) {
				if ((request.getContextPath()+res.getResUrl()).equals(requestUrl)) {  
					return true;
	            }
			}
			
			if(null ==requestType){
				request.setAttribute("message", "您没有访问此资源的权限！<br/>请联系超管赋予您!<br/>");
				request.getRequestDispatcher("/syscontrol/login.jsp").forward(request,response);;  
				return false;
			}else{
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("您没有访问此资源的权限！<br/>请联系超管赋予您!<br/>");
				response.sendError(403); 
				return false;
			}
			
		}
		// 不符合条件的，跳转到登录界面
		request.getRequestDispatcher("/syscontrol/login.jsp").forward(request,response);
		return false;
	}

}
