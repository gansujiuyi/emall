package com.jiuyi.jyplant.product.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.category.service.CategoryInfoService;
import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.product.service.ProductInfoService;
import com.jiuyi.jyplant.utils.PageResults;

@Controller
@RequestMapping(value="/product/mng")
public class ProductController {
	private static final Logger LOGGER = Logger.getLogger(ProductController.class);
	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private CategoryInfoService categoryInfoService;
	
	/**
	 * 进入商品分类信息
	 * @return
	 */
	@RequestMapping("/query")
	public String query(){
		LOGGER.info("开始进入商品信息查询！");
		return "/pages/product/productList";
	}
	/**
	 * 分页查询商品信息
	 * @param request
	 * @param categoryInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/ajaxQueryAllProduct")
	@ResponseBody
	public PageResults<ProductInfo> ajaxQueryAllProduct(HttpServletRequest request,
			@ModelAttribute("productInfo") ProductInfo productInfo, Integer page, Integer rows) {
		PageResults<ProductInfo> pageResults = null;
		if (null == page) {
			pageResults = new PageResults<ProductInfo>(1, 10);
		} else {
			pageResults = new PageResults<ProductInfo>(page, rows);
		}
		pageResults = productInfoService.queryPageProducts(pageResults, productInfo);
		return pageResults;
	}
	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	/**
	 * 保存商品信息
	 * @param ProductInfo
	 * @return
	 */
	@RequestMapping(value = "/saveProductInfo")
	@ResponseBody
	public String saveProductInfo(@ModelAttribute("productInfo") ProductInfo productInfo) {
		if("".equals(productInfo.getT_productId())){
			productInfo.setT_checkStatus("0");
			CategoryInfo categoryInfo = new CategoryInfo();
			categoryInfo.setT_categoryId(productInfo.getT_categoryType());
			categoryInfo = categoryInfoService.queryById(categoryInfo);
			productInfo.setT_typeName(categoryInfo.getT_categoryName());
			productInfo.setT_productId(null);
        }
		boolean save = productInfoService.savaProductInfo(productInfo);
		return save+"";
	}
	/**
	 * 校验商品信息是否重复
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/chechInfo")
	@ResponseBody
	public String chechInfo(@ModelAttribute("ProductInfo") ProductInfo ProductInfo) {
		if(productInfoService.chechInfo(ProductInfo)){
			return "true";
		}
		return "false";
	}
	/**
	 * 根据id查询商品分类信息
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/queryProductInfoById")
	@ResponseBody
	public ProductInfo queryProductInfoById(@ModelAttribute("productInfo") ProductInfo productInfo){
		ProductInfo newProductInfo = productInfoService.queryById(productInfo);
		return newProductInfo;
	}
	/**
	 * 删除商品分类信息
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/delProductInfo")
	@ResponseBody
	public String delProductInfo(String t_productId){
		if(productInfoService.deleteProductInfo(t_productId)){
			return "true";
		}
		return "false"; 
	}
	/**
	 * 商品上架||商品下架
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/updateCategoryInfoStatus")
	@ResponseBody
	public String onSellOrOffSell(String t_productId ,String t_checkStatus) {
		if(productInfoService.onSellOrOffSell(t_productId ,t_checkStatus)){
			return "true";
		}
		return "false"; 
	}
}
