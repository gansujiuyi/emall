package com.jiuyi.jyplant.order.entity;

import java.io.Serializable;

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
@Table(name="t_address",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AddressInfo implements Serializable {
	
	/*主键id*/
	private String addressId;
	/*购买人*/
	private String purchaser;
	/*购买人电话*/
	private String purchaserTel;
	/*购买人地址*/
	private String purchaseRaddress;
	/*是否为默认地址 0 默认 */
	private String def;
	/*会员id*/
	private String memberId;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="addressId",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@Column(name="purchaser",nullable=false, length=100)
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	@Column(name="purchaserTel",nullable=false, length=100)
	public String getPurchaserTel() {
		return purchaserTel;
	}
	public void setPurchaserTel(String purchaserTel) {
		this.purchaserTel = purchaserTel;
	}
	@Column(name="purchaseRaddress",nullable=false, length=100)
	public String getPurchaseRaddress() {
		return purchaseRaddress;
	}
	public void setPurchaseRaddress(String purchaseRaddress) {
		this.purchaseRaddress = purchaseRaddress;
	}
	@Column(name="def",nullable=false, length=100)
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	@Column(name="memberId",nullable=false, length=100)
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
