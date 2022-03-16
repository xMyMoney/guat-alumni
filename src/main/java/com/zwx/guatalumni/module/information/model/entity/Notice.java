package com.zwx.guatalumni.module.information.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
public class Notice implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 公告Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否已删除
     */
    private String isDelete;

    public Notice() {
    }

    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Notice(Integer id, String title, String content, Date createTime, Date updateTime, String isDelete) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Notice{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
