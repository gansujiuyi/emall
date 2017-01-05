package com.jiuyi.jyplant.order.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.order.dao.AddressInfoDAO;
import com.jiuyi.jyplant.order.entity.AddressInfo;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("AddressInfoDAO")
public class AddressInfoDAOImpl extends BaseDao<AddressInfo, String> implements AddressInfoDAO{
	/**
	 * 查询地址信息
	 */
	@Override
	public List<AddressInfo> queryAddressInfo(String memberId, String addressId) {
		if(null != memberId && !"".equals(memberId)){
			String hql = "from AddressInfo a where 1=1 and a.memberId='" + memberId + "'";
					
			return getListByHQL(hql);
		}
		if(null != addressId && !"".equals(addressId)){
			String hql = "from AddressInfo a where 1=1 and a.memberId='" + memberId + "'";
			return getListByHQL(hql);
		}
		return null;
	}
	/**
	 * 保存地址信息
	 */
	@Override
	public boolean saveAddressInfo(AddressInfo addressInfo) {
		try {
			if(null != addressInfo && !"".equals(addressInfo)){
				save(addressInfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 根据id删除地址信息
	 */
	@Override
	public boolean delAddressInfo(AddressInfo addressInfo) {
		try {
			if(null!=addressInfo.getMemberId() && !"".equals(addressInfo.getMemberId()) &&  
					null != addressInfo.getAddressId() && !"".equals(addressInfo.getAddressId())){
				delete(addressInfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 修改地址信息
	 */
	@Override
	public boolean updateAddressInfo(AddressInfo addressInfo) {
		try {
			if(null!=addressInfo && !"".equals(addressInfo)){
				update(addressInfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 
	 */
	@Override
	public boolean checkAddressInfo(AddressInfo addressInfo) {
		String hql_1 = "from AddressInfo a where "
					+ "a.purchaseRaddress = '" + addressInfo.getPurchaseRaddress() 
					+"'or a.purchaser="+addressInfo.getPurchaser()
					+"'or a.purchaserTel="+addressInfo.getPurchaserTel()+"'";
		Query query_1 = this.getSession().createQuery(hql_1);
		if (query_1.list().size() > 0) {
			return true;
		}
		return false;
	}
	
}
