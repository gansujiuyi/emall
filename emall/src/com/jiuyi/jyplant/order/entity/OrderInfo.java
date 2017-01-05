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
@Entity
@Table(name="t_order",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8048707175791865941L;
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
	/*订单状态 0 加入购物车 1 下单成功 2 取消订单*/
	private String orderStatus;
	/*下单时间*/
	private String creationTime;
	/*备注*/
	private String t_desc;
	/*商品详情*/
	private String productDetails;
	/*快递信息*/
	private String expressId;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="orderId",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name="orderNum",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Column(name="addressId",nullable=false, length=100)
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@Column(name="aggregateAmount",nullable=false, length=100)
	public String getAggregateAmount() {
		return aggregateAmount;
	}
	public void setAggregateAmount(String aggregateAmount) {
		this.aggregateAmount = aggregateAmount;
	}
	@Column(name="payStatus",nullable=false, length=100)
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	@Column(name="orderStatus",nullable=false, length=100)
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Column(name="creationTime",nullable=false, length=100)
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	@Column(name="t_desc",nullable=false, length=200)
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	@Column(name="productDetails",nullable=false, length=100)
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	@Column(name="expressId",nullable=false, length=100)
	public String getExpressId() {
		return expressId;
	}
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
	@Column(name="memberId",nullable=false, length=100)
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
