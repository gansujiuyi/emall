package com.jiuyi.net.mesage.memberInfo;

import com.jiuyi.net.mesage.Head;

public class MemberInfoReqMsg {
	
	/*请求头*/
	protected Head msghead;
	/*请求体*/
	protected MemberInfoReq memberInfoReq;

	public Head getMsghead() {
		return msghead;
	}

	public void setMsghead(Head msghead) {
		this.msghead = msghead;
	}

	public MemberInfoReq getMemberInfoReq() {
		return memberInfoReq;
	}

	public void setMemberInfoReq(MemberInfoReq memberInfoReq) {
		this.memberInfoReq = memberInfoReq;
	}


	
	
	
	
}
