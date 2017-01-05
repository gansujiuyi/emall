package com.jiuyi.net.mesage.orderInfo.address;

import com.jiuyi.net.mesage.Head;

public class AddressReqMsg {
	
	/*请求头*/
	private Head msghead;
	/*请求体*/
	private AddressReq addressReq;
	
	public Head getMsghead() {
		return msghead;
	}
	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}
	public AddressReq getAddressReq() {
		return addressReq;
	}
	public void setAddressReq(AddressReq addressReq) {
		this.addressReq = addressReq;
	}
	
	
	
	
	
	
	
}
