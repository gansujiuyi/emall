package com.jiuyi.jyplant.myCollection.service;

import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface CollectionInfoService {
	
	//分页查询我的收藏
	public PageResults<CollectionInfo> queryPageCollectionInfo(CollectionInfo collectionInfo,
			PageResults<CollectionInfo> pageResults);
	
	//保存收藏
	public boolean saveCollectionInfo(CollectionInfo collectionInfo);
	
	//删除我的收藏
	public boolean deleteCollectionInfo(CollectionInfo collectionInfo);
	
}
