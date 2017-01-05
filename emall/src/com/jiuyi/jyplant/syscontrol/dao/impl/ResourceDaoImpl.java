package com.jiuyi.jyplant.syscontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.syscontrol.dao.ResourceDao;
import com.jiuyi.jyplant.syscontrol.dao.UserDao;
import com.jiuyi.jyplant.syscontrol.entity.Resources;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDao<Resources, String> implements
		ResourceDao {
	
	@Autowired
	private UserDao userDao;

	@Override
	 @SuppressWarnings("rawtypes")
	public List<Resources> queryResourceListById(String userId, String parentId) {
		//根据用户ID获取用户，判断是否为超级管理员
		Users user = userDao.get(userId);
		StringBuffer sbf = new StringBuffer();
		if(null!=user && user.getUserName().equals("Administrator")){
			//超级管理员加载系统所有权限，不需要做维护
			sbf.append(" select distinct a.id , a.text , a.parentId , a.resKey , a.type , a.resUrl , a.description , a.parentName");
			sbf.append(" from xt_resources a where 1=1 ");
			sbf.append(" and a.parentId = '"+parentId+"' and type='1'  order by a.text desc");
		}else{
			sbf.append(" select distinct a.id , a.text , a.parentId , a.resKey , a.type , a.resUrl , a.description , a.parentName");
			sbf.append(" from xt_resources a inner join xt_resources_role b");
			sbf.append(" on a.id = b.resc_id");
			sbf.append(" where b.role_id in (select c.role_id from xt_user_role c where c.user_id = '"+userId+"' )");
			sbf.append(" and a.parentId = '"+parentId+"' and type='1'  order by a.text desc");
		}
		
		List  resList =  this.getListBySQL(sbf.toString());
		 List<Resources> resources = new ArrayList<Resources>();
		 Resources temp = null;
		 for (int i = 0; i < resList.size(); i++) {
			Object[] obj = (Object[]) resList.get(i);
			temp = new Resources();
			temp.setId(obj[0]+"");
			temp.setText(obj[1]+"");
			temp.setParentId(obj[2]+"");
			temp.setResKey(obj[3]+"");
			temp.setType(obj[4]+"");
			temp.setResUrl(obj[5]+"");
			temp.setDescription(obj[6]+"");
			temp.setParentName(obj[7]+"");
			resources.add(temp);
		}
		return resources;
	}

	@Override
	public List<Resources> queryResourceListByNames(String userId, String names) {
		String hql_1 = "from Resources a where 1=1 and a.text='" + names + "'";
		System.out.println(this.getListByHQL(hql_1).size());
		Resources resources = (Resources) this.getListByHQL(hql_1).get(0);
		String hql_2 = "from Resources a where 1=1 and a.parentId='"
				+ resources.getId() + "'";
		return getListByHQL(hql_2);
	}

	@Override
	public List<Resources> getUserResources(String userId) {

		return null;
	}

	@Override
	public List<Resources> findAllResources() {
		String hql = " from Resources";
		return getListByHQL(hql);
	}

	@Override
	public PageResults<Resources> queryPageResources(Resources resources,
			PageResults<Resources> pageResults) {
		String coon = "";
		if (null != resources) {
			if (null != resources.getText() && !"".equals(resources.getText())) {
				coon += " and a.text like '%" + resources.getText().trim()
						+ "%'";
			}
			if (null != resources.getResKey()
					&& !"".equals(resources.getResKey())) {
				coon += " and a.resKey like '%" + resources.getResKey().trim()
						+ "%'";
			}
		}
		String hql = "from Resources a where 1=1 " + coon;
		String countHql = "select count(*) from Resources a where 1=1 " + coon;

		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),
				pageResults.getPageSize());
	}

	@Override
	public int queryResourcesCount(String hql) {
		return getListByHQL(hql).size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeVo> resourcesVos(String roleIds , String pid) {
		String hql = "from Resources a where 1=1 order by a.text asc";
		List<Resources> resources = this.getListByHQL(hql);
		List<TreeVo> treeVos = new ArrayList<TreeVo>();
		// 根据角色ID获取所拥有的资源
		String sqlSource = "select resc_id from xt_resources_role where role_id in("
				+ roleIds + ")";
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sqlSource);
		List<String> tempList = new ArrayList<String>();
		if (sqlQuery.list().size() > 0) {
			tempList = sqlQuery.list();
		}
		if (resources.size() > 0) {
			for (Resources r : resources) {
				TreeVo vo = new TreeVo();
				if ("1010".equals(r.getParentId())) {
					vo.setParent(true);
					vo.setpId(r.getParentId());
					vo.setMid(r.getId());
					vo.setName(r.getText());
					vo.setOpen(false);
					if (tempList.contains(r.getId())) {
						vo.setChecked(true);
					}
				} else {
					vo.setParent(false);
					vo.setpId(r.getParentId());
					vo.setMid(r.getId());
					vo.setName(r.getText());
					if (tempList.contains(r.getId())) {
						vo.setChecked(true);
					}
				}
				treeVos.add(vo);
			}
		}
		return treeVos;
	}

	@Override
	public boolean chechInfo(Resources resources) {
		String con = "";
		if (null != resources.getId()) {
			con += " and  a.id<> '" + resources.getId() + "'";
		}
		String hql_1 = "from Resources a where a.text = '" + resources.getText() + "'"
				+ con;
		String hql_2 = "from Resources a where  a.resKey ='" + resources.getResKey()
				+ "'" + con;
		Query query_1 = this.getSession().createQuery(hql_1);
		Query query_2 = this.getSession().createQuery(hql_2);
		if (query_1.list().size() > 0 && query_2.list().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteResources(String resourcesId) {
		try {
			// 删除资源
			String hql = "delete from Resources where id in(" + resourcesId + ")";
			// 删除角色资源
			String sql_2 = "delete from ResourcesRole  where  resc_id in ("+ resourcesId + ")";
			this.getSession().createQuery(hql).executeUpdate();
			this.getSession().createQuery(sql_2).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveResources(Resources resources) {
		try {
			saveOrUpdate(resources);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}