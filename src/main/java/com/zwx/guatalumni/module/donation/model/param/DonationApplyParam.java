package com.zwx.guatalumni.module.donation.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationApplyParam extends BasePageParam {

    /**
     * 校友名字
     */
    private String username;
    /**
     * 申请时间
     */
    private Date createTime;
    private String title;
}
