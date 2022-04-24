package com.zwx.guatalumni.module.activity.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 校友活动表
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity implements Serializable {

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
     * 活动类别ID
     */
    private Integer categoryId;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 地点
     */
    private String place;

    /**
     * 校友范围
     */
    private Integer scope;

    /**
     * 名额数量
     */
    private Integer quota;

    /**
     * 已参加人数
     */
    private Integer joinCount;

    /**
     * 发起人
     */
    private String editor;

    /**
     * 活动状态
     */
    private Integer status;

}
