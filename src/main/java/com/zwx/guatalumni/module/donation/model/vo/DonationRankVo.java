package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRankVo {
    private String avatar;
    private Integer ranking;
    private String alumni;
    private Integer count;
    private String time;
}
