package com.jiuyi.jyplant.syscontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 登陆信息实体类
 * 
 * @author Dylan
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "xt_user_role", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UsersRole implements java.io.Serializable {

	private String user_id;
	private String role_id;

	@Id
	@Column(name="user_id",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Id
	@Column(name="role_id",nullable=true, length=100) //解决属性名和字段名不对应 
	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

}
