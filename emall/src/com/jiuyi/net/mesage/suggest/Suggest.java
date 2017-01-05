package com.jiuyi.net.mesage.suggest;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "Suggest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suggest implements Serializable {
	
	private String suggestId;// 主键ID
	private String suggestContent;// 建议内容
	private Date suggestTime;// 建议时间
	private String suggestPersonId;// 提建议人ID
	private String suggestStatus;// 意见状态
	
	public String getSuggestId() {
		return suggestId;
	}
	public void setSuggestId(String suggestId) {
		this.suggestId = suggestId;
	}
	public String getSuggestContent() {
		return suggestContent;
	}
	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}
	public Date getSuggestTime() {
		return suggestTime;
	}
	public void setSuggestTime(Date suggestTime) {
		this.suggestTime = suggestTime;
	}
	public String getSuggestPersonId() {
		return suggestPersonId;
	}
	public void setSuggestPersonId(String suggestPersonId) {
		this.suggestPersonId = suggestPersonId;
	}
	public String getSuggestStatus() {
		return suggestStatus;
	}
	public void setSuggestStatus(String suggestStatus) {
		this.suggestStatus = suggestStatus;
	}
}
