package com.jiuyi.jyplant.category.service;

import java.util.List;

import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.utils.PageResults;

public interface CategoryInfoService {
	/**
	 * 分页查询商品分类信息
	 * @param pageView
	 * @param catrgoryInfo
	 * @return
	 */
	public PageResults<CategoryInfo> queryPageCategorys(PageResults<CategoryInfo> pageResults, CategoryInfo catrgoryInfo);
	/**
	 * 保存商品分类信息
	 * @param categoryInfo
	 * @return
	 */
	public boolean saveCategoryInfo(CategoryInfo categoryInfo);
	/**
	 * 根据id查询商品分类信息
	 * @param categoryInfo
	 * @return
	 */
	public CategoryInfo queryById(CategoryInfo categoryInfo);
	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	public List<CategoryInfo> queryAllCategoryInfoByCategoryId(String categoryId);
	
	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	public List<CategoryInfo> queryAllCategoryInfo();
	/**
	 * 删除商品分类信息
	 * @param categoryId
	 * @return
	 */
	public boolean deleteCategoryInfo(String categoryId);
	/**
	 * 
	 * @param categoryInfo
	 * @return
	 */
	public boolean chechInfo(CategoryInfo categoryInfo);
	/**
	 * 启/停用
	 * @param t_categoryId
	 * @param t_checkStatus
	 * @return
	 */
	public boolean updateCategoryInfoStatus(String t_categoryId, String t_checkStatus);
	
	
	
	
	
	
	
	
}
