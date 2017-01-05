package com.jiuyi.jyplant.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.order.service.OrderInfoService;
import com.jiuyi.jyplant.utils.PageResults;

@Controller
@RequestMapping(value="/order/mng")
public class OrderController {
	
	private static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	@Autowired
	private OrderInfoService orderInfoService;
	/**
	 * 分页查询进入
	 * @return
	 */
	@RequestMapping("/query")
	public String query() {
		LOGGER.info("开始进入订单查询页面......");
		return "/pages/order/orderList";
	}
	
	@RequestMapping("/ajaxQuery")
	@ResponseBody
	public PageResults<OrderInfo> ajaxQuery(HttpServletRequest request,
			@ModelAttribute("orderInfo") OrderInfo orderInfo, Integer page, Integer rows) {
		PageResults<OrderInfo> pageResults = null;
		if (null == page) {
			pageResults = new PageResults<OrderInfo>(1, 10);
		} else {
			pageResults = new PageResults<OrderInfo>(page, rows);
		}
		pageResults = orderInfoService.queryPageOrderInfo(orderInfo, pageResults);
		return pageResults;
	}
	
	
	
	

}
