package com.zwx.guatalumni.module.donation.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 捐赠申请
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationApply implements Serializable {

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
     * 项目Id
     */
    private Integer donationId;

    /**
     * 校友id
     */
    private Integer alumniId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 申请理由
     */
    private String reason;

}
