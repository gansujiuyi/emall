package com.jiuyi.jyplant.emaill.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.emaill.dao.EmaillInfoDao;
import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.emaill.service.EmaillInfoService;
import com.jiuyi.jyplant.utils.PageResults;


@Service("emaillService")
@Transactional
public class EmaillInfoServiceImpl implements EmaillInfoService {

	@Autowired
	private EmaillInfoDao emaillInfoDao;
	
	@Override
	public PageResults<EmaillInfo> queryPageEmaillInfo(EmaillInfo emaillInfo,
			PageResults<EmaillInfo> pageResults) {
		return emaillInfoDao.queryPageEmaillInfo(emaillInfo, pageResults);
	}
	
	@Override
	public boolean saveEmaillInfo(EmaillInfo emaillInfo) {
		return emaillInfoDao.saveEmaillInfo(emaillInfo);
	}

	@Override
	public EmaillInfo queryEmaillCode(String toWhere) {
		return emaillInfoDao.queryEmaillCode(toWhere);
	}

	@Override
	public boolean updateEmail(EmaillInfo emaillInfo) {
		return emaillInfoDao.updateEmail(emaillInfo);
	}
	
	

}
