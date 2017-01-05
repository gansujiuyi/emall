package com.jiuyi.jyplant.seller.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.seller.dao.OrgCodeDAO;
import com.jiuyi.jyplant.seller.entity.OrgCode;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("OrgCodeDAO")
public class OrgCodeDAOImpl extends BaseDao<OrgCode, String> implements OrgCodeDAO {

	@Override
	public boolean saveOrgCode(OrgCode OrgCode) {
		try{
			if(null != OrgCode && !"".equals(OrgCode)){
				save(OrgCode);
				return true;
			}
			return false ;
		}catch(Exception e){
			return false ;
		}
	}

}
