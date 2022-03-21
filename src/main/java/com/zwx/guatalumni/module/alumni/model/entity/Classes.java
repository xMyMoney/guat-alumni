package com.zwx.guatalumni.module.alumni.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Data
public class Classes implements Serializable {

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
    private String academyId;

    /**
     * 专业id
     */
    private String majorId;

}
