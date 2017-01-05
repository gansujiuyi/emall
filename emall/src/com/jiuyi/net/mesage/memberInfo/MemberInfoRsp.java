package com.jiuyi.net.mesage.memberInfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberInfoRsp implements Serializable {

	private MemberInfos memberInfos;
	
	private boolean check;
	

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public MemberInfos getMemberInfos() {
		return memberInfos;
	}

	public void setMemberInfos(MemberInfos memberInfos) {
		this.memberInfos = memberInfos;
	}


	
	

}
