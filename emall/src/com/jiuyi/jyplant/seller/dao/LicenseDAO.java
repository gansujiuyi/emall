package com.jiuyi.jyplant.seller.dao;

import com.jiuyi.jyplant.seller.entity.License;

public interface LicenseDAO {
	/**
	 * 保存营业执照信息
	 * @param license
	 * @return
	 */
	public boolean saveLicense(License license);
}
