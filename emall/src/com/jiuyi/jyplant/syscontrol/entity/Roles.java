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
@Table(name="xt_role",catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Roles implements java.io.Serializable {

	
	private String id;
	private String enable;//是否禁用角色　0　表示禁用　1　表示不禁用
	private String name;
	private String roleKey;
	private String description;
	

	public Roles() {
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
	@Column(name="enable",nullable=false, length=10) //解决属性名和字段名不对应 
	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Column(name="name",nullable=false, length=100) //解决属性名和字段名不对应 
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description",nullable=false, length=200) //解决属性名和字段名不对应
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="roleKey",nullable=false, length=100) //解决属性名和字段名不对应
	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}


}