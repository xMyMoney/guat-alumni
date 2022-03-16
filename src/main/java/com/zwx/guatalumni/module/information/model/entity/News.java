package com.zwx.guatalumni.module.information.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 新闻表
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
public class News implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 新闻ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻封面
     */
    private String cover;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 新闻类别ID
     */
    private Integer categoryId;

    /**
     * 新闻阅读量
     */
    private Integer readCount;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否已删除
     */
    private String isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "News{" +
        "id=" + id +
        ", title=" + title +
        ", cover=" + cover +
        ", content=" + content +
        ", categoryId=" + categoryId +
        ", readCount=" + readCount +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
