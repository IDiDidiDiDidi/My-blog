package com.liudi.dao;

import com.liudi.pojo.BlogCategory;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/19 下午2:44
 */
@Component
public interface BlogCategoryMapper {
    // 增
    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Integer categoryId);
    // 删
    int deleteByPrimaryKey(Integer categoryId);

    int deleteBatch(Integer[] ids);
    // 改
    int updateByPrimaryKey(BlogCategory record);

    int updateByPrimaryKeySelective(BlogCategory record);
    // 查
    List<BlogCategory> findCategoryList(PageQueryUtil pageUtil);

    BlogCategory selectByCategoryName(String categoryName);

    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    int getCountCategories(PageQueryUtil pageUtil);
}
