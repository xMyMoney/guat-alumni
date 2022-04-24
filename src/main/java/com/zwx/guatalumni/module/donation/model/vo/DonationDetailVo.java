package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDetailVo {
    private Integer id;
    private String title;
    private String cover;
    private String content;
    private Integer target;
    private Integer total;
    private Integer remain;
    private Integer count;
    private Integer status;
    private Integer rate;
}
