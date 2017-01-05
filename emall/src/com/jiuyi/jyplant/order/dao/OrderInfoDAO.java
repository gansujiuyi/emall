package com.jiuyi.jyplant.order.dao;

import java.util.List;

import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface OrderInfoDAO {
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
	
	public boolean delOrderInfo(OrderInfo orderInfo);
	
	public boolean saveOrderInfo(OrderInfo orderInfo);
	
	public boolean updateOrderInfo(OrderInfo orderInfo);

}
