package com.jiuyi.jyplant.member.service.impl;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.member.dao.MemberInfoDao;
import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.member.service.MemberInfoService;
import com.jiuyi.jyplant.utils.ConfigManager;
import com.jiuyi.jyplant.utils.MD5;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.SendEmail;

@Service("memberInfoService")
@Transactional
public class MemberInfoServiceImpl implements MemberInfoService {

	Logger log = Logger.getLogger(MemberInfoServiceImpl.class);

	@Autowired
	private MemberInfoDao memberInfoDao;

	@Override
	public PageResults<MemberInfo> queryPageMemberInfo(MemberInfo memberInfo,
			PageResults<MemberInfo> pageResults) {
		log.info("开始查询会员信息");
		return memberInfoDao.queryPageMemberInfo(memberInfo, pageResults);
	}

	@Override
	public MemberInfo saveMemberInfo(MemberInfo memberInfo,String content) {
		Calendar c = Calendar.getInstance();
		memberInfo.setValidateCode(MD5.encode2hex(c.getTime()+memberInfo.getMemberEmail()+memberInfo.getMpassWord()));
		SendEmail.send(memberInfo.getMemberEmail(), content);
		log.info("邮箱注册发送邮件成功!,发送地址:" + memberInfo.getMemberEmail());
		return memberInfoDao.saveMemberInfo(memberInfo);
	}

	/**
	 * 根据会员名查询会员信息
	 * 
	 * @param memberName
	 * @return
	 */
	@Override 
	public MemberInfo querySingleMemberInfo(String memberName) {
		return memberInfoDao.querySingleMemberInfo(memberName);
	}

	/**
	 * 校验重复信息
	 */
	@Override
	public boolean checkInfo(MemberInfo memberInfo) {
		return memberInfoDao.chechInfo(memberInfo);
	}

	@Override
	public boolean updateMemberStatus(String memberIds, String enable) {
		return memberInfoDao.updateMemberStatus(memberIds, enable);
	}

	@Override
	public String processActivate(String email, String validateCode) {
		MemberInfo memberInfo = memberInfoDao.getByHQL("from MemberInfo a where a. memberEmail= '" + email + "'");
		try {
			// 验证用户是否存在
			if (null != memberInfo) {
				// 验证用户激活状态
				if (memberInfo.getMemberStatus().equals("2")) {
					// /没激活
					Date currentTime = new Date();// 获取当前时间
					// 验证链接是否过期
					currentTime.before(memberInfo.getMemberRegTime());
					if (currentTime.before(memberInfo.getLastActivateTime())) {
						// 验证激活码是否正确
						if (validateCode.equals(memberInfo.getValidateCode())) {
							memberInfo.setMemberStatus("1");
							memberInfoDao.update(memberInfo);
							log.info("激活成功");
							return "激活成功";
						} else {
							log.info("激活码不正确");
							return "激活码不正确";
						}
					} else {
						log.info("激活码已过期");
						return "激活码已过期";
					}
				} else {
					log.info("邮箱已激活，请登录");
					return "邮箱已激活，请登录";
				}
			} else {
				log.info("该邮箱未注册(邮箱地址不存在)");
				return "该邮箱未注册(邮箱地址不存在)";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "请求错误";
		}
	}

	@Override
	public boolean processregister(MemberInfo memberInfo) {
		Calendar c = Calendar.getInstance();
		memberInfo.setValidateCode(MD5.encode2hex(c.getTime()+memberInfo.getMemberEmail()+memberInfo.getMpassWord()));
		try {
			memberInfoDao.save(memberInfo);// 保存注册信息
			// /邮件的内容
			String serverUrl = ConfigManager.getString("serverUrl",
					"http://localhost:8080");
			StringBuffer sb = new StringBuffer(
					"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
			sb.append("<a href=\""
					+ serverUrl
					+ "/emall/memberInfo/member/memberOpt?action=activate&email=");
			sb.append(memberInfo.getMemberEmail());
			sb.append("&validateCode=");
			sb.append(memberInfo.getValidateCode());
			sb.append("\">http://"
					+ serverUrl
					+ "/emall/memberInfo/member/memberOpt?action=activate&email=");
			sb.append(memberInfo.getMemberEmail());
			sb.append("&validateCode=");
			sb.append(memberInfo.getValidateCode());
			sb.append("</a>");
			SendEmail.send(memberInfo.getMemberEmail(), sb.toString());
			log.info("邮箱注册发送邮件成功!,发送地址:" + memberInfo.getMemberEmail());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public MemberInfo updateMemberInfo(MemberInfo memberInfo) {
		return memberInfoDao.updateMemberInfo(memberInfo);
	}
}
