package com.jiuyi.jyplant.myCollection.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.myCollection.dao.CollectionInfoDao;
import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("collectionInfoDao")
public class CollectionInfoDaoImpl extends BaseDao<CollectionInfo, String>
		implements CollectionInfoDao {

	@Override
	@SuppressWarnings("rawtypes")
	public PageResults<CollectionInfo> queryPageCollectionInfo(
			CollectionInfo collectionInfo,
			PageResults<CollectionInfo> pageResults) {
		List<CollectionInfo> collectionInfos = new ArrayList<CollectionInfo>();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.ENGLISH);
		String coon = "";
		if(null!=collectionInfo &&  null != collectionInfo.getCollectPersonId()){
			coon+=" and a.collectPersonId = '"+collectionInfo.getCollectPersonId()+"'";
		}
		String sql = "SELECT collectId, b.memberName as  collectPersonId,collectTiem, "
				+ " c.t_productName as  collectProductId,collectShopId "
				+ " from t_collection a left join t_member b on a.collectPersonId = b.memberId"
				+ " left join t_product c on a.collectProductId = c.t_productId where 1=1 " + coon;
		
		String countHql = "select count(*) from t_collection a left join t_member b on a.collectPersonId = b.memberId"
				+ " left join t_product c on a.collectProductId = c.t_productId "
				+ " where 1=1 " + coon;
		
		PageResults<CollectionInfo> results = findPageByFetchedSql(sql, countHql, pageResults.getPageNo(), pageResults.getPageSize());
		List temp = results.getRows();
		for (int i = 0; i < temp.size(); i++) {
			CollectionInfo tempObject = new CollectionInfo();
			Object[] obj = (Object[]) temp.get(i);
			tempObject.setCollectId(obj[0]== null ?  "" : obj[0] + "");
			tempObject.setCollectPersonId(obj[1]==null ? "" :obj[1] + "");
			if(null!= obj[2]){
				tempObject.setCollectTiem(dateFormat.parse(obj[2] + ""));
			}
			tempObject.setCollectProductId(obj[3]==null ? "" :obj[3]+"");
			tempObject.setCollectShopId(obj[4]==null ? "" : obj[4]+"");
			collectionInfos.add(tempObject);
		}
		results.setRows(collectionInfos);
		return results;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
