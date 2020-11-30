package com.liudi.service;

import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;

public interface TagService {
    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);
}
