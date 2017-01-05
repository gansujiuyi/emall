package com.jiuyi.net.mesage.category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoryReq implements Serializable {

	/* 商品分类id */
	private String t_categoryId;

	public String getT_categoryId() {
		return t_categoryId;
	}

	public void setT_categoryId(String t_categoryId) {
		this.t_categoryId = t_categoryId;
	}

}
