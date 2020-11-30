package com.liudi.service.impl;

import com.liudi.dao.BlogTagMapper;
import com.liudi.dao.BlogTagRelationMapper;
import com.liudi.pojo.BlogTag;
import com.liudi.service.TagService;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/27 下午3:06
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private BlogTagRelationMapper relationMapper;

    @Override
    public PageResult getBlogTagPage(PageQueryUtil pageUtil) {
        List<BlogTag> tagList = blogTagMapper.findTagList(pageUtil);
        int totalTags = blogTagMapper.getTotalTags(pageUtil);
        return new PageResult(tagList, totalTags, pageUtil.getLimit(), pageUtil.getPage());
    }

    @Override
    public Boolean saveTag(String tagName) {
        BlogTag tmp = blogTagMapper.selectByTagName(tagName);
        if (tmp == null) {
            BlogTag blogTag = new BlogTag();
            blogTag.setTagName(tagName);
            return blogTagMapper.insertSelective(blogTag) > 0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        List<Long> list = relationMapper.selectDistinctTagIds(ids);
        if (!CollectionUtils.isEmpty(list)) {
            return false;
        }
        return blogTagMapper.deleteBatch(ids) > 0;
    }
}
