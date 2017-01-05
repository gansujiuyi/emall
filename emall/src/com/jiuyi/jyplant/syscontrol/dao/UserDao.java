package com.jiuyi.jyplant.syscontrol.dao;

import java.util.List;

import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface UserDao extends IBaseDao<Users, String> {

	public Users querySingleUser(String userName);

	public Users queryByUP(String userName, String uPassword);

	public PageResults<Users> queryPageUsers(Users users,
			PageResults<Users> pageResults);

	public int queryUsersCount(String hql);

	public List<TreeVo> userVos(String roleIds);
	
	public boolean updateUserStatus(String userIds , String status);
	
	public void upUserPassword(String userIds,  String newPwd);
	

}
