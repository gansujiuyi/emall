package com.jiuyi.jyplant.seller.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.seller.dao.ShopDAO;
import com.jiuyi.jyplant.seller.entity.Shop;
import com.jiuyi.jyplant.seller.service.ShopService;
@Service("shopService")
@Transactional
public class ShopServiceIMpl implements ShopService {

	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public boolean saveShop(Shop shop) {
		return shopDAO.saveShop(shop);
	}

}
