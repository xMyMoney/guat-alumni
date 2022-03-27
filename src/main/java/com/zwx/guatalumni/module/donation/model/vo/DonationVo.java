package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationVo {

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
     * 捐赠状态
     */
    private Integer status;
}
