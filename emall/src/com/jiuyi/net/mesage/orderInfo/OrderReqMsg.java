package com.jiuyi.net.mesage.orderInfo;

import com.jiuyi.net.mesage.Head;

public class OrderReqMsg {
	
	/*请求头*/
	protected Head msghead;
	/*请求体*/
	private OrderReq orderReq;
	
	public Head getMsghead() {
		return msghead;
	}
	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}
	public OrderReq getOrderReq() {
		return orderReq;
	}
	public void setOrderReq(OrderReq orderReq) {
		this.orderReq = orderReq;
	}
	
	
	
	
	
}
