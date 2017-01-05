package com.jiuyi.jyplant.seller.dao;

import com.jiuyi.jyplant.seller.entity.Shop;

public interface ShopDAO {

	/**
	 * 保存店铺信息
	 * @param shop
	 * @return
	 */
	public boolean saveShop(Shop shop);
}
