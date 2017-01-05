package com.jiuyi.jyplant.order.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.order.dao.AddressInfoDAO;
import com.jiuyi.jyplant.order.entity.AddressInfo;
import com.jiuyi.jyplant.order.service.AddressInfoService;
@Service("addressInfoService")
@Transactional
public class AddressInfoServiceImpl implements AddressInfoService {
	
	@Autowired
	private AddressInfoDAO addressInfoDAO;

	/**
	 * 查询地址信息
	 */
	@Override
	public List<AddressInfo> queryAddressInfo(String memberId, String addressId) {
		return addressInfoDAO.queryAddressInfo(memberId,addressId);
	}
	/**
	 * 保存地址信息
	 */
	@Override
	public boolean saveAddressInfo(AddressInfo addressInfo) {
		return addressInfoDAO.saveAddressInfo(addressInfo);
	}
	/**
	 * 根据id删除地址信息
	 */
	@Override
	public boolean delAddressInfo(AddressInfo addressInfo) {
		return addressInfoDAO.delAddressInfo(addressInfo);
	}
	/**
	 * 修改地址信息
	 */
	@Override
	public boolean updateAddressInfo(AddressInfo addressInfo) {
		return addressInfoDAO.updateAddressInfo(addressInfo);
	}
	/**
	 * 校验地址信息
	 */
	@Override
	public boolean checkAddressInfo(AddressInfo addressInfo) {
		return addressInfoDAO.checkAddressInfo(addressInfo);
	}

}
