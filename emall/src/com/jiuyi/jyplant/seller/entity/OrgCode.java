package com.jiuyi.jyplant.seller.entity;

import java.io.File;
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
 * 组织机构代码证
 * @author lyn
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_orgCode",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
 public class OrgCode implements Serializable{
	/*组织机构代码证id*/
	private String orgCodeId;
	/*组织机构代码*/
	private String orgCode;
	/*组织机构代码证有效期 开始*/
	private Date orgExpDateStart;
	/*组织机构代码证有效期 结束*/
	private Date orgExpDateEnd;
	/*组织机构代码证有效期 长期*/
	private Date isForEver;
	/*组织机构代码证上传路径*/
	private File orgFilePath;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="orgCodeId",nullable=true, length=100) 
	public String getOrgCodeId() {
		return orgCodeId;
	}
	public void setOrgCodeId(String orgCodeId) {
		this.orgCodeId = orgCodeId;
	}
	@Column(name="orgCode",nullable=false, length=100)
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	@Column(name="orgExpDateStart",nullable=false, length=100)
	public Date getOrgExpDateStart() {
		return orgExpDateStart;
	}
	public void setOrgExpDateStart(Date orgExpDateStart) {
		this.orgExpDateStart = orgExpDateStart;
	}
	@Column(name="orgExpDateEnd",nullable=false, length=100)
	public Date getOrgExpDateEnd() {
		return orgExpDateEnd;
	}
	public void setOrgExpDateEnd(Date orgExpDateEnd) {
		this.orgExpDateEnd = orgExpDateEnd;
	}
	@Column(name="isForEver",nullable=false, length=100)
	public Date getIsForEver() {
		return isForEver;
	}
	public void setIsForEver(Date isForEver) {
		this.isForEver = isForEver;
	}
	@Column(name="orgFilePath",nullable=false, length=100)
	public File getOrgFilePath() {
		return orgFilePath;
	}
	public void setOrgFilePath(File orgFilePath) {
		this.orgFilePath = orgFilePath;
	}
	
}