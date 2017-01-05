package com.jiuyi.net.mesage.memberInfo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement(name = "MemberInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberInfos implements Serializable {
	private String memberId;// 会员编号
	private String memberName;// 会员名称
	private String mpassWord;// 会员密码
	private String memberEmail;// 会员邮箱;
	private String memberAnswer;// 密码daan
	private String memberQuestion;// 密码问题
	private String memberRealName;// 真实姓名
	private String memberSex;// 会员性别 0--男 1--女;
	private String memberAddress;// 会员地址
	private String memerIdNo;// 会员身份证号码
	private Date memberRegTime;// 会员注册时间
	private String memberStatus;// 会员状态 0停用 1 启用 2 未激活
	private String membertype;// 会员类型 0--商户 1--普通用户
	private String memberLevel;// 会员级别;
	private String validateCode;// 激活码
	private String phoneNo;//手机号
	private String payPassWord;//支付密码
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMpassWord() {
		return mpassWord;
	}
	public void setMpassWord(String mpassWord) {
		this.mpassWord = mpassWord;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberAnswer() {
		return memberAnswer;
	}
	public void setMemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}
	public String getMemberQuestion() {
		return memberQuestion;
	}
	public void setMemberQuestion(String memberQuestion) {
		this.memberQuestion = memberQuestion;
	}
	public String getMemberRealName() {
		return memberRealName;
	}
	public void setMemberRealName(String memberRealName) {
		this.memberRealName = memberRealName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemerIdNo() {
		return memerIdNo;
	}
	public void setMemerIdNo(String memerIdNo) {
		this.memerIdNo = memerIdNo;
	}
	public Date getMemberRegTime() {
		return memberRegTime;
	}
	public void setMemberRegTime(Date memberRegTime) {
		this.memberRegTime = memberRegTime;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPayPassWord() {
		return payPassWord;
	}
	public void setPayPassWord(String payPassWord) {
		this.payPassWord = payPassWord;
	}
	
	public MemberInfos(String memberId, String memberName, String mpassWord,
			String memberEmail, String memberAnswer, String memberQuestion,
			String memberRealName, String memberSex, String memberAddress,
			String memerIdNo, Date memberRegTime, String memberStatus,
			String membertype, String memberLevel, String validateCode,
			String phoneNo, String payPassWord) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.mpassWord = mpassWord;
		this.memberEmail = memberEmail;
		this.memberAnswer = memberAnswer;
		this.memberQuestion = memberQuestion;
		this.memberRealName = memberRealName;
		this.memberSex = memberSex;
		this.memberAddress = memberAddress;
		this.memerIdNo = memerIdNo;
		this.memberRegTime = memberRegTime;
		this.memberStatus = memberStatus;
		this.membertype = membertype;
		this.memberLevel = memberLevel;
		this.validateCode = validateCode;
		this.phoneNo = phoneNo;
		this.payPassWord = payPassWord;
	}
	public MemberInfos() {
		super();
	}
	
}
