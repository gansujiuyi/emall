package com.jiuyi.net.mesage.orderInfo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@SuppressWarnings("serial")
@XmlRootElement(name = "MemberInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable{
	
	/*订单主键id*/
	private String orderId;
	/*会员编号*/
	private String memberId;
	/*订单编号*/
	private String orderNum;
	/*收件人信息*/
	private String addressId;
	/*订单总金额*/
	private String aggregateAmount;
	/*支付状态 0 支付失败 1 支付成功*/
	private String payStatus;
	/*订单状态 0 下单成功 1 下单失败*/
	private String orderStatus;
	/*商品id*/
	private String productId;
	/*下单时间*/
	private String creationTime;
	/*备注*/
	private String t_desc;
	/*商品详情*/
	private String productDetails;
	/*快递信息*/
	private String expressId;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAggregateAmount() {
		return aggregateAmount;
	}
	public void setAggregateAmount(String aggregateAmount) {
		this.aggregateAmount = aggregateAmount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public String getExpressId() {
		return expressId;
	}
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	

}
