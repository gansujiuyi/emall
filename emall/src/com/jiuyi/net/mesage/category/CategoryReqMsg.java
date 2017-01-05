package com.jiuyi.net.mesage.category;

import java.io.Serializable;

import com.jiuyi.net.mesage.Head;


@SuppressWarnings("serial")
public class CategoryReqMsg implements Serializable{
	
	
	/*请求头*/
	protected Head msghead;
	/*请求体*/
	protected CategoryReq categoryReq;
	
	public Head getMsghead() {
		return msghead;
	}
	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}
	public CategoryReq getCategoryReq() {
		return categoryReq;
	}
	public void setCategoryReq(CategoryReq categoryReq) {
		this.categoryReq = categoryReq;
	}
	
	
	
	
	
	
	
}
