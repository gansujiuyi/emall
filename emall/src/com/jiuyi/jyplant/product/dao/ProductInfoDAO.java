package com.jiuyi.jyplant.product.dao;

import java.util.List;

import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface ProductInfoDAO {
	/**
	 * 分页查询商品信息 dao层
	 * @param pageResults
	 * @param productInfo
	 * @return
	 */
	public PageResults<ProductInfo> queryPageProductInfos(PageResults<ProductInfo> pageResults,ProductInfo productInfo);
	/**
	 * 保存商品信息 dao层
	 * @param productInfo
	 * @return
	 */
	public boolean saveProducInfo(ProductInfo productInfo);
	/**
	 * 校验商品信息是否重复
	 * @param productInfo
	 * @return
	 */
	public boolean chechInfo(ProductInfo productInfo);
	/**
	 * 根据id查询商品信息
	 * @param productInfo
	 * @return
	 */
	public ProductInfo queryProductInfoById(ProductInfo productInfo);
	/**
	 * 根据id删除商品信息
	 * @param productId
	 * @return
	 */
	public boolean deleteProductInfo(String productId);
	/**
	 * 商品上架||商品下架
	 * @param t_productId
	 * @param t_checkStatus
	 * @return
	 */
	public boolean onSellOrOffSell(String t_productId, String t_checkStatus);
	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public List<ProductInfo> queryProduct(String storeId);
	
	
	
	
}
