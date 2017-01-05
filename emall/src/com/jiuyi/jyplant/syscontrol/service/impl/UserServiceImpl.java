package com.jiuyi.jyplant.syscontrol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiuyi.jyplant.syscontrol.dao.UserDao;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.UserService;
import com.jiuyi.jyplant.syscontrol.vo.TreeVo;
import com.jiuyi.jyplant.utils.MD5;
import com.jiuyi.jyplant.utils.PageResults;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Users queryByUP(String userName, String uPassword) {
		return userDao.queryByUP(userName, uPassword);
	}

	@Override
	public PageResults<Users> queryPageUsers(Users users,
			PageResults<Users> pageResults) {

		return userDao.queryPageUsers(users, pageResults);
	}

	@Override
	public List<TreeVo> userVos(String roleIds) {
		return userDao.userVos(roleIds);
	}

	@Override
	public boolean updateUserStatus(String userIds, String status) {

		return userDao.updateUserStatus(userIds, status);
	}

	@Override
	public Users querySingleUser(String userName) {

		return userDao.getByHQL("from Users where userName = '" + userName
				+ "'");
	}

	@Override
	public List<Users> findAll() {

		return userDao.getListByHQL(" from Users");
	}

	@Override
	public String upUserPassword(String userIds, String oldPwd , String newPwd) {
		try {
			Users u = userDao.get(userIds);
			if (null != u) {
				oldPwd = MD5.HPEncode(oldPwd, "GBK");
				if (u.getUserPassword().equals(oldPwd)) {
					userDao.upUserPassword(userIds, newPwd);
					return "0";
				}
				return "1";
			}
		} catch (Exception e) {
			return "2";
		}
		return "2";
	}
}
