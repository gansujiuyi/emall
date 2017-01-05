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
@Table(name="t_express",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ExpressInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6575403265792852482L;
	/*快递 主键id*/
	private String expressId;
	/*订单编号*/
	private String orderNum;
	/*快递公司名称*/
	private String corporateName;
	/*快递编号*/
	private String expressNum;
	/*发货状态 0 为发货 1 已发货*/
	private String sendStatus;
	/*快递状态 0 未签收 1 已签收 2 快递中*/
	private String expressStatus;
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="expressId",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getExpressId() {
		return expressId;
	}
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
	@Column(name="orderNum",nullable=false, length=100)
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Column(name="corporateName",nullable=false, length=100)
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	@Column(name="expressNum",nullable=false, length=100)
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	@Column(name="sendStatus",nullable=false, length=100)
	public String getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	@Column(name="expressStatus",nullable=false, length=100)
	public String getExpressStatus() {
		return expressStatus;
	}
	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
