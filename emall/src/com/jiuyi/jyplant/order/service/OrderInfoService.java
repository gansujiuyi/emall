package com.jiuyi.jyplant.order.service;

import java.util.List;

import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface OrderInfoService {
	/**
	 * 分页查询订单信息
	 * @param orderInfo
	 * @param pageResults
	 * @return
	 */
	public PageResults<OrderInfo> queryPageOrderInfo(OrderInfo orderInfo, PageResults<OrderInfo> pageResults);
	/**
	 * 根据会员id查询订单信息
	 * @param memberId
	 * @return
	 */
	public List<OrderInfo> queryByMemberId(String memberId,String orderStatus);
	/**
	 * 保存订单信息
	 * @param orderInfo
	 * @return
	 */
	public boolean saveOrderInfo(OrderInfo orderInfo);
	/**
	 * 删除订单
	 * @param orderInfo
	 * @return
	 */
	public boolean delOrderInfo(OrderInfo orderInfo);
	/**
	 * 修改订单
	 * @param orderInfo
	 * @return
	 */
	public boolean updateOrderInfo(OrderInfo orderInfo);
	
	
	
}
