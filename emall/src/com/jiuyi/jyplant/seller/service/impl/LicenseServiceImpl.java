package com.jiuyi.jyplant.seller.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.seller.dao.LicenseDAO;
import com.jiuyi.jyplant.seller.entity.License;
import com.jiuyi.jyplant.seller.service.LicenseService;
@Service("licenseService")
@Transactional
public class LicenseServiceImpl implements LicenseService {
	
	@Autowired
	private LicenseDAO licenseDAO;
	
	@Override
	public boolean saveLicense(License license) {
		return licenseDAO.saveLicense(license);
	}

}
