package com.jiuyi.net.mesage.email;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement(name = "Emaill")
@XmlAccessorType(XmlAccessType.FIELD)
public class Emaill implements Serializable {

	private String emId;// 邮件ID

	private String emContent;// 邮件内容

	private String emTitle;// 邮件主题

	private String emStatus;// 发送状态

	private String toWhere;// 发送目标地址

	private Date emTimes;// 邮件创建时间
	
	private Date emStimes;// 邮件发送时间
	
	private String verificationCode;//邮件验证码
	
	private String codeStatus;//验证码状态 0 未使用 1 已使用
	

	public String getEmId() {
		return emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public String getEmContent() {
		return emContent;
	}

	public void setEmContent(String emContent) {
		this.emContent = emContent;
	}

	public String getEmTitle() {
		return emTitle;
	}

	public void setEmTitle(String emTitle) {
		this.emTitle = emTitle;
	}

	public String getEmStatus() {
		return emStatus;
	}

	public void setEmStatus(String emStatus) {
		this.emStatus = emStatus;
	}

	public String getToWhere() {
		return toWhere;
	}

	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}

	public Date getEmTimes() {
		return emTimes;
	}

	public void setEmTimes(Date emTimes) {
		this.emTimes = emTimes;
	}

	public Date getEmStimes() {
		return emStimes;
	}

	public void setEmStimes(Date emStimes) {
		this.emStimes = emStimes;
	}
	
	public String getCodeStatus() {
		return codeStatus;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}
	
	@Transient
	public Date getLastActivateTime() {
		Calendar cl = Calendar.getInstance();
        cl.setTime(emStimes);
        cl.add(Calendar.MINUTE , 10);
		return cl.getTime();
	}
	
	public void setLastActivateTime(Date lastActivateTime) {
	}

}
