package com.jiuyi.jyplant.cpEvaluate.dao;

import java.util.List;

import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface EvaluateDao extends IBaseDao<EvaluateInfo, String> {
	
	public PageResults<EvaluateInfo> queryPageEvaluateInfo(EvaluateInfo evaluateInfo,
			PageResults<EvaluateInfo> pageResults);

	public boolean saveEvaluateInfo(EvaluateInfo evaluateInfo);

	public boolean deleteEvaluateInfo(EvaluateInfo evaluateInfo);

	public boolean updateEvaluateInfo(EvaluateInfo evaluateInfo);

	public List<EvaluateInfo> queryEvaluateInfo(String evalPersonId,String evalProducdId);
	
}
