package com.jiuyi.jyplant.order.service;

import java.util.List;

import com.jiuyi.jyplant.order.entity.AddressInfo;

public interface AddressInfoService {
	/**
	 * 查询地址信息
	 * @param addressId
	 * @param memberId
	 * @return
	 */
	public List<AddressInfo> queryAddressInfo(String memberId,String addressId);
	/**
	 * 保存地址信息
	 * @param addressInfo
	 * @return
	 */
	public boolean saveAddressInfo(AddressInfo addressInfo);
	/**
	 * 根据id删除地址信息
	 * @param memberId
	 * @param addressId
	 * @return
	 */
	public boolean delAddressInfo(AddressInfo addressInfo);
	/**
	 * 修改地址信息
	 * @param addressInfo
	 * @return
	 */
	public boolean updateAddressInfo(AddressInfo addressInfo);
	/**
	 * 校验地址信息
	 * @param addressInfo
	 * @return
	 */
	public boolean checkAddressInfo(AddressInfo addressInfo);
	
	
	
	
}
