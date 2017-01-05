package com.jiuyi.net.mesage.cpEvaluate;

import com.jiuyi.net.mesage.Head;

public class EvaluateReqMsg {
	
	/*请求头*/
	private Head msghead;
	
	private EvaluateReq evaluateReq;

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}

	public EvaluateReq getEvaluateReq() {
		return evaluateReq;
	}

	public void setEvaluateReq(EvaluateReq evaluateReq) {
		this.evaluateReq = evaluateReq;
	}


}
