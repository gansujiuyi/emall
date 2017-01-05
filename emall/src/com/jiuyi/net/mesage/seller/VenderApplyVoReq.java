package com.jiuyi.net.mesage.seller;

import com.jiuyi.jyplant.seller.entity.License;
import com.jiuyi.jyplant.seller.entity.OrgCode;
import com.jiuyi.jyplant.seller.entity.Shop;
import com.jiuyi.jyplant.seller.entity.Tax;
import com.jiuyi.jyplant.seller.entity.VenderApply;

public class VenderApplyVoReq {
	/*营业执照*/
	private License license;
	/*组织机构信息*/
	private OrgCode Orgcode;
	/*税务信息*/
	private Tax tax;
	/*商户信息*/
	private VenderApply venderapply;
	/*店铺信息*/
	private Shop shop;
	
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public OrgCode getOrgcode() {
		return Orgcode;
	}
	public void setOrgcode(OrgCode orgcode) {
		Orgcode = orgcode;
	}
	public Tax getTax() {
		return tax;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	public VenderApply getVenderapply() {
		return venderapply;
	}
	public void setVenderapply(VenderApply venderapply) {
		this.venderapply = venderapply;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
