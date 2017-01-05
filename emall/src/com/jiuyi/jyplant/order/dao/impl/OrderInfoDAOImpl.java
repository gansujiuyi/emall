package com.jiuyi.jyplant.order.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.order.dao.OrderInfoDAO;
import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("OrderInfoDAO")
public class OrderInfoDAOImpl extends BaseDao<OrderInfo, String> implements OrderInfoDAO {
	/**
	 * 分页查询订单信息
	 */
	@Override
	public PageResults<OrderInfo> queryPageOrderInfo(OrderInfo orderInfo, PageResults<OrderInfo> pageResults) {
		String con = "";
		if (null != orderInfo) {
			if (null != orderInfo.getOrderNum() && !"".equals(orderInfo.getOrderNum())) {
				con += " and s.orderNum like '%" + orderInfo.getOrderNum().trim() + "%'";
			}
		}
		String hql = "from OrderInfo s where 1=1 " + con;
		String countHql = "select count(*) from OrderInfo s where 1=1 " + con;
		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),
				pageResults.getPageSize());
	}
	/**
	 * 根据会员id查询订单信息
	 */
	@Override
	public List<OrderInfo> queryByMemberId(String memberId,String orderStatus) {
		if(null != memberId && !"".equals(memberId)){
			String hql = "from OrderInfo s where 1=1 and s.memberId='"+memberId+"'";
			List<OrderInfo> orderInfos=getListByHQL(hql);
			return orderInfos;
		}
		if(null != orderStatus && !"".equals(orderStatus)){
			String hql = "from OrderInfo s where 1=1 and s.memberId='"+memberId+"' and orderStatus='"+orderStatus+"'";
			List<OrderInfo> orderInfos=getListByHQL(hql);
			return orderInfos;
		}
		return null;
	}
	/**
	 * 删除订单
	 */
	@Override
	public boolean delOrderInfo(OrderInfo orderInfo) {
		try {
			delete(orderInfo);
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	/**
	 * 保存订单
	 */
	@Override
	public boolean saveOrderInfo(OrderInfo orderInfo) {
		try {
			save(orderInfo);
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	/**
	 * 修改订单
	 */
	@Override
	public boolean updateOrderInfo(OrderInfo orderInfo) {
		try {
			update(orderInfo);
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	
	
	
	
	
	
	
	
}
