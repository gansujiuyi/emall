package com.jiuyi.net.mesage.category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoryRspMsg implements Serializable{
	/*响应体*/
	protected CategoryRsp categoryRsp;

	protected String retCode;
	
	protected String retShow;

	public CategoryRsp getCategoryRsp() {
		return categoryRsp;
	}

	public void setCategoryRsp(CategoryRsp categoryRsp) {
		this.categoryRsp = categoryRsp;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetShow() {
		return retShow;
	}

	public void setRetShow(String retShow) {
		this.retShow = retShow;
	}
	
	
	
}
