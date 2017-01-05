package com.jiuyi.jyplant.suggest.dao;

import java.util.List;

import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface SuggestInfoDao extends IBaseDao<SuggestInfo, String> {
	
	public PageResults<SuggestInfo> queryPageSuggestInfo(SuggestInfo suggestInfo,
			PageResults<SuggestInfo> pageResults);

	public boolean saveSuggestInfo(SuggestInfo suggestInfo);

	public boolean deleteSuggestInfo(SuggestInfo suggestInfo);

	public boolean updateSuggestInfo(SuggestInfo suggestInfo);

	public List<SuggestInfo> querySuggestInfo(String suggestPersonId);
	
	
	
	
	
	
	
}
