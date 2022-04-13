package com.zwx.guatalumni.module.alumni.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 交换名片申请
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlumniApply implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 申请人Id
     */
    private Integer applyId;

    /**
     * 被申请人Id
     */
    private Integer alumniId;

    /**
     * 请求留言
     */
    private String message;

    /**
     * 申请状态
     */
    private Integer status;

}
