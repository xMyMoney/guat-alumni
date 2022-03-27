package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRecordVo {
    private Integer id;

    /**
     * 捐赠时间
     */
    private Date createTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 类别ID
     */
    private Integer category;

    /**
     * 去处
     */
    private String foundation;

    private String username;

    private Integer money;

    private Integer thing;

    private String desc;
}
