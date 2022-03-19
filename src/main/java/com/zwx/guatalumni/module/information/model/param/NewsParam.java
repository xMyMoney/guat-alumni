package com.zwx.guatalumni.module.information.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.Data;

/**
 * 公告请求参数
 */
@Data
public class NewsParam extends BasePageParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    private Integer categoryId;


}
