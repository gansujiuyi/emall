package com.jiuyi.net.mesage.email;

import com.jiuyi.net.mesage.Head;

public class EmaillReqMsg {
	
	/*请求头*/
	private Head msghead;
	
	private EmaillReq emaillReq;

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}

	public EmaillReq getEmaillReq() {
		return emaillReq;
	}

	public void setEmaillReq(EmaillReq emaillReq) {
		this.emaillReq = emaillReq;
	}
	
	
	
	
}
