package com.jiuyi.jyplant.seller.dao;

import com.jiuyi.jyplant.seller.entity.VenderApply;

public interface VenderApplyDAO {
	/**
	 * 保存商户信息
	 * @param VenderApply
	 * @return
	 */
	public VenderApply saveVenderApply(VenderApply VenderApply);
	/**
	 * 更新商户信息
	 * @param VenderApply
	 * @return
	 */
	public VenderApply updateVenderApply(VenderApply VenderApply);

}
