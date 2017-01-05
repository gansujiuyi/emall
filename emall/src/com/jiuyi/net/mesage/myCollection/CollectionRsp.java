package com.jiuyi.net.mesage.myCollection;

import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.utils.PageResults;

public class CollectionRsp {

	private PageResults<CollectionInfo> pageResults;

	public PageResults<CollectionInfo> getPageResults() {
		return pageResults;
	}

	public void setPageResults(PageResults<CollectionInfo> pageResults) {
		this.pageResults = pageResults;
	}

}
