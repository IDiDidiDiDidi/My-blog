package com.liudi.dao;

import com.liudi.pojo.Blog;
import org.springframework.stereotype.Component;

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
}
