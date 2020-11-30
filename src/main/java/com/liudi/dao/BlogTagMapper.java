package com.liudi.dao;

import com.liudi.pojo.BlogTag;
import com.liudi.utils.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogTagMapper {

    /**
     * delete tag by the primary key
     * @param tagId the tag id
     * @return 0 or 1
     */
    int delByPK(Integer tagId);

    /**
     * insert a tag
     * @param record
     * @return
     */
    int insert(BlogTag record);

    /**
     * insert a tag
     * @param blogTag
     * @return
     */
    int insertSelective(BlogTag blogTag);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

}
