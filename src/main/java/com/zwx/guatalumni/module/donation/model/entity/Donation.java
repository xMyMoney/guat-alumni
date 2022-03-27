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
 * 捐赠项目
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation implements Serializable {

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
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 内容
     */
    private String content;

    /**
     * 类别ID
     */
    private Integer category;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 目标
     */
    private Integer target;

    /**
     * 累计
     */
    private Integer count;

    /**
     * 账号id
     */
    private Integer foundation_id;

    /**
     * 捐赠状态
     */
    private Integer status;

}
