package com.jiuyi.jyplant.syscontrol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户实体表
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "xt_user", catalog = "emall")
public class Users implements java.io.Serializable {

	private String userId;

	private String userName;

	private String userPassword;

	private String userNickname;

	private String userRealname;

	private Integer userAge;

	private String userSex;

	private String userAddress;

	private String userPhone;

	private String userMail;

	private String userQQ;

	private Date regTime;

	private Date lastLogintime;

	private Integer level;

	private String ustatus; // 是否禁用角色　0　表示禁用　1　表示不禁用

	public Users() {
	}

	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "userId", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Users(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Column(name = "userName", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "userPassword", nullable = true, length = 100)
	// 解决属性名和字段名不对应
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "userNickname", nullable = false, length = 100)
	// 解决属性名和字段名不对应
	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Column(name = "userRealname", nullable = false, length = 100)
	// 解决属性名和字段名不对应
	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	@Column(name = "userAge", nullable = false, length = 10)
	// 解决属性名和字段名不对应
	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Column(name = "userSex", nullable = false, length = 2)
	// 解决属性名和字段名不对应
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "userAddress", nullable = false, length = 200)
	// 解决属性名和字段名不对应
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "userPhone", nullable = false, length = 20)
	// 解决属性名和字段名不对应
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "userMail", nullable = false, length = 100)
	// 解决属性名和字段名不对应
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Column(name = "userQQ", nullable = false, length = 20)
	// 解决属性名和字段名不对应
	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "regTime", nullable = false, length = 100)
	// 解决属性名和字段名不对应
	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLogintime", nullable = false, length = 100)
	// 解决属性名和字段名不对应
	public Date getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(Date lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	@Column(name = "level", nullable = false, length = 2)
	// 解决属性名和字段名不对应
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getUstatus() {
		return ustatus;
	}

	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}

}
