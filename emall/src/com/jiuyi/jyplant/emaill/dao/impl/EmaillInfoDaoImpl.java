package com.jiuyi.jyplant.emaill.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.emaill.dao.EmaillInfoDao;
import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;


@Repository("emaillInfoDao")
public class EmaillInfoDaoImpl extends BaseDao<EmaillInfo, String>  implements EmaillInfoDao{

	@Override
	public PageResults<EmaillInfo> queryPageEmaillInfo(EmaillInfo emaillInfo,
			PageResults<EmaillInfo> pageResults) {
		String coon = "";
		if (null != emaillInfo) {
			if (null != emaillInfo.getEmTitle() && !"".equals(emaillInfo.getEmTitle())) {
				coon += " and a.emTitle like '%" + emaillInfo.getEmTitle().trim()
						+ "%'";
			}
		}
		String hql = "from EmaillInfo a where 1=1 " + coon;
		String countHql = "select count(*) from EmaillInfo a where 1=1 " + coon;

		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),pageResults.getPageSize());
	}
	/**
	 * 
	 */
	@Override
	public boolean saveEmaillInfo(EmaillInfo emaillInfo) {
		try {
			if(null != emaillInfo && !"".equals(emaillInfo)){
				save(emaillInfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		return false;
	}
	
	
	@Override
	public EmaillInfo queryEmaillCode(String toWhere) {
		if(null != toWhere && !"".equals(toWhere)){
			String hql = "from EmaillInfo a where 1=1 and a.toWhere='"+toWhere.trim()+"'  order by emStimes desc ";
			if(getListByHQL(hql).size()>0){
				return getListByHQL(hql).get(0);
			}
		}
		return null;
	}
	
	@Override
	public boolean updateEmail(EmaillInfo emaillInfo) {
		try {
			update(emaillInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
