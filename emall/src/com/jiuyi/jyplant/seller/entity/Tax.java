package com.jiuyi.jyplant.seller.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

 /**
 * 税务信息
 * @author lyn
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_tax",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tax implements Serializable{
	/*税务登记证id*/
	private String taxId;
	/*纳税人类型*/
	private String taxType;
	/*纳税人识别号*/
	private String taxNo;
	/*纳税类型税码*/
	private String taxNum;
	/*税务登记证电子版 上传路径*/
	private String taxFilePath;
	/*一般纳税人资格证电子版 上传路径*/
	private String taxNorFilePath;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="taxId",nullable=true, length=100) 
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	@Column(name="taxType",length=100)
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	@Column(name="taxNo",length=100)
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	@Column(name="taxNum",length=100)
	public String getTaxNum() {
		return taxNum;
	}
	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}
	@Column(name="taxFilePath",length=100)
	public String getTaxFilePath() {
		return taxFilePath;
	}
	public void setTaxFilePath(String taxFilePath) {
		this.taxFilePath = taxFilePath;
	}
	@Column(name="taxNorFilePath",length=100)
	public String getTaxNorFilePath() {
		return taxNorFilePath;
	}
	public void setTaxNorFilePath(String taxNorFilePath) {
		this.taxNorFilePath = taxNorFilePath;
	}
}
