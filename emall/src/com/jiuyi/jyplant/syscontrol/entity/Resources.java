package com.jiuyi.jyplant.syscontrol.entity;

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
@Table(name="xt_resources",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Resources implements java.io.Serializable {

	
	private String id;
	private String text;
	private String parentId; //父类Id
	private String parentName;
	private String resKey;//这个权限KEY是唯一的，新增时要注意，
	private String resUrl;//URL地址．例如：/videoType/query　　不需要项目名和http://xxx:8080
	private String level;
	private String type;//权限类型，0．表示目录　1，表示菜单．2，表示按扭．．在spring security3安全权限中，涉及精确到按扭控制
	private String description;

	public Resources() {
	}

	@Id
	// 指定生成器名称
	 @GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name="type",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(name="text",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="resUrl",nullable=false, length=200) //解决属性名和字段名不对应 
	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	@Column(name="level",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name="resKey",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	@Column(name="description",nullable=false, length=200) //解决属性名和字段名不对应 
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="parentId",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	@Column(name="parentName",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}