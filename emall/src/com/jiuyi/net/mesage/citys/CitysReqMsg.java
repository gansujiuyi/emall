package com.jiuyi.net.mesage.citys;

import com.jiuyi.net.mesage.Head;

public class CitysReqMsg {
	
	/*请求头*/
	private Head msghead;
	
	private CitysReq citysReq;

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}

	public CitysReq getCitysReq() {
		return citysReq;
	}

	public void setCitysReq(CitysReq citysReq) {
		this.citysReq = citysReq;
	}

	 
	
	
}
