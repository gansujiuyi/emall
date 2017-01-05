package com.jiuyi.jyplant.product.service;

import java.util.List;

import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.utils.PageResults;


public interface ProductInfoService {
	/**
	 * 分页查询所有商品信息
	 * @param pageResults
	 * @param productInfo
	 * @return
	 */
	public PageResults<ProductInfo> queryPageProducts(PageResults<ProductInfo> pageResults,ProductInfo productInfo) ;
	/**
	 * 
	 * @param pageResults
	 * @param productInfo
	 * @return
	 */
	public List<ProductInfo> queryProduct(String storeId) ;
	/**
	 * 保存商品信息
	 * @param productInfo
	 * @return
	 */
	public boolean savaProductInfo(ProductInfo productInfo);
	
	/**
	 * 检查商品信息是否重复
	 */
	public boolean chechInfo(ProductInfo productInfo) ;
	/**
	 * 根据id查询商品信息
	 * @param productInfo
	 * @return
	 */
	public ProductInfo queryById(ProductInfo productInfo);
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
}
