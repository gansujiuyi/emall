package com.jiuyi.net.mesage.userinfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfoRspMsg implements Serializable {

	protected UserInfoRsp infoRsp;
	protected String retCode;
	protected String retShow;

	public UserInfoRsp getInfoRsp() {
		return infoRsp;
	}

	public void setInfoRsp(UserInfoRsp infoRsp) {
		this.infoRsp = infoRsp;
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
