package com.jiuyi.jyplant.suggest.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.suggest.dao.SuggestInfoDao;
import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("suggestInfoDao")
public class SuggestInfoDaoImpl extends BaseDao<SuggestInfo, String> implements
		SuggestInfoDao {

	@Override
	@SuppressWarnings("rawtypes")
	public PageResults<SuggestInfo> queryPageSuggestInfo(
			SuggestInfo suggestInfo, PageResults<SuggestInfo> pageResults) {
		// TODO Auto-generated method stub
		List<SuggestInfo> suggestInfos = new ArrayList<SuggestInfo>();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.ENGLISH);
			String coon = "";
			String hql = "select suggestId,suggestContent ,b.memberName suggestPersonId ,suggestStatus ,suggestTime"
					+ " from  t_suggest a left join t_member b on a.suggestPersonId = b.memberId"
					+ " where 1=1 " + coon;
			String countHql = "select count(*) from  t_suggest a left join t_member b on a.suggestPersonId = b.memberId "
					+ " where 1=1 " + coon;
			PageResults<SuggestInfo> results = findPageByFetchedSql(hql,
					countHql, pageResults.getPageNo(),
					pageResults.getPageSize());
			List temp = results.getRows();
			for (int i = 0; i < temp.size(); i++) {
				SuggestInfo tempObject = new SuggestInfo();
				Object[] obj = (Object[]) temp.get(i);
				tempObject.setSuggestId(obj[0]== null ?  "" : obj[0] + "");
				tempObject.setSuggestContent(obj[1]==null ? "" :obj[1] + "");
				tempObject.setSuggestPersonId(obj[2]==null ? "" :obj[2]+"");
				tempObject.setSuggestStatus(obj[3]==null ? "" : obj[3]+"");
				if(null!= obj[4]){
					tempObject.setSuggestTime(dateFormat.parse(obj[4] + ""));
				}
				suggestInfos.add(tempObject);
			}
			results.setRows(suggestInfos);
			return results;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean saveSuggestInfo(SuggestInfo suggestInfo) {
		try {
			if(null != suggestInfo && !"".equals(suggestInfo)){
				save(suggestInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteSuggestInfo(SuggestInfo suggestInfo) {
		try {
			if(null != suggestInfo && !"".equals(suggestInfo)){
				delete(suggestInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateSuggestInfo(SuggestInfo suggestInfo) {
		try {
			if(null != suggestInfo && !"".equals(suggestInfo)){
				update(suggestInfo);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<SuggestInfo> querySuggestInfo(String suggestPersonId) {
		String hql = "from SuggestInfo where suggestPersonId='"+suggestPersonId+"'";
		return getListByHQL(hql);
	}
	
	
	
	
	

}
