package com.zwx.guatalumni.module.donation.model.entity;

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
 * 捐赠记录表
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRecord implements Serializable {

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
     * 校友id
     */
    private Integer alumniId;

    /**
     * 捐赠id
     */
    private Integer donationId;

    /**
     * 捐赠金钱
     */
    private Integer money;

    /**
     * 捐赠物品
     */
    private Integer thing;


//    /**
//     * 描述
//     */
//    private String desc;

}
