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
 * 证明申请
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveApply implements Serializable {

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
     * 申请人id
     */
    private String applyId;

    /**
     * 申请人
     */
    private String username;

    /**
     * 学号
     */
    private String stuId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮递地址
     */
    private String address;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 申请状态
     */
    private Integer status;

    /**
     * 申请证明类型
     */
    private Integer proveType;

    /**
     * 批复
     */
    private String reply;
}
