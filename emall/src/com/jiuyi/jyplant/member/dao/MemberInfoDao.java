package com.jiuyi.jyplant.member.dao;

import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.IBaseDao;

public interface MemberInfoDao  extends IBaseDao<MemberInfo, String> {
	
	/**
	 * 分页查询会员信息
	 * @param memberInfo
	 * @param pageResults
	 * @return
	 */
	public PageResults<MemberInfo> queryPageMemberInfo(MemberInfo memberInfo,
			PageResults<MemberInfo> pageResults);
	
	/**
	 * 保存会员信息
	 * @param memberInfo
	 * @return
	 */
	public MemberInfo saveMemberInfo(MemberInfo memberInfo);
	
	
	public boolean updateMemberStatus(String memberIds, String enable);

	/**
	 * 校验重复信息
	 * @param memberInfo
	 * @return
	 */
	public boolean chechInfo(MemberInfo memberInfo);
	/**
	 * 保存会员信息
	 * @param memberInfo
	 * @return
	 */
	public MemberInfo updateMemberInfo(MemberInfo memberInfo);
	/**
	 * 根据会员名或邮箱查询会员信息
	 * @param memberName
	 * @param memberEmail
	 * @return
	 */
	public MemberInfo querySingleMemberInfo(String memberName);

}
