package com.jiuyi.net.mesage.userinfo;

import com.jiuyi.net.mesage.Head;


public class UserInfoReqMsg {

	protected Head msghead;
	protected UserInfoReq infoReq;
	

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}

	public UserInfoReq getInfoReq() {
		return infoReq;
	}

	public void setInfoReq(UserInfoReq infoReq) {
		this.infoReq = infoReq;
	}

}
