package com.jiuyi.jyplant.suggest.entity;

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

@SuppressWarnings("serial")
@Entity
@Table(name = "t_suggest", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SuggestInfo implements Serializable {

	private String suggestId;// 主键ID
	private String suggestContent;// 建议内容
	private Date suggestTime;// 建议时间
	private String suggestPersonId;// 提建议人ID
	private String suggestStatus;// 意见状态

	public SuggestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuggestInfo(String suggestId, String suggestContent,
			Date suggestTime, String suggestPersonId, String suggestStatus) {
		super();
		this.suggestId = suggestId;
		this.suggestContent = suggestContent;
		this.suggestTime = suggestTime;
		this.suggestPersonId = suggestPersonId;
		this.suggestStatus = suggestStatus;
	}

	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "suggestId", nullable = true, length = 100)
	public String getSuggestId() {
		return suggestId;
	}

	public void setSuggestId(String suggestId) {
		this.suggestId = suggestId;
	}

	@Column(name = "suggestContent", nullable = true, length = 100)
	public String getSuggestContent() {
		return suggestContent;
	}

	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "suggestTime", nullable = true, length = 100)
	public Date getSuggestTime() {
		return suggestTime;
	}

	public void setSuggestTime(Date suggestTime) {
		this.suggestTime = suggestTime;
	}
	@Column(name = "suggestPersonId", nullable = true, length = 100)
	public String getSuggestPersonId() {
		return suggestPersonId;
	}

	public void setSuggestPersonId(String suggestPersonId) {
		this.suggestPersonId = suggestPersonId;
	}
	@Column(name = "suggestStatus", nullable = true, length = 2)
	public String getSuggestStatus() {
		return suggestStatus;
	}

	public void setSuggestStatus(String suggestStatus) {
		this.suggestStatus = suggestStatus;
	}

}
