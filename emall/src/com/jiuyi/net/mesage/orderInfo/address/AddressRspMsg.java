package com.jiuyi.net.mesage.orderInfo.address;

public class AddressRspMsg {
	
	private AddressRsp addressRsp;
	
	private String retCode;
	
	private String retShow;

	public AddressRsp getAddressRsp() {
		return addressRsp;
	}

	public void setAddressRsp(AddressRsp addressRsp) {
		this.addressRsp = addressRsp;
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
