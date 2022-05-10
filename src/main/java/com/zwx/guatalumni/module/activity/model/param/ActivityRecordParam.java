package com.zwx.guatalumni.module.activity.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公告请求参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRecordParam extends BasePageParam {
    /**
     * 校友姓名
     */
    private String username;

    /**
     * 活动名称
     */
    private String title;

}
