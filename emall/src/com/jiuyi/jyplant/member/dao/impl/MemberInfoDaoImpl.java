package com.jiuyi.jyplant.member.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.member.dao.MemberInfoDao;
import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;


@Repository("memberInfoDao")
public class MemberInfoDaoImpl extends BaseDao<MemberInfo, String> implements MemberInfoDao{
	/**
	 * 分页查询会员信息
	 */
	@Override
	public PageResults<MemberInfo> queryPageMemberInfo(MemberInfo memberInfo,
			PageResults<MemberInfo> pageResults) {
		String coon = "";
		if (null != memberInfo) {
			if (null != memberInfo.getMemberName() && !"".equals(memberInfo.getMemberName())) {
				coon += " and a.emTitle like '%" + memberInfo.getMemberName().trim()
						+ "%'";
			}
		}
		String hql = "from MemberInfo a where 1=1 " + coon;
		String countHql = "select count(*) from MemberInfo a where 1=1 " + coon;

		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),pageResults.getPageSize());
	}
	/**
	 * 保存会员信息
	 */
	@Override
	public MemberInfo saveMemberInfo(MemberInfo memberInfo) {
		 try {
			this.save(memberInfo);
			return this.get(memberInfo.getMemberId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
		
	}
	/**
	 * 校验重复信息
	 */
	@Override
	public boolean chechInfo(MemberInfo memberInfo) {
		String con = "";
		if (null != memberInfo.getMemberId()) {
			con += " and  a.memberId<> '" + memberInfo.getMemberId() + "'";
		}
		String hql_1 = "from MemberInfo a where a.memberName = '" + memberInfo.getMemberName() + "' or a.memberEmail ='" + memberInfo.getMemberEmail()+"'  "
				+ con;
		Query query_1 = this.getSession().createQuery(hql_1);
		if (query_1.list().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMemberStatus(String memberIds, String enable) {
	 
		try {
			String hql = "update MemberInfo set memberStatus='" + enable
					+ "' where memberId in(" + memberIds + ")";
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 保存会员信息
	 */
	@Override
	public MemberInfo updateMemberInfo(MemberInfo memberInfo) {
		if(null != memberInfo && !"".equals(memberInfo)){
			try {
				update(memberInfo);
				return get(memberInfo.getMemberId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 根据会员名或邮箱查询会员信息
	 */
	@Override
	public MemberInfo querySingleMemberInfo(String memberName) {
		String hql = "from MemberInfo where memberName = '"
	+ memberName + "' or memberEmail='"+memberName+"' or memberId='"+memberName+"'";
		return getByHQL(hql);
	}
}