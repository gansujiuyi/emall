package com.jiuyi.net.mesage.orderInfo.address;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "MemberInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable {
	
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
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getPurchaserTel() {
		return purchaserTel;
	}
	public void setPurchaserTel(String purchaserTel) {
		this.purchaserTel = purchaserTel;
	}
	public String getPurchaseRaddress() {
		return purchaseRaddress;
	}
	public void setPurchaseRaddress(String purchaseRaddress) {
		this.purchaseRaddress = purchaseRaddress;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}
