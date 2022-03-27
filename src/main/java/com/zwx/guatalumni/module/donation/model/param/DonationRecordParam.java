package com.zwx.guatalumni.module.donation.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRecordParam extends BasePageParam {

    private String username;
    private String title;
    private Integer category;

}
