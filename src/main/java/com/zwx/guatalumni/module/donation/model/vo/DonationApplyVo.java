package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationApplyVo {
    /**
     * id
     */
    private Integer id;

    /**
     * 申请时间
     */
    private Date createTime;

    /**
     * 申请人
     */
    private String username;

    /**
     * 申请项目
     */
    private String title;


    /**
     * 申请理由
     */
    private String reason;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 申请状态
     */
    private Integer state;
}
