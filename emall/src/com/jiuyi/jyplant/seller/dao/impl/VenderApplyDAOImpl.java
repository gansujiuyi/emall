package com.jiuyi.jyplant.seller.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.seller.dao.VenderApplyDAO;
import com.jiuyi.jyplant.seller.entity.VenderApply;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("VenderApplyDAO")
public class VenderApplyDAOImpl extends BaseDao<VenderApply, String> implements VenderApplyDAO {
	/**
	 * 保存商户信息
	 */
	@Override
	public VenderApply saveVenderApply(VenderApply venderApply) {
		VenderApply temp = new VenderApply();
		this.getSession().save(venderApply);
		temp = this.get(venderApply.getVenderId());
		return temp;

	}
	/**
	 * 修改商户信息
	 */
	@Override
	public VenderApply updateVenderApply(VenderApply venderApply) {
		VenderApply temp = new VenderApply();
		update(venderApply);
		temp = get(venderApply.getVenderId());
		return temp;
	}
	

}
