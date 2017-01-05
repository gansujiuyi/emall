package com.jiuyi.jyplant.product.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.product.dao.ProductInfoDAO;
import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;

/**
 * 商品信息 dao实现
 * 
 * @author lyn
 *
 */
@Repository("ProductInfoDAO")
public class ProductInfoDAOImpl extends BaseDao<ProductInfo, String> implements ProductInfoDAO {
	/**
	 * 分页查询商品信息 dao层实现
	 */
	@Override
	public PageResults<ProductInfo> queryPageProductInfos(PageResults<ProductInfo> pageResults,
			ProductInfo productInfo) {
		String con = "";
//		if (null != productInfo) {
//			if (null != productInfo.getT_productName() && !"".equals(productInfo.getT_productName())) {
//				con += "and a.t_productName like '%" + productInfo.getT_productName().trim() + "%'";
//			}
//		}
//		String sql = "select a.t_productId, a.t_productName,a.t_purchasePrice,a.t_discountPrice,a.t_productNum,a.t_origin,a.t_categoryType, a.t_checkStatus , a.t_desc  from t_product a where 1=1"+ con;
//		String countSql = "select count(1) from t_product a where 1=1 " + con;
//		return findPageByFetchedSql(sql, countSql, pageResults.getPageNo(), pageResults.getPageSize());
		if (null != productInfo) {
			if (null != productInfo.getT_productName() && !"".equals(productInfo.getT_productName() )) {
				con += " and s.name like '%" + productInfo.getT_productName() .trim() + "%'";
			}
		}
		String hql = "from ProductInfo s where 1=1 " + con;
		String countHql = "select count(1) from ProductInfo s where 1=1 " + con;
		return findPageByFetchedHql(hql, countHql, pageResults.getPageNo(),pageResults.getPageSize());
	}
	/**
	 * 保存商品信息 dao层实现
	 */
	@Override
	public boolean saveProducInfo(ProductInfo productInfo) {
		try {
			saveOrUpdate(productInfo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * 校验商品信息是否重复
	 */
	@Override
	public boolean chechInfo(ProductInfo productInfo) {
		String hql = "from ProductInfo a where a.t_productName = '"
				+ productInfo.getT_productName()+ "'";
		if (null != productInfo.getT_productId()) {
			hql += " and  a.t_productId<> '" + productInfo.getT_productId()
					+ "'";
		}
		Query query = this.getSession().createQuery(hql);
		if (query.list().size() > 0) {
			return true;
		}
		return false;
	}
	/**
	 * 根据id查询商品信息
	 */
	@Override
	public ProductInfo queryProductInfoById(ProductInfo productInfo) {
		if (null != productInfo && !"".equals(productInfo)) {
			return get(productInfo.getT_productId());
		}
		return null;
	}
	/**
	 * 根据id删除商品信息
	 */
	@Override
	public boolean deleteProductInfo(String productId) {
		try {
			String[] productId_ = productId.split(",");
			for (int i = 0; i < productId_.length; i++) {
				this.deleteById(productId_[i]);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 商品上架||商品下架
	 */
	@Override
	public boolean onSellOrOffSell(String t_productId, String t_checkStatus) {
		try {
			String hql = "update ProductInfo set t_checkStatus='" + t_checkStatus.trim() + "' where t_productId in(" + t_productId + ")";
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<ProductInfo> queryProduct(String storeId) {
		if(null != storeId && !"".equals(storeId)){
			String hql = "from ProductInfo a where a.storeId = '"+storeId+"'";
			return getListByHQL(hql);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
