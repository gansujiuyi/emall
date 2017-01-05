package com.jiuyi.jyplant.product.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.product.dao.ProductInfoDAO;
import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.product.service.ProductInfoService;
import com.jiuyi.jyplant.utils.PageResults;

@Service("productInfoService")
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {
	@Resource
	private ProductInfoDAO productInfoDAO;
	/**
	 *  分页查询商品信息 service 实现
	 */
	@Override
	public PageResults<ProductInfo> queryPageProducts(PageResults<ProductInfo> pageResults, ProductInfo productInfo) {
			return productInfoDAO.queryPageProductInfos(pageResults, productInfo);
	}
	/**
	 * 保存商品信息 service层 实现
	 */
	@Override
	public boolean savaProductInfo(ProductInfo productInfo) {
		return productInfoDAO.saveProducInfo(productInfo);
	}
	/**
	 * 校验商品商品信息是否重复
	 */
	@Override
	public boolean chechInfo(ProductInfo productInfo) {
		return productInfoDAO.chechInfo(productInfo);
	}
	/**
	 * 根据id查询商品信息
	 */
	@Override
	public ProductInfo queryById(ProductInfo productInfo) {
		return productInfoDAO.queryProductInfoById(productInfo);
	}
	/**
	 * 根据id删除商品信息
	 */
	@Override
	public boolean deleteProductInfo(String productId) {
		return productInfoDAO.deleteProductInfo(productId);
	}
	/**
	 * 商品上架||商品下架
	 */
	@Override
	public boolean onSellOrOffSell(String t_productId, String t_checkStatus) {
		return productInfoDAO.onSellOrOffSell(t_productId,t_checkStatus);
	}
	
	@Override
	public List<ProductInfo> queryProduct(String storeId) {
		return productInfoDAO.queryProduct(storeId);
	}
	

}
