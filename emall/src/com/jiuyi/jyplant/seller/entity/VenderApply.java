package com.jiuyi.jyplant.seller.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name="t_venderApply",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VenderApply  implements Serializable{
	
	/*商户id*/
	private String venderId;
	/*联系人姓名*/
	private String contactName;
	/*联系人手机*/
	private String contactPhone;
	/*联系人电子邮箱*/
	private String contactEmail;
	/*法定代表人姓名*/
	private String legalRepresentative;
	/*成立日期*/
	private Date establishDate;
	/*注册资本*/
	private double registeredCapital;
	/*公司所在地*/
	private String comAddrIds;
	/*公司详细地址*/
	private String addr;
	/*公司电话*/
	private String contactTel;
	/*公司紧急联系人*/
	private String tentactr;
	/*公司紧急联系人手机*/
	private String tentactrPhone;
	/*法定代表人证件类型 1 身份证 2 其他证件*/
	private String cardType;
	/*法定代表人身份证号*/
	private String personalNo;
	/*对公结算银行账号*/
	private String accountNum;
	/*开户银行支行名称*/
	private String bankName;
	/*法人身份证电子版上传路径*/
	private String comFilePath;
	
	
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="venderId",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	@Column(name="contactName", length=100)
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@Column(name="contactPhone", length=100)
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	@Column(name="contactEmail", length=100)
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	@Column(name="legalRepresentative", length=100)
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	@Column(name="establishDate", length=100)
	public Date getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}
	@Column(name="registeredCapital", length=100)
	public double getRegisteredCapital() {
		return registeredCapital;
	}
	public void setRegisteredCapital(double registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	@Column(name="comAddrIds", length=100)
	public String getComAddrIds() {
		return comAddrIds;
	}
	public void setComAddrIds(String comAddrIds) {
		this.comAddrIds = comAddrIds;
	}
	@Column(name="addr", length=100)
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Column(name="contactTel", length=100)
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	@Column(name="tentactr", length=100)
	public String getTentactr() {
		return tentactr;
	}
	public void setTentactr(String tentactr) {
		this.tentactr = tentactr;
	}
	@Column(name="cardType", length=100)
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	@Column(name="personalNo", length=100)
	public String getPersonalNo() {
		return personalNo;
	}
	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}
	@Column(name="comFilePath", length=100)
	public String getComFilePath() {
		return comFilePath;
	}
	public void setComFilePath(String comFilePath) {
		this.comFilePath = comFilePath;
	}
	@Column(name="accountNum", length=100)
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	@Column(name="bankName", length=100)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name="tentactrPhone", length=100)
	public String getTentactrPhone() {
		return tentactrPhone;
	}
	public void setTentactrPhone(String tentactrPhone) {
		this.tentactrPhone = tentactrPhone;
	}
	
	
}
