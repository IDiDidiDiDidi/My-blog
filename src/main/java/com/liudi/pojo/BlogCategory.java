package com.liudi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/19 下午2:36
 */
public class BlogCategory {
    private Integer categoryId;

    //分类名称
    private String categoryName;

    //分类图标
    private String categoryIcon;

    //分类排序值
    private Integer categoryRank;

    //0=否 1=是
    private Byte isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();//搞不懂这里重写是干嘛用的？？？？
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryIcon='" + categoryIcon + '\'' +
                ", categoryRank=" + categoryRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                '}';
    }
}
