package com.zwx.guatalumni.module.hlht.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
public class HlhtClasses implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 原班级名称
     */
    private String oldName;

    /**
     * 院系id
     */
    private Integer academyId;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 班级编号
     */
    private Integer classesNo;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getClassesNo() {
        return classesNo;
    }

    public void setClassesNo(Integer classesNo) {
        this.classesNo = classesNo;
    }

    @Override
    public String toString() {
        return "HlhtClasses{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", name=" + name +
        ", oldName=" + oldName +
        ", academyId=" + academyId +
        ", majorId=" + majorId +
        ", classesNo=" + classesNo +
        "}";
    }
}
