package com.zwx.guatalumni.module.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityVo {
    private Integer id;
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
    private String category;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

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

    /**
     * 是否已报名
     */
    private boolean isJoin;
}
