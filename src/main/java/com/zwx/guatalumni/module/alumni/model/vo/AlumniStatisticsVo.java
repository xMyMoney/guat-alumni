package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniStatisticsVo {
    private Integer donationCount;
    private Integer activityCount;
    private Integer helpCount;
    private Integer applyCount;
}
