package com.jiuyi.jyplant.seller.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.seller.dao.OrgCodeDAO;
import com.jiuyi.jyplant.seller.entity.OrgCode;
import com.jiuyi.jyplant.seller.service.OrgCodeService;
@Service("orgCodeService")
@Transactional
public class OrgCodeServiceImpl implements OrgCodeService {

	@Autowired
	private OrgCodeDAO orgCodeDAO;
	@Override
	public boolean saveOrgCode(OrgCode orgCode) {
		return orgCodeDAO.saveOrgCode(orgCode);
	}

}
