package com.zwx.guatalumni.module.activity.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.Data;

/**
 * 公告请求参数
 */
@Data
public class ActivityRecordParam extends BasePageParam {
    /**
     * 校友姓名
     */
    private String alumniName;

    /**
     * 活动名称
     */
    private String activityTitle;


}
