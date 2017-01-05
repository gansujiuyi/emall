package com.jiuyi.jyplant.seller.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.seller.dao.TaxDAO;
import com.jiuyi.jyplant.seller.entity.Tax;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("TaxDAO")
public class TaxDAOImpl extends BaseDao<Tax, String> implements TaxDAO {

	@Override
	public boolean saveTax(Tax tax) {
		try{
			if(null != tax && !"".equals(tax)){
				save(tax);
				return true;
			}
			return false ;
		}catch(Exception e){
			return false ;
		}
	}

}
