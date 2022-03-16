package com.zwx.guatalumni.common.base;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

public abstract class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer isDelete;

    public BaseEntity() {
    }

    public BaseEntity(Integer id, Date createTime, Date updateTime, Integer isDelete) {
        this.id = id;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
