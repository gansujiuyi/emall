package com.jiuyi.jyplant.order.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.order.dao.ExpressInfoDAO;
import com.jiuyi.jyplant.order.service.ExpressInfoService;
@Service("expressInfoService")
@Transactional
public class ExpressInfoSerciceImpl implements ExpressInfoService {
	@Autowired
	private ExpressInfoDAO expressInfoDAO;
	
	
	
	
}
