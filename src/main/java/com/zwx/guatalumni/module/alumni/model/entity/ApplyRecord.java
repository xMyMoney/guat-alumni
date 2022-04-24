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
 * 申请记录
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyRecord implements Serializable {

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
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 申请id
     */
    private String applyId;

    /**
     * 申请类型
     */
    private Integer applyType;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 申请状态
     */
    private Integer applyStatus;

    /**
     * 审批回复
     */
    private String reply;


}
