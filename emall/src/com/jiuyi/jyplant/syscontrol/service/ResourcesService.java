package com.jiuyi.jyplant.syscontrol.service;

import java.util.List;

import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

public interface ResourcesService {

	public List<Resources> queryResourceListById(String userId, String parentId);

	public List<Resources> queryResourceListByNames(String userId, String names);

	public PageResults<Resources> queryPageResources(Resources resources,
			PageResults<Resources> pageResults);

	public List<TreeVo> resourcesVos(String roleIds , String pid);

	public boolean chechInfo(Resources resources);
	
	public boolean deleteResources(String resourcesId);
	
	public boolean saveResources(Resources resources);
	
	public List<Resources> getUserResources(String userId);
	
	public List<Resources> findAllResources();

}
