package com.jiuyi.net.mesage.myCollection;

import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.utils.PageResults;

public class CollectionReq {

	private CollectionInfo collectionInfo;
	private String opt;// 操作 opt='query' opt='save' opt='delete'
	private PageResults<CollectionInfo> pageResults;

	public CollectionInfo getCollectionInfo() {
		return collectionInfo;
	}

	public void setCollectionInfo(CollectionInfo collectionInfo) {
		this.collectionInfo = collectionInfo;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public PageResults<CollectionInfo> getPageResults() {
		return pageResults;
	}

	public void setPageResults(PageResults<CollectionInfo> pageResults) {
		this.pageResults = pageResults;
	}

	 
}
