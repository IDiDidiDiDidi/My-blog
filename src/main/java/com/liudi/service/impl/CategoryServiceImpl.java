package com.liudi.service.impl;

import com.liudi.dao.BlogCategoryMapper;
import com.liudi.pojo.BlogCategory;
import com.liudi.service.CategoryService;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;
import com.liudi.utils.PageUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/19 下午2:59
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;


    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        List<BlogCategory> categoryList = blogCategoryMapper.findCategoryList(pageUtil);
        int count = blogCategoryMapper.getCountCategories(pageUtil);
        return new PageResult(categoryList, count, pageUtil.getLimit(), pageUtil.getPage());
    }

    @Override
    public int getTotalCategories() {
        return blogCategoryMapper.getCountCategories(null);
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategory temp = blogCategoryMapper.selectByCategoryName(categoryName);
        if (temp == null) {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryMapper.insertSelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
        if (blogCategory != null) {
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        return blogCategoryMapper.deleteBatch(ids) > 0;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryMapper.findCategoryList(null);
    }

    @Override
    public BlogCategory selectById(Integer id) {
        return blogCategoryMapper.selectByPrimaryKey(id);
    }
}
