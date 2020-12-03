package com.liudi.service;

import com.liudi.pojo.Blog;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;

public interface BlogService {
    String saveBlog(Blog blog);

    /**
     * 根据id获取详情
     *
     * @param blogId
     * @return
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    String updateBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);
}
