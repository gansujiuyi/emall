package com.jiuyi.jyplant.seller.service;

import com.jiuyi.jyplant.seller.entity.License;

public interface LicenseService {
		
	/**
	 * 保存营业执照信息
	 * @param license
	 * @return
	 */
	public boolean saveLicense(License license);
}
