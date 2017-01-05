package com.jiuyi.net.mesage.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
	/*商品信息主键id*/
	private String t_productId;
	/*商品名称*/
	private String t_productName;
	/*商品原价*/
	private String t_purchasePrice;
	/*商户id*/
	private String storeId;
	/*商品折扣价*/
	private String t_discountPrice;
	/*商品库存*/
	private String t_productNum;
	/*产地*/
	private String t_origin;
	/*所属分类*/
	private String t_categoryType;
	/*所属分类名称*/
	private String t_typeName;
	/*审核状态 0 已审核 1 未审核*/
	private String t_checkStatus;
	/*商品说明*/
	private String t_desc;
	/*商品图片*/
	private String t_productImg;
	
	public String getT_productId() {
		return t_productId;
	}
	public void setT_productId(String t_productId) {
		this.t_productId = t_productId;
	}
	public String getT_productName() {
		return t_productName;
	}
	public void setT_productName(String t_productName) {
		this.t_productName = t_productName;
	}
	public String getT_purchasePrice() {
		return t_purchasePrice;
	}
	public void setT_purchasePrice(String t_purchasePrice) {
		this.t_purchasePrice = t_purchasePrice;
	}
	public String getT_discountPrice() {
		return t_discountPrice;
	}
	public void setT_discountPrice(String t_discountPrice) {
		this.t_discountPrice = t_discountPrice;
	}
	public String getT_productNum() {
		return t_productNum;
	}
	public void setT_productNum(String t_productNum) {
		this.t_productNum = t_productNum;
	}
	public String getT_origin() {
		return t_origin;
	}
	public void setT_origin(String t_origin) {
		this.t_origin = t_origin;
	}
	public String getT_categoryType() {
		return t_categoryType;
	}
	public void setT_categoryType(String t_categoryType) {
		this.t_categoryType = t_categoryType;
	}
	public String getT_checkStatus() {
		return t_checkStatus;
	}
	public void setT_checkStatus(String t_checkStatus) {
		this.t_checkStatus = t_checkStatus;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	public String getT_productImg() {
		return t_productImg;
	}
	public void setT_productImg(String t_productImg) {
		this.t_productImg = t_productImg;
	}
	public String getT_typeName() {
		return t_typeName;
	}
	public void setT_typeName(String t_typeName) {
		this.t_typeName = t_typeName;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
}
