package com.liudi.pojo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/27 下午2:51
 */
public class BlogTagRelation {

    private Long relationId;

    private Long blogId;

    private Integer tagId;

    private Date createTime;

    @Override
    public String toString() {
        return "BlogTagRelation{" +
                "relationId=" + relationId +
                ", blogId=" + blogId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
