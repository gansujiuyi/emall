package com.jiuyi.jyplant.syscontrol.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.syscontrol.dao.ResourceDao;
import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.service.ResourcesService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

@Service("resourcesService")
@Transactional
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	private ResourceDao resourceDao;

	@Override
	public List<Resources> queryResourceListById(String userId, String parentId) {
		List<Resources> rootResources = resourceDao.queryResourceListById(
				userId, parentId);
		return rootResources;
	}

	@Override
	public List<Resources> queryResourceListByNames(String userId, String names) {
		List<Resources> rootResources = resourceDao.queryResourceListByNames(
				userId, names);
		return rootResources;
	}

	@Override
	public PageResults<Resources> queryPageResources(Resources resources,
			PageResults<Resources> pageResults) {

		return resourceDao.queryPageResources(resources, pageResults);
	}

	@Override
	public List<TreeVo> resourcesVos(String roleIds , String pid) {
		return resourceDao.resourcesVos(roleIds , pid);
	}

	@Override
	public boolean chechInfo(Resources resources) {
		 
		return resourceDao.chechInfo(resources);
	}

	@Override
	public boolean deleteResources(String resourcesId) {
		// TODO Auto-generated method stub
		return resourceDao.deleteResources(resourcesId);
	}

	@Override
	public boolean saveResources(Resources resources) {
		// TODO Auto-generated method stub
		return resourceDao.saveResources(resources);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Resources> getUserResources(String userId) {
		 StringBuffer sbf = new StringBuffer();
		 sbf.append("select distinct   a.id , a.text , a.parentId , a.resKey , a.resUrl , a.description , a.parentName from xt_resources a ");
		 sbf.append(" inner join xt_resources_role b on a.id = b.resc_id ");
		 sbf.append(" inner join xt_user_role c on b.role_id = c.role_id ");
		 sbf.append(" where c.user_id = '"+userId+"'");
		List tList = resourceDao.getListBySQL(sbf.toString());
		List<Resources> resources = null;
		if(null!=tList && tList.size()>0){
			 Resources temp = null;
			 resources = new ArrayList<Resources>();
			for (int i = 0; i <tList.size(); i++) {
				Object[] obj = (Object[]) tList.get(i);
				temp = new Resources();
				temp.setId(obj[0]+"");
				temp.setText(obj[1]+"");
				temp.setParentId(obj[2]+"");
				temp.setResKey(obj[3]+"");
				temp.setResUrl(obj[4]+"");
				temp.setDescription(obj[5]+"");
				temp.setParentName(obj[6]+"");
				resources.add(temp);
			}
		}
		return resources;
	}

	@Override
	public List<Resources> findAllResources() {
		 String hql="from Resources";
		return resourceDao.getListByHQL(hql);
	}
}
