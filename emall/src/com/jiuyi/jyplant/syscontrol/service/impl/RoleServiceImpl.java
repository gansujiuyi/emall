package com.jiuyi.jyplant.syscontrol.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.syscontrol.dao.RoleDao;
import com.jiuyi.jyplant.syscontrol.entity.Roles;
import com.jiuyi.jyplant.syscontrol.service.RoleService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public PageResults<Roles> queryPageRoles(Roles roles,
			PageResults<Roles> pageResults) {
		return roleDao.queryPageRoles(roles, pageResults);
	}

	@Override
	public boolean saveRole(Roles roles) {
		return roleDao.saveRole(roles);
	}

	@Override
	public Roles queryRoleById(Roles roles) {

		return roleDao.queryRoleById(roles);
	}

	@Override
	public boolean deleteRole(String roldIs) {
		return roleDao.deleteRole(roldIs);
	}

	@Override
	public boolean chechInfo(Roles roles) {
		return roleDao.chechInfo(roles);
	}

	@Override
	public boolean restRole(String roldIs, String enable) {

		return roleDao.restRole(roldIs, enable);
	}

	@Override
	public List<TreeVo> rolesVos(String userId) {
		return roleDao.roleVos(userId);
	}

	@Override
	public boolean saveUserResourceByRole(String resourceIds,String userIds , String roleIds_ , String optType) {
		return roleDao.saveUserResourceByRole(resourceIds,userIds, roleIds_ ,optType);
	}

}
