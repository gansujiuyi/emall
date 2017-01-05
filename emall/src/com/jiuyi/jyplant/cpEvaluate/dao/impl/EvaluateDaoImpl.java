package com.jiuyi.jyplant.cpEvaluate.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.cpEvaluate.dao.EvaluateDao;
import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("evaluateDao")
public class EvaluateDaoImpl extends BaseDao<EvaluateInfo, String> implements
		EvaluateDao {

	@Override
	@SuppressWarnings("rawtypes")
	public PageResults<EvaluateInfo> queryPageEvaluateInfo(
			EvaluateInfo evaluateInfo, PageResults<EvaluateInfo> pageResults) {
		List<EvaluateInfo> evaluateInfos = new ArrayList<EvaluateInfo>();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.ENGLISH);
			String coon = "";
			String sql = " select a.evalId ,a.evalContent , a.evalTime, b.memberName as  evalPersonId, "
					+ " c.t_productName as evalProducdId,a.evalScore from t_evaluate a "
					+ " left join t_member b on a.evalPersonId  = b.memberId "
					+ " left join t_product c on a.evalProducdId = c.t_productId where 1=1 "
					+ coon;
			String countHql = "select count(1) from t_evaluate a left join t_member b on a.evalPersonId  = b.memberId "
					+ " left join t_product c on a.evalProducdId = c.t_productId where 1=1  "
					+ coon;
			PageResults<EvaluateInfo> results = findPageByFetchedSql(sql,
					countHql, pageResults.getPageNo(),
					pageResults.getPageSize());
			List temp = results.getRows();
			for (int i = 0; i < temp.size(); i++) {
				EvaluateInfo tempObject = new EvaluateInfo();
				Object[] obj = (Object[]) temp.get(i);
				tempObject.setEvalId(obj[0] + "");
				tempObject.setEvalContent(obj[1] + "");
				tempObject.setEvalTime(dateFormat.parse(obj[2] + ""));
				tempObject.setEvalPersonId(obj[3] + "");
				tempObject.setEvalProducdId(obj[4] + "");
				tempObject.setEvalScore(obj[5] + "");
				evaluateInfos.add(tempObject);
			}
			results.setRows(evaluateInfos);
			return results;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public boolean saveEvaluateInfo(EvaluateInfo evaluateInfo) {
		try {
			if(null != evaluateInfo && !"".equals(evaluateInfo)){
				save(evaluateInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteEvaluateInfo(EvaluateInfo evaluateInfo) {
		try {
			if(null != evaluateInfo && !"".equals(evaluateInfo)){
				delete(evaluateInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEvaluateInfo(EvaluateInfo evaluateInfo) {
		try {
			if(null != evaluateInfo && !"".equals(evaluateInfo)){
				update(evaluateInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<EvaluateInfo> queryEvaluateInfo(String evalPersonId,String evalProducdId) {
		if(null == evalProducdId && "".equals(evalProducdId)){
			String hql = "from EvaluateInfo where evalPersonId='"+evalPersonId+"'";
			return getListByHQL(hql);
			
		}
		String hql = "from EvaluateInfo where evalPersonId='"+evalPersonId+"' and evalProducdId='" +evalProducdId+"'";
		return getListByHQL(hql);
		
	}
	
	
	
	
	
}