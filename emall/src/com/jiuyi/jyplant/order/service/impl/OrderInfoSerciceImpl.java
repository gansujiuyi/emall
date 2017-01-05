package com.jiuyi.jyplant.order.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.order.dao.ExpressInfoDAO;
import com.jiuyi.jyplant.order.dao.OrderInfoDAO;
import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.order.service.OrderInfoService;
import com.jiuyi.jyplant.utils.PageResults;
@Service("orderInfoService")
@Transactional
public class OrderInfoSerciceImpl implements OrderInfoService{
	@Autowired
	private ExpressInfoDAO expressInfoDAO;
	
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	/**
	 * 分页查询订单信息
	 */
	@Override
	public PageResults<OrderInfo> queryPageOrderInfo(OrderInfo orderInfo, PageResults<OrderInfo> pageResults) {
		return orderInfoDAO.queryPageOrderInfo(orderInfo, pageResults);
	}
	/**
	 * 根据会员id查询订单信息
	 */
	@Override
	public List<OrderInfo> queryByMemberId(String memberId,String orderStatus) {
		return orderInfoDAO.queryByMemberId(memberId,orderStatus);
	}
	@Override
	public boolean saveOrderInfo(OrderInfo orderInfo) {
		return orderInfoDAO.saveOrderInfo(orderInfo);
	}
	@Override
	public boolean delOrderInfo(OrderInfo orderInfo) {
		return orderInfoDAO.delOrderInfo(orderInfo);
	}
	@Override
	public boolean updateOrderInfo(OrderInfo orderInfo) {
		return orderInfoDAO.updateOrderInfo(orderInfo);
	}
}
