package com.jiuyi.jyplant.seller.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.seller.dao.VenderApplyDAO;
import com.jiuyi.jyplant.seller.entity.VenderApply;
import com.jiuyi.jyplant.seller.service.VenderApplyService;

@Service("venderApplyService")
@Transactional
public class VenderApplyServiceImpl implements VenderApplyService{

	@Autowired
	private VenderApplyDAO venderApplyDAO;
	/**
	 * 保存商户信息
	 */
	@Override
	public VenderApply saveVenderApply(VenderApply venderApply) {
		return venderApplyDAO.saveVenderApply(venderApply);
	}
	/**
	 * 更新商户信息
	 */
	@Override
	public VenderApply updateVenderApply(VenderApply venderApply) {
		return venderApplyDAO.updateVenderApply(venderApply);
	}
	
	
	
	
	
	
	
	
}
