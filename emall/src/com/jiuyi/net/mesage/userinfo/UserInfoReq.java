package com.jiuyi.net.mesage.userinfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfoReq implements Serializable {

	private String userName;
	private String uPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

}
