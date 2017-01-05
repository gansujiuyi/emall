package com.jiuyi.jyplant.myCollection.dao;

import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface CollectionInfoDao extends IBaseDao<CollectionInfo, String> {
	
	public PageResults<CollectionInfo> queryPageCollectionInfo(CollectionInfo collectionInfo,
			PageResults<CollectionInfo> pageResults);

}
