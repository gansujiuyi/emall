package com.jiuyi.net.mesage.memberInfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberInfoReq implements Serializable {

	private MemberInfos memberInfos;
	
	private String content;

	public MemberInfos getMemberInfos() {
		return memberInfos;
	}

	public void setMemberInfos(MemberInfos memberInfos) {
		this.memberInfos = memberInfos;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}
