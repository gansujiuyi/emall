package com.jiuyi.jyplant.myCollection.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.myCollection.dao.CollectionInfoDao;
import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.myCollection.service.CollectionInfoService;
import com.jiuyi.jyplant.utils.PageResults;

@Service("collectionInfoService")
@Transactional
public class CollectionInfoServiceImpl implements CollectionInfoService {

	@Autowired
	private CollectionInfoDao collectionInfoDao;

	@Override
	public PageResults<CollectionInfo> queryPageCollectionInfo(
			CollectionInfo collectionInfo,
			PageResults<CollectionInfo> pageResults) {
		// TODO Auto-generated method stub
		return collectionInfoDao.queryPageCollectionInfo(collectionInfo,
				pageResults);

	}

	@Override
	public boolean saveCollectionInfo(CollectionInfo collectionInfo) {
		try {
			collectionInfoDao.save(collectionInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCollectionInfo(CollectionInfo collectionInfo) {
		try {
			collectionInfoDao.delete(collectionInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
