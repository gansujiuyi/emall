package com.jiuyi.jyplant.member.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_member", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MemberInfo implements Serializable {
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
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "memberId", nullable = true, length = 100, unique = true)
	// 解决属性名和字段名不对应
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Column(name = "memberName", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "mpassWord", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMpassWord() {
		return mpassWord;
	}

	public void setMpassWord(String mpassWord) {
		this.mpassWord = mpassWord;
	}

	@Column(name = "memberEmail", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	@Column(name = "memberAnswer", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberAnswer() {
		return memberAnswer;
	}

	public void setMemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}

	@Column(name = "memberQuestion", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberQuestion() {
		return memberQuestion;
	}

	public void setMemberQuestion(String memberQuestion) {
		this.memberQuestion = memberQuestion;
	}

	@Column(name = "memberRealName", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberRealName() {
		return memberRealName;
	}

	public void setMemberRealName(String memberRealName) {
		this.memberRealName = memberRealName;
	}

	@Column(name = "memberSex", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	@Column(name = "memberAddress", length = 100)
	// 解决属性名和字段名不对应
	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	@Column(name = "memerIdNo", length = 100)
	// 解决属性名和字段名不对应
	public String getMemerIdNo() {
		return memerIdNo;
	}

	public void setMemerIdNo(String memerIdNo) {
		this.memerIdNo = memerIdNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "memberRegTime", length = 100)
	public Date getMemberRegTime() {
		return memberRegTime;
	}

	public void setMemberRegTime(Date memberRegTime) {
		this.memberRegTime = memberRegTime;
	}

	@Column(name = "memberStatus", length = 100)
	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	@Column(name = "membertype", length = 100)
	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	@Column(name = "memberLevel", length = 100)
	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	@Transient
	public Date getLastActivateTime() {
		Calendar cl = Calendar.getInstance();
        cl.setTime(memberRegTime);
        cl.add(Calendar.DATE , 2);
		return cl.getTime();
	}

	public void setLastActivateTime(Date lastActivateTime) {
	}
	@Column(name = "phoneNo", length = 100)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(name = "payPassWord", length = 100)
	public String getPayPassWord() {
		return payPassWord;
	}

	public void setPayPassWord(String payPassWord) {
		this.payPassWord = payPassWord;
	}

	@Column(name = "validateCode", length = 100)
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
