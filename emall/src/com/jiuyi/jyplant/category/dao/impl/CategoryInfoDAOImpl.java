package com.jiuyi.jyplant.category.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.category.dao.CategoryInfoDAO;
import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

@Repository("CategoryInfoDAO")
@SuppressWarnings("rawtypes")
public class CategoryInfoDAOImpl extends BaseDao<CategoryInfo, String>
		implements CategoryInfoDAO {
	/**
	 * 分页查询商品分类信息
	 */
	@Override
	public PageResults<CategoryInfo> queryPageCategoryInfos(
			PageResults<CategoryInfo> pageResults, CategoryInfo catrgoryInfo) {
		String con = "";
		if (null != catrgoryInfo) {
			if (null != catrgoryInfo.getT_categoryName()
					&& !"".equals(catrgoryInfo.getT_categoryName())) {
				con += "and a.t_categoryName like '%"
						+ catrgoryInfo.getT_categoryName().trim() + "%'";
			}
		}
		String sql = "select a.t_categoryId , a.t_categoryName , (select b.t_categoryName  from t_category b where b.t_categoryId = a.t_categoryType) as"
				+ "categoryType , a.t_checkStatus , a.t_desc    from t_category a where 1=1 "
				+ con;
		String countSql = "select count(1) from t_category a where 1=1 " + con;
		return findPageByFetchedSql(sql, countSql, pageResults.getPageNo(),
				pageResults.getPageSize());
	}

	/**
	 * 保存商品分类信息
	 */
	@Override
	public boolean saveCategoryInfo(CategoryInfo categoryInfo) {
		try {
			saveOrUpdate(categoryInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 根据id查询商品分类信息
	 */
	@Override
	public CategoryInfo queryById(CategoryInfo categoryInfo) {
		if (null != categoryInfo && !"".equals(categoryInfo)) {
			return get(categoryInfo.getT_categoryId());
		}
		return null;
	}
	
	/**
	 * 查询全部商品分类信息 实现
	 */
	@Override
	public List<CategoryInfo> queryAllCategoryInfo() {
		List<CategoryInfo> tempList = new ArrayList<CategoryInfo>();
		String sql = "select a.t_categoryId ,a.t_categoryName ,(select b.t_categoryName   from "
				+ "  t_category b   where  b.t_categoryId = a.t_categoryType) ascategoryType , "
				+ "  a.t_checkStatus ,  a.t_desc    from t_category a  where 1=1 ";
		List list = getListBySQL(sql);
		if(null!=list && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				CategoryInfo tempObj = new CategoryInfo();
				Object[] obj =(Object[]) list.get(i);
				tempObj.setT_categoryId(obj[0]==null ? "" :obj[0]+"");
				tempObj.setT_categoryName(obj[1]== null ? "" :obj[1]+"");
				tempObj.setT_categoryType(obj[2] == null ? "" :obj[2]+"");
				tempObj.setT_checkStatus(obj[3] == null ? "" : obj[3]+"");
				tempObj.setT_desc(obj[4] ==null ? "" : obj[4]+"");
				tempList.add(tempObj);
			}
		}
		return tempList;

	}

	/**
	 * 查询全部商品分类信息 实现
	 */
	@Override
	public List<CategoryInfo> queryAllCategoryInfoByCategoryId(String categoryId) {
		List<CategoryInfo> tempList = new ArrayList<CategoryInfo>();
		String sql = "select a.t_categoryId ,a.t_categoryName ,(select b.t_categoryName   from "
				+ "  t_category b   where  b.t_categoryId = a.t_categoryType) ascategoryType , "
				+ "  a.t_checkStatus ,  a.t_desc    from t_category a  where 1=1 ";
		if(null== categoryId || "".equals(categoryId)){
			sql+=" and a.t_categoryType ='0'";
		}else{
			sql+=" and a.t_categoryType ='"+categoryId+"'";
		}
		List list = getListBySQL(sql);
		if(null!=list && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				CategoryInfo tempObj = new CategoryInfo();
				Object[] obj =(Object[]) list.get(i);
				tempObj.setT_categoryId(obj[0]==null ? "" :obj[0]+"");
				tempObj.setT_categoryName(obj[1]== null ? "" :obj[1]+"");
				tempObj.setT_categoryType(obj[2] == null ? "" :obj[2]+"");
				tempObj.setT_checkStatus(obj[3] == null ? "" : obj[3]+"");
				tempObj.setT_desc(obj[4] ==null ? "" : obj[4]+"");
				tempList.add(tempObj);
			}
		}
		return tempList;

	}

	/**
	 * 检查
	 */
	@Override
	public boolean chechInfo(CategoryInfo catrgoryInfo) {
		String hql = "from CategoryInfo a where a.t_categoryName = '"
				+ catrgoryInfo.getT_categoryName() + "'";
		if (null != catrgoryInfo.getT_categoryId()) {
			hql += " and  a.t_categoryId<> '" + catrgoryInfo.getT_categoryId()
					+ "'";
		}
		Query query = this.getSession().createQuery(hql);
		if (query.list().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除商品分类信息 实现
	 */
	@Override
	public boolean deleteCategoryInfo(String categoryId) {
		try {
			// 删除角色
			// String
			// hql="delete from CategoryInfo where t_categoryId in("+categoryId+")";
			// this.getSession().createQuery(hql).executeUpdate();
			String[] categoryId_ = categoryId.split(",");
			for (int i = 0; i < categoryId_.length; i++) {
				this.deleteById(categoryId_[i]);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 启/停用
	 */
	@Override
	public boolean updateCategoryInfoStatus(String t_categoryId, String t_checkStatus) {
		try {
			String hql = "update CategoryInfo set t_checkStatus='" + t_checkStatus.trim() + "' where t_categoryId in(" + t_categoryId + ")";
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
