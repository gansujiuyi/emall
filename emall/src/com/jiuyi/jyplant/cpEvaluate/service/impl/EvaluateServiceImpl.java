package com.jiuyi.jyplant.cpEvaluate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.cpEvaluate.dao.EvaluateDao;
import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.cpEvaluate.service.EvaluateService;
import com.jiuyi.jyplant.utils.PageResults;


@Service("evaluateService")
@Transactional
public class EvaluateServiceImpl implements EvaluateService {
	
	@Autowired
	private EvaluateDao evaluateDao;

	@Override
	public PageResults<EvaluateInfo> queryPageEvaluateInfo(
			EvaluateInfo evaluateInfo, PageResults<EvaluateInfo> pageResults) {
		return evaluateDao.queryPageEvaluateInfo(evaluateInfo, pageResults);
	}

	@Override
	public boolean saveEvaluateInfo(EvaluateInfo evaluateInfo) {
		return evaluateDao.saveEvaluateInfo(evaluateInfo);
	}

	@Override
	public boolean deleteEvaluateInfo(EvaluateInfo evaluateInfo) {
		return evaluateDao.deleteEvaluateInfo(evaluateInfo);
	}

	@Override
	public boolean updateEvaluateInfo(EvaluateInfo evaluateInfo) {
		return evaluateDao.updateEvaluateInfo(evaluateInfo);
	}

	@Override
	public List<EvaluateInfo> queryEvaluateInfo(String evalPersonId,String evalProducdId) {
		return evaluateDao.queryEvaluateInfo(evalPersonId,evalProducdId);
	}
	
	

}
