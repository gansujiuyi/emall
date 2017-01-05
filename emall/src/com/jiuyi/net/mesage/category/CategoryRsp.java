package com.jiuyi.net.mesage.category;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CategoryRsp implements Serializable {

	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
