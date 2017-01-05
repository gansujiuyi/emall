package com.jiuyi.jyplant.myCollection.entity;

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
 * 我的收藏
 * 
 * @author baizilin
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_collection", catalog = "emall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CollectionInfo implements Serializable {

	private String collectId;// 主键ID
	private String collectPersonId;// 收藏人ID
	private Date collectTiem;// 收藏时间
	private String collectProductId;// 收藏商品ID
	private String collectShopId;//收藏店铺ID;
	public CollectionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollectionInfo(String collectId, String collectPersonId,
			Date collectTiem, String collectProductId, String collectShopId) {
		super();
		this.collectId = collectId;
		this.collectPersonId = collectPersonId;
		this.collectTiem = collectTiem;
		this.collectProductId = collectProductId;
		this.collectShopId = collectShopId;
	}
	
	@Id
	// 指定生成器名称
	@GeneratedValue(generator = "uuid")
	// 生成器名称，uuid生成类
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "collectId", nullable = true, length = 100)
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	
	@Column(name = "collectPersonId", nullable = true, length = 100)
	public String getCollectPersonId() {
		return collectPersonId;
	}
	public void setCollectPersonId(String collectPersonId) {
		this.collectPersonId = collectPersonId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "collectTiem", nullable = true, length = 100)
	public Date getCollectTiem() {
		return collectTiem;
	}
	public void setCollectTiem(Date collectTiem) {
		this.collectTiem = collectTiem;
	}
	@Column(name = "collectProductId", nullable = false, length = 100)
	public String getCollectProductId() {
		return collectProductId;
	}
	public void setCollectProductId(String collectProductId) {
		this.collectProductId = collectProductId;
	}
	@Column(name = "collectShopId", nullable = false, length = 100)
	public String getCollectShopId() {
		return collectShopId;
	}
	public void setCollectShopId(String collectShopId) {
		this.collectShopId = collectShopId;
	}
	
}
