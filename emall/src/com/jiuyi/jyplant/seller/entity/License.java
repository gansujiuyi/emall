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

/**
 * 营业执照
 * @author lyn
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_license",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class License implements Serializable{
	/*许可证id*/
	private String licenseId;
	/*商户id*/
	private String venderId;
	/*执照类型*/
	private String licenseType;
	/*公司名称*/
	private String companyName;
	/*营业执照注册号*/
	private String businessLicense;
	/*营业执照所在地*/
	private String licenseAddrIds;
	/*营业地址*/
	private String licenseAdd;
	/*营业期限开始开始*/
	private Date licenseExpDateStart;
	/*营业期限结束时间*/
	private Date licenseExpDateEnd;
	/*营业期限长期有效*/
	private Date isForEver;
	/*经营范围*/
	private String licenseArea;
	/*营业执照电子版上传路径*/
	private String licenseFilePath;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="licenseId",nullable=true, length=100) 
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	@Column(name="venderId", length=100)
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	@Column(name="businessLicense", length=100)
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	@Column(name="licenseAddrIds", length=100)
	public String getLicenseAddrIds() {
		return licenseAddrIds;
	}
	public void setLicenseAddrIds(String licenseAddrIds) {
		this.licenseAddrIds = licenseAddrIds;
	}
	@Column(name="licenseAdd", length=100)
	public String getLicenseAdd() {
		return licenseAdd;
	}
	public void setLicenseAdd(String licenseAdd) {
		this.licenseAdd = licenseAdd;
	}
	@Column(name="licenseExpDateStart", length=100)
	public Date getLicenseExpDateStart() {
		return licenseExpDateStart;
	}
	public void setLicenseExpDateStart(Date licenseExpDateStart) {
		this.licenseExpDateStart = licenseExpDateStart;
	}
	@Column(name="licenseExpDateEnd", length=100)
	public Date getLicenseExpDateEnd() {
		return licenseExpDateEnd;
	}
	public void setLicenseExpDateEnd(Date licenseExpDateEnd) {
		this.licenseExpDateEnd = licenseExpDateEnd;
	}
	@Column(name="isForEver", length=100)
	public Date getIsForEver() {
		return isForEver;
	}
	public void setIsForEver(Date isForEver) {
		this.isForEver = isForEver;
	}
	@Column(name="licenseArea", length=100)
	public String getLicenseArea() {
		return licenseArea;
	}
	public void setLicenseArea(String licenseArea) {
		this.licenseArea = licenseArea;
	}
	@Column(name="licenseType", length=100)
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	@Column(name="companyName", length=100)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="licenseFilePath", length=100)
	public String getLicenseFilePath() {
		return licenseFilePath;
	}
	public void setLicenseFilePath(String licenseFilePath) {
		this.licenseFilePath = licenseFilePath;
	}
	
	
	
	
}	
