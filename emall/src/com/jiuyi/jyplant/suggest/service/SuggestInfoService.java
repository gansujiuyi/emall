package com.jiuyi.jyplant.suggest.service;

import java.util.List;

import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface SuggestInfoService {
	
	public PageResults<SuggestInfo> queryPageSuggestInfo(SuggestInfo suggestInfo,
			PageResults<SuggestInfo> pageResults);
	/**
	 * 查询建议
	 * @return
	 */
	public List<SuggestInfo> querySuggestInfo(String suggestPersonId);
	/**
	 * 保存建议
	 * @param SuggestInfo
	 * @return
	 */
	public boolean saveSuggestInfo(SuggestInfo suggestInfo);
	/**
	 * 取消建议
	 * @param SuggestInfo
	 * @return
	 */
	public boolean deleteSuggestInfo(SuggestInfo suggestInfo);
	/**
	 * 修改建议
	 * @param SuggestInfo
	 * @return
	 */
	public boolean updateSuggestInfo(SuggestInfo suggestInfo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
