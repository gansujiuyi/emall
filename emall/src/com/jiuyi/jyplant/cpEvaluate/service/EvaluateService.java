package com.jiuyi.jyplant.cpEvaluate.service;

import java.util.List;

import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface EvaluateService {
	
	public PageResults<EvaluateInfo> queryPageEvaluateInfo(EvaluateInfo evaluateInfo,
			PageResults<EvaluateInfo> pageResults);
	/**
	 * 查询评价
	 * @return
	 */
	public List<EvaluateInfo> queryEvaluateInfo(String evalPersonId,String evalProducdId);
	/**
	 * 保存评价
	 * @param evaluateInfo
	 * @return
	 */
	public boolean saveEvaluateInfo(EvaluateInfo evaluateInfo);
		
	/**
	 * 取消评价
	 * @param evaluateInfo
	 * @return
	 */
	public boolean deleteEvaluateInfo(EvaluateInfo evaluateInfo);
	/**
	 * 修改评价
	 * @param evaluateInfo
	 * @return
	 */
	public boolean updateEvaluateInfo(EvaluateInfo evaluateInfo);
	
}
