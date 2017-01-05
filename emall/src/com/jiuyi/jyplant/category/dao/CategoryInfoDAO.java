package com.jiuyi.jyplant.category.dao;

import java.util.List;

import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.utils.PageResults;


public interface CategoryInfoDAO {
	/**
	 * 分页查询商品分类信息
	 * @param pageResults
	 * @param catrgoryInfo
	 * @return
	 */
	public PageResults<CategoryInfo> queryPageCategoryInfos(PageResults<CategoryInfo> pageResults,CategoryInfo catrgoryInfo);
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
	 * 查询全部商品分类信息 实现
	 */
	public List<CategoryInfo> queryAllCategoryInfo();
	
	
	/**
	 * 查询全部商品分类信息 实现
	 */
	public List<CategoryInfo> queryAllCategoryInfoByCategoryId(String categoryId);
	/**
	 * 删除商品分类信息
	 * @param categoryId
	 * @return
	 */
	public boolean deleteCategoryInfo(String categoryId);
	/**
	 * 检查
	 * @param catrgoryInfo
	 * @return
	 */
	public boolean chechInfo(CategoryInfo catrgoryInfo);
	/**
	 * 启停/用
	 * @param t_categoryId
	 * @param t_checkStatus
	 * @return
	 */
	public boolean updateCategoryInfoStatus(String t_categoryId, String t_checkStatus);
	
}
