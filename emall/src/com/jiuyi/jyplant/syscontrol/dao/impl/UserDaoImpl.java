package com.jiuyi.jyplant.syscontrol.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.syscontrol.dao.UserDao;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.MD5;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<Users, String> implements UserDao {

	@Override
	public Users querySingleUser(String userName) {
		// return findUniqueBy("userName", userName);
		return null;
	}

	@Override
	public Users queryByUP(String userName, String uPassword) {
		//密码进行3desmd5加密
		uPassword = MD5.HPEncode(uPassword, "GBK");
		String hql = " from  Users a  where (a.userName='" + userName + "' or a.userPhone='"+userName+"' or a.userMail = '"+userName+"' ) and a.userPassword='" + uPassword + "'";
		List<Users> users = getListByHQL(hql);
		if (null != users && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public PageResults<Users> queryPageUsers(Users users,
			PageResults<Users> pageResults) {
		String cond = "";
		if (null != users) {
			if (null != users.getUserName() && !"".equals(users.getUserName())) {
				cond += " and u1.userName like  '%"
						+ users.getUserName().trim() + "%'";
			}
			if (null != users.getUserPhone()
					&& !"".equals(users.getUserPhone())) {
				cond += " and u1.userPhone like   '%"
						+ users.getUserPhone().trim() + "%'";
			}
			if (null != users.getUserMail() && !"".equals(users.getUserMail())) {
				cond += " and u1.userMail    like  '%"
						+ users.getUserMail().trim() + "&'";
			}
		}
		String hql = "from Users u1 where 1=1 " + cond;
		String countHql = "select count(*) from Users u1 where 1=1 " + cond;

		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),
				pageResults.getPageSize());
	}

	@Override
	public int queryUsersCount(String hql) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeVo> userVos(String roleIds) {
		String hql = "from Users a where a.status<>0";
		List<Users> users = this.getListByHQL(hql);
		// 根据角色ID获取所拥有的用户
		String sqlSource = "select user_id from xt_user_role where role_id in("
				+ roleIds + ")";
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sqlSource);
		List<String> tempList = new ArrayList<String>();
		if (sqlQuery.list().size() > 0) {
			tempList = sqlQuery.list();
		}
		List<TreeVo> treeVos = new ArrayList<TreeVo>();
		TreeVo tempVo = new TreeVo();
		tempVo.setpId("0");
		tempVo.setMid("-1");
		tempVo.setName("用户信息");
		tempVo.setParent(true);
		tempVo.setOpen(false);
		treeVos.add(tempVo);
		if (users.size() > 0) {
			for (Users u : users) {
				TreeVo vo = new TreeVo();
				vo.setpId("-1");
				vo.setMid(u.getUserId());
				vo.setName(u.getUserName());
				tempVo.setParent(false);
				tempVo.setOpen(false);
				treeVos.add(vo);
				if (tempList.contains(u.getUserId())) {
					vo.setChecked(true);
				}
			}
		}
		return treeVos;
	}

	@Override
	public boolean updateUserStatus(String userIds, String status) {

		try {
			String hql = "update Users set ustatus='" + status.trim() + "' where userId in(" + userIds + ")";
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void upUserPassword(String userIds, String newPwd) {
			newPwd =MD5.HPEncode(newPwd, "GBK");
			String hql = "update Users set userPassword='" + newPwd.trim() + "' where userId ='" + userIds + "' ";
			this.getSession().createQuery(hql).executeUpdate();
	}
}
