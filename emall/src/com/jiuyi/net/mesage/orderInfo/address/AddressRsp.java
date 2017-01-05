package com.jiuyi.net.mesage.orderInfo.address;

import java.util.List;

public class AddressRsp {
	
	
	private List<Address> addresses;
	
	private boolean check;
	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}



	
}
