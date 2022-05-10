package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarVo {
    private Integer alumniId;
    private Integer donationCount;
    private Integer activityCount;
}
