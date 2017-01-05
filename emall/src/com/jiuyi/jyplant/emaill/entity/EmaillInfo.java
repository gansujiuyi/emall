package com.jiuyi.jyplant.emaill.entity;

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
@Table(name = "t_emaill", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmaillInfo implements Serializable {

	private String emId;// 邮件ID

	private String emContent;// 邮件内容

	private String emTitle;// 邮件主题

	private String emStatus;// 发送状态 0 未发送 1 已发送

	private String toWhere;// 发送目标地址

	private Date emTimes;// 邮件创建时间
	
	private Date emStimes;// 邮件发送时间
	
	private String verificationCode;//邮件验证码
	
	private String codeStatus;//验证码状态 0 未使用 1 已使用
	

	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "emId", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getEmId() {
		return emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	@Column(name = "emContent", nullable = true, length = 500)
	// 解决属性名和字段名不对应
	public String getEmContent() {
		return emContent;
	}

	public void setEmContent(String emContent) {
		this.emContent = emContent;
	}

	@Column(name = "emTitle", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getEmTitle() {
		return emTitle;
	}

	public void setEmTitle(String emTitle) {
		this.emTitle = emTitle;
	}

	@Column(name = "emStatus", nullable = true, length = 2)
	// 解决属性名和字段名不对应
	public String getEmStatus() {
		return emStatus;
	}

	public void setEmStatus(String emStatus) {
		this.emStatus = emStatus;
	}

	@Column(name = "toWhere", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getToWhere() {
		return toWhere;
	}

	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "emTimes", nullable = false, length = 100)
	public Date getEmTimes() {
		return emTimes;
	}

	public void setEmTimes(Date emTimes) {
		this.emTimes = emTimes;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "emStimes", nullable = false, length = 100)
	public Date getEmStimes() {
		return emStimes;
	}

	public void setEmStimes(Date emStimes) {
		this.emStimes = emStimes;
	}
	@Column(name = "codeStatus", nullable = true, length = 10)
	public String getCodeStatus() {
		return codeStatus;
	}

	public String getVerificationCode() {
		return verificationCode;
	}
	@Column(name = "VerificationCode", nullable = true, length = 20)
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
