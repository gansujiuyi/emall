package com.jiuyi.jyplant.emaill.dao;

import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface EmaillInfoDao extends IBaseDao<EmaillInfo, String> {

	
	public PageResults<EmaillInfo> queryPageEmaillInfo(EmaillInfo emaillInfo,
			PageResults<EmaillInfo> pageResults);

	public boolean saveEmaillInfo(EmaillInfo emaillInfo);

	public EmaillInfo queryEmaillCode(String toWhere);

	public boolean updateEmail(EmaillInfo emaillInfo);
	
	
}
