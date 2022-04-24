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
public class ActivityParam extends BasePageParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 分类
     */
    private Integer categoryId;

    /**
     * 状态
     */
    private Integer status;
}
