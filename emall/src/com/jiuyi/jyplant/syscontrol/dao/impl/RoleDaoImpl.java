package com.jiuyi.jyplant.syscontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.syscontrol.dao.RoleDao;
import com.jiuyi.jyplant.syscontrol.entity.Roles;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseDao<Roles, String> implements RoleDao {

	@Override
	public int queryRolesCount(String hql) {

		// return findList(hql).size();
		return 0;
	}

	@Override
	public PageResults<Roles> queryPageRoles(Roles roles,
			PageResults<Roles> pageResults) {
		String con = "";
		if (null != roles) {
			if (null != roles.getName() && !"".equals(roles.getName())) {
				con += " and s.name like '%" + roles.getName().trim() + "%'";
			}
			if (null != roles.getRoleKey() && !"".equals(roles.getRoleKey())) {
				con += " and s.roleKey like '%" + roles.getRoleKey().trim()
						+ "%'";
			}
		}
		String hql = "from Roles s where 1=1 " + con;
		String countHql = "select count(*) from Roles s where 1=1 " + con;
		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),
				pageResults.getPageSize());
	}

	@Override
	public boolean saveRole(Roles roles) {
		try {
			saveOrUpdate(roles);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Roles queryRoleById(Roles roles) {
		return get(roles.getId());
	}

	@Override
	public boolean deleteRole(String roldIs) {
		try {
			// 删除角色
			String hql = "delete from Roles where id in(" + roldIs + ")";
			// 删除用户角色
			String sql_1 = "delete from UsersRole   where  role_id in ("
					+ roldIs + ")";
			// 删除角色资源
			String sql_2 = "delete from ResourcesRole  where  role_id in ("
					+ roldIs + ")";
			this.getSession().createQuery(hql).executeUpdate();
			this.getSession().createQuery(sql_1).executeUpdate();
			this.getSession().createQuery(sql_2).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean chechInfo(Roles roles) {
		String con = "";
		if (null != roles.getId()) {
			con += " and  a.id<> '" + roles.getId() + "'";
		}
		String hql_1 = "from Roles a where a.name = '" + roles.getName() + "'"
				+ con;
		String hql_2 = "from Roles a where  a.roleKey ='" + roles.getRoleKey()
				+ "'" + con;
		Query query_1 = this.getSession().createQuery(hql_1);
		Query query_2 = this.getSession().createQuery(hql_2);
		if (query_1.list().size() > 0 && query_2.list().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean restRole(String roldIs, String enable) {
		try {
			String hql = "update Roles set enable='" + enable
					+ "' where id in(" + roldIs + ")";
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeVo> roleVos(String userId) {

		String hql = "from Roles a where a.enable<>0";
		List<Roles> roles = this.getListByHQL(hql);
		// 根据角色ID获取所拥有的用户
		String sqlSource = "select role_id from xt_user_role where user_id in("
				+ userId + ")";
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sqlSource);
		List<String> tempList = new ArrayList<String>();
		if (sqlQuery.list().size() > 0) {
			tempList = sqlQuery.list();
		}
		List<TreeVo> treeVos = new ArrayList<TreeVo>();
		TreeVo tempVo = new TreeVo();
		tempVo.setpId("0");
		tempVo.setMid("-1");
		tempVo.setName("角色信息");
		tempVo.setParent(true);
		tempVo.setOpen(false);
		treeVos.add(tempVo);
		if (roles.size() > 0) {
			for (Roles u : roles) {
				TreeVo vo = new TreeVo();
				vo.setpId("-1");
				vo.setMid(u.getId());
				vo.setName(u.getName());
				tempVo.setParent(false);
				tempVo.setOpen(false);
				treeVos.add(vo);
				if (tempList.contains(u.getId())) {
					vo.setChecked(true);
				}
			}
		}
		return treeVos;
	}

	@Override
	public boolean saveUserResourceByRole(String resourceIds, String userIds,
			String roleIds_, String optType) {
		String resources[] = resourceIds.split(",");
		String roleId[] = roleIds_.split(",");
		String userId[] = userIds.split(",");
		try {
			// 先删除当前角色下的所有角色资源

			if ("userRole".equals(optType)) {
				// 先删除当前角色下的所有用户
				String del_1 = "delete from xt_user_role where  user_id in( "+userIds+")";
				this.getSession().createSQLQuery(del_1).executeUpdate();
			}
			if ("resourceRole".equals(optType)) {
				   // 先删除当前角色下的所有角色资源
					String del_1 = "delete from xt_resources_role where  role_id in( "+roleIds_+")";
					this.getSession().createSQLQuery(del_1).executeUpdate();
				
			}
			for (int i = 0; i < roleId.length; i++) {
				if ("'-1'".equals(roleId[i]) && !"".equals(roleId[i])) {
					continue;
				}
				for (int j = 0; j < userId.length; j++) {
					if ("'-1'".equals(userId[j])) {
						continue;
					}
					if (!"".equals(userId[j]) && !"".equals(roleId[i])) {
						String sql_1 = "insert into  xt_user_role (user_id , role_id) values("+ userId[j] + " ," + roleId[i] + ")";
						this.getSession().createSQLQuery(sql_1).executeUpdate();
					}
				}
				for (int k = 0; k < resources.length; k++) {
					if (null != resources[k] && !"".equals(resources[k])) {
						String sql_2 = "insert into  xt_resources_role (resc_id , role_id) values("+ resources[k] + " ," + roleId[i] + ")";
						this.getSession().createSQLQuery(sql_2).executeUpdate();
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
