package com.jiuyi.jyplant.category.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.category.dao.CategoryInfoDAO;
import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.category.service.CategoryInfoService;
import com.jiuyi.jyplant.utils.PageResults;
@Service("categoryInfoService")
@Transactional
public class CategoryInfoServiceImpl implements CategoryInfoService {
	@Autowired
	private CategoryInfoDAO categoryInfoDAO;

	@Override
	public PageResults<CategoryInfo> queryPageCategorys(PageResults<CategoryInfo> pageResults,
			CategoryInfo catrgoryInfo) {
		PageResults<CategoryInfo> categoryInfos = categoryInfoDAO.queryPageCategoryInfos(pageResults, catrgoryInfo);
		List<CategoryInfo> temp = categoryInfos.getRows();
		if(null != temp && temp.size()>0){
			Object[] obj = temp.toArray();
			List<CategoryInfo> list = new ArrayList<CategoryInfo>();
			 for (int i = 0; i < obj.length; i++) {
				 Object[] tempObj =(Object[]) obj[i]; 
				 CategoryInfo info = new CategoryInfo();
				 info.setT_categoryId(tempObj[0]+"");
				 info.setT_categoryName(tempObj[1]+"");
				 info.setT_categoryType(tempObj[2]+"");
				 info.setT_checkStatus(tempObj[3]+"");
				 info.setT_desc(tempObj[4]+"");
				 list.add(info);
			}
			categoryInfos.setRows(list);
		}
		return categoryInfos;
	}
	/**
	 * 保存商品分类信息
	 */
	@Override
	public boolean saveCategoryInfo(CategoryInfo categoryInfo) {
		return categoryInfoDAO.saveCategoryInfo(categoryInfo);
	}
	/**
	 * 根据id查询商品分类信息
	 */
	@Override
	public CategoryInfo queryById(CategoryInfo categoryInfo) {
		return categoryInfoDAO.queryById(categoryInfo);
		 
	}
	/**
	 * 查询所有商品分类信息
	 */
	@Override
	public List<CategoryInfo> queryAllCategoryInfoByCategoryId(String categoryId) {
		return categoryInfoDAO.queryAllCategoryInfoByCategoryId(categoryId);
	}
	
	/**
	 * 查询所有商品分类信息
	 */
	@Override
	public List<CategoryInfo> queryAllCategoryInfo() {
		return categoryInfoDAO.queryAllCategoryInfo();
	}
	/**
	 * 根据id删除商品分类信息
	 */
	@Override
	public boolean deleteCategoryInfo(String categoryId) {
		return categoryInfoDAO.deleteCategoryInfo(categoryId);
	}
	/**
	 * 检查
	 */
	@Override
	public boolean chechInfo(CategoryInfo categoryInfo) {
		return categoryInfoDAO.chechInfo(categoryInfo);
	}
	/**
	 * 启停/用
	 */
	@Override
	public boolean updateCategoryInfoStatus(String t_categoryId, String t_checkStatus) {
		return categoryInfoDAO.updateCategoryInfoStatus(t_categoryId,t_checkStatus);
	}

}
