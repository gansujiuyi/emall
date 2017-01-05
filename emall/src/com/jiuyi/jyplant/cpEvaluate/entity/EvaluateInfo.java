package com.jiuyi.jyplant.cpEvaluate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/***
 * 商品评价
 * 
 * @author baizilin
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_evaluate", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EvaluateInfo implements Serializable {

	private String evalId;// 评价ID
	private String evalContent;// 评价内容
	private Date evalTime;// 评价时间
	private String evalPersonId;// 评价人ID
	private String evalProducdId;// 评价商品ID
	private String evalScore;// 评价分数

	public EvaluateInfo(String evalId, String evalContent, Date evalTime,
			String evalPersonId, String evalProducdId, String evalScore) {
		super();
		this.evalId = evalId;
		this.evalContent = evalContent;
		this.evalTime = evalTime;
		this.evalPersonId = evalPersonId;
		this.evalProducdId = evalProducdId;
		this.evalScore = evalScore;
	}

	public EvaluateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "evalId", nullable = true, length = 100)
	public String getEvalId() {
		return evalId;
	}

	public void setEvalId(String evalId) {
		this.evalId = evalId;
	}

	@Column(name = "evalContent", nullable = true, length = 300)
	public String getEvalContent() {
		return evalContent;
	}

	public void setEvalContent(String evalContent) {
		this.evalContent = evalContent;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "evalTime", nullable = true, length = 100)
	public Date getEvalTime() {
		return evalTime;
	}

	public void setEvalTime(Date evalTime) {
		this.evalTime = evalTime;
	}
	@Column(name = "evalPersonId", nullable = true, length = 100)
	public String getEvalPersonId() {
		return evalPersonId;
	}

	public void setEvalPersonId(String evalPersonId) {
		this.evalPersonId = evalPersonId;
	}

	@Column(name = "evalProducdId", nullable = true, length = 100)
	public String getEvalProducdId() {
		return evalProducdId;
	}

	public void setEvalProducdId(String evalProducdId) {
		this.evalProducdId = evalProducdId;
	}

	@Column(name = "evalScore", nullable = false, length = 100)
	public String getEvalScore() {
		return evalScore;
	}

	public void setEvalScore(String evalScore) {
		this.evalScore = evalScore;
	}

}
