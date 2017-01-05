package com.jiuyi.net.mesage.product;

import com.jiuyi.net.mesage.Head;

public class ProductReqMsg {
	
	private Head msghead;
	
	private ProductReq productReq;
	
	public ProductReq getProductReq() {
		return productReq;
	}

	public void setProductReq(ProductReq productReq) {
		this.productReq = productReq;
	}

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}
	
	
	
	
}
