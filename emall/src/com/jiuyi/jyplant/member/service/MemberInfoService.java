package com.jiuyi.jyplant.member.service;

import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface MemberInfoService {
	/**
	 * 分页查询会员信息
	 * 
	 * @param memberInfo
	 * @param pageResults
	 * @return
	 */
	public PageResults<MemberInfo> queryPageMemberInfo(MemberInfo memberInfo,
			PageResults<MemberInfo> pageResults);

	/**
	 * 保存会员信息
	 * 
	 * @param memberInfo
	 * @return
	 */
	public MemberInfo saveMemberInfo(MemberInfo memberInfo,String content);

	/**
	 * 根据会员名或邮箱查询会员信息
	 * 
	 * @param memberName
	 * @return
	 */
	public MemberInfo querySingleMemberInfo(String memberName);

	/**
	 * 校验重复信息
	 * 
	 * @param memberInfo
	 * @return
	 */
	public boolean checkInfo(MemberInfo memberInfo);

	/**
	 * 启|禁用会员
	 * 
	 * @param roleIds
	 * @return
	 */
	public boolean updateMemberStatus(String memberIds, String enable);

	/***
	 * 会员激活
	 */
	public String processActivate(String email, String validateCode);

	/***
	 * 邮箱注册
	 */
	public boolean processregister(MemberInfo memberInfo);

	/**
	 * 修改会员
	 * 
	 * @param info
	 * @return
	 */
	public MemberInfo updateMemberInfo(MemberInfo info);

}
