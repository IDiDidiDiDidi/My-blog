package com.liudi.service;

import com.liudi.pojo.BlogCategory;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;
import com.liudi.utils.PageUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/19 下午2:58
 */
public interface CategoryService {
    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    int getTotalCategories();

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean saveCategory(String categoryName, String categoryIcon);

    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

    BlogCategory selectById(Integer id);
}
