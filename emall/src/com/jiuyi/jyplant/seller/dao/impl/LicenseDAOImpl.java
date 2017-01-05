package com.jiuyi.jyplant.seller.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.seller.dao.LicenseDAO;
import com.jiuyi.jyplant.seller.entity.License;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("LicenseDAO")
public class LicenseDAOImpl extends BaseDao< License, String> implements LicenseDAO{

	@Override
	public boolean saveLicense(License license) {
		try{
			if(null != license && !"".equals(license)){
				save(license);
				return true;
			}
			return false ;
		}catch(Exception e){
			return false ;
		}
	}

	
}
