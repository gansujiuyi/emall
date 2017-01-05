package com.jiuyi.net.mesage.memberInfo;

import java.io.Serializable;


@SuppressWarnings("serial")
public class MemberInfoRspMsg implements Serializable{
	
	protected MemberInfoRsp memberInfoRsp;
	
	protected String retCode;
	
	protected String retShow;

	public MemberInfoRsp getMemberInfoRsp() {
		return memberInfoRsp;
	}

	public void setMemberInfoRsp(MemberInfoRsp memberInfoRsp) {
		this.memberInfoRsp = memberInfoRsp;
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
