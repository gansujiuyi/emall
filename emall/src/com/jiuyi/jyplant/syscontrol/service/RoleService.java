package com.jiuyi.jyplant.syscontrol.service;

import java.util.List;

import com.jiuyi.jyplant.syscontrol.entity.Roles;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

public interface RoleService {

	public PageResults<Roles> queryPageRoles(Roles roles,
			PageResults<Roles> results);
	
	
	public boolean saveRole(Roles roles);
	
	public Roles queryRoleById(Roles roles);
	
	public boolean deleteRole(String roldIs);
	
	public boolean chechInfo(Roles roles);
	
	public boolean restRole(String roldIs , String enable);
	
	public List<TreeVo> rolesVos(String userId);
	
	public boolean saveUserResourceByRole(String resourceIds , String userIds ,String roleIds_ , String optType);
}
