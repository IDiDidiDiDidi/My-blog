package com.liudi.dao;

import com.liudi.pojo.Blog;
import com.liudi.utils.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/30 下午4:11
 */
@Component
public interface BlogMapper {
    int deleteByPK(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPK(Long blogId);

    int updateByPKSelective(Blog record);

    int updateByPKWithBlogs(Blog record);

    int updateByPK(Blog record);

    /**
     * 分页查询blogs
     * @param pageUtil
     * @return
     */
    List<Blog> findBlogList(PageQueryUtil pageUtil);

    /**
     * blogs 总数
     *
     * @return
     */
    int countBlogs();

    int deleteBatch(Integer[] ids);
}
