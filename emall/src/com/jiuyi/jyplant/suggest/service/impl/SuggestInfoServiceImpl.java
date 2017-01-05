package com.jiuyi.jyplant.suggest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.suggest.dao.SuggestInfoDao;
import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.suggest.service.SuggestInfoService;
import com.jiuyi.jyplant.utils.PageResults;

@Transactional
@Service("suggestInfoService")
public class SuggestInfoServiceImpl implements SuggestInfoService {

	@Autowired
	private SuggestInfoDao suggestInfoDao;

	@Override
	public PageResults<SuggestInfo> queryPageSuggestInfo(
			SuggestInfo suggestInfo, PageResults<SuggestInfo> pageResults) {
		return suggestInfoDao.queryPageSuggestInfo(suggestInfo, pageResults);
	}

	@Override
	public boolean saveSuggestInfo(SuggestInfo suggestInfo) {
		return suggestInfoDao.saveSuggestInfo(suggestInfo);
	}

	@Override
	public boolean deleteSuggestInfo(SuggestInfo suggestInfo) {
		return suggestInfoDao.deleteSuggestInfo(suggestInfo);
	}

	@Override
	public boolean updateSuggestInfo(SuggestInfo suggestInfo) {
		return suggestInfoDao.updateSuggestInfo(suggestInfo);
	}

	@Override
	public List<SuggestInfo> querySuggestInfo(String suggestPersonId) {
		return suggestInfoDao.querySuggestInfo(suggestPersonId);
	}	
	
	
}
