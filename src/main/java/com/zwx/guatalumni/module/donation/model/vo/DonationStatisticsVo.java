package com.zwx.guatalumni.module.donation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationStatisticsVo {
    private Integer target;
    private Integer total;
    private Integer remain;
    private Integer count;
}
