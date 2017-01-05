package com.jiuyi.net.mesage.category;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "Category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements Serializable{
	

	/* 商品分类id */
	private String t_categoryId;
	/* 商品分类名称 */
	private String t_categoryName;
	/* 审核状态 0 未审核 1 已审核 */
	private String t_checkStatus;
	/* 所属类别 0 代表顶级类目 */
	private String t_categoryType;
	/* 所属类别名称 */
	private String t_typeName;
	/* 商品分类描述 */
	private String t_desc;
	public String getT_categoryId() {
		return t_categoryId;
	}
	public void setT_categoryId(String t_categoryId) {
		this.t_categoryId = t_categoryId;
	}
	public String getT_categoryName() {
		return t_categoryName;
	}
	public void setT_categoryName(String t_categoryName) {
		this.t_categoryName = t_categoryName;
	}
	public String getT_checkStatus() {
		return t_checkStatus;
	}
	public void setT_checkStatus(String t_checkStatus) {
		this.t_checkStatus = t_checkStatus;
	}
	public String getT_categoryType() {
		return t_categoryType;
	}
	public void setT_categoryType(String t_categoryType) {
		this.t_categoryType = t_categoryType;
	}
	public String getT_typeName() {
		return t_typeName;
	}
	public void setT_typeName(String t_typeName) {
		this.t_typeName = t_typeName;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	
	
	
	
	
}
