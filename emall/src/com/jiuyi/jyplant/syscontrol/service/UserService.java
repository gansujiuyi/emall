package com.jiuyi.jyplant.syscontrol.service;

import java.util.List;

import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;

public interface UserService {

	public Users queryByUP(String userName, String uPassword);

	public PageResults<Users> queryPageUsers(Users users,
			PageResults<Users> pageResults);
	
	public List<TreeVo> userVos(String roleIds);
	
	public boolean updateUserStatus(String userIds , String status);
	
	public Users querySingleUser(String userName);
	
	public List<Users> findAll();
	
	public String upUserPassword(String userIds , String oldPwd,String newPwd);
}
