package com.zwx.guatalumni.module.hlht.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 专业表
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HlhtMajor implements Serializable {

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
     * 专业名称
     */
    private String name;

    /**
     * 原专业名称
     */
    private String oldName;

    /**
     * 院系id
     */
    private Integer academyId;



}
