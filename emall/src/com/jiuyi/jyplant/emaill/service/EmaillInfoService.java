package com.jiuyi.jyplant.emaill.service;

import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface EmaillInfoService {

	public PageResults<EmaillInfo> queryPageEmaillInfo(EmaillInfo emaillInfo,
			PageResults<EmaillInfo> pageResults);
	
	
	public boolean saveEmaillInfo(EmaillInfo emaillInfo);

	public EmaillInfo queryEmaillCode(String toWhere);
	
	public boolean updateEmail(EmaillInfo emaillInfo);
	
	
	
	
}
