package com.jiuyi.jyplant.seller.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.seller.dao.ShopDAO;
import com.jiuyi.jyplant.seller.entity.Shop;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("ShopDAO")
public class ShopDAOImpl extends BaseDao<Shop, String> implements ShopDAO {

	@Override
	public boolean saveShop(Shop shop) {
		try{
			if(null != shop && !"".equals(shop)){
				save(shop);
				return true;
			}
			return false ;
		}catch(Exception e){
			return false ;
		}
	}

}
