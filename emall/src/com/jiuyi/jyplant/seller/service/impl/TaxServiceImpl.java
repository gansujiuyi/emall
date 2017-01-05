package com.jiuyi.jyplant.seller.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.seller.dao.TaxDAO;
import com.jiuyi.jyplant.seller.entity.Tax;
import com.jiuyi.jyplant.seller.service.TaxService;
@Service("taxServiceImpl")
@Transactional
public class TaxServiceImpl  implements  TaxService{
	
	@Autowired
	private TaxDAO taxDAO;

	@Override
	public boolean saveTax(Tax tax) {
		return taxDAO.saveTax(tax);
	}

}
