package com.jiuyi.jyplant.seller.service;

import com.jiuyi.jyplant.seller.entity.VenderApply;

public interface VenderApplyService {
	/**
	 * 保存商户信息
	 * @param sellerInfo
	 * @return
	 */
	public VenderApply saveVenderApply(VenderApply venderApply);
	/**
	 * 更新商户信息
	 * @param venderApply
	 * @return
	 */
	public VenderApply updateVenderApply(VenderApply venderApply);

}
