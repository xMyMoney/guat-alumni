package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationItemVo {
    private Integer id;
    private String title;
    private String cover;
    private String content;
    private Integer donatedCount;
    private Integer status;
}
