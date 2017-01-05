package com.jiuyi.net.mesage.userinfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfoRsp implements Serializable {

	private Userinfo userinfo;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}
