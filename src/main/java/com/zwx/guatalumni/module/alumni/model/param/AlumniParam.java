package com.zwx.guatalumni.module.alumni.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.Data;

@Data
public class AlumniParam extends BasePageParam {

    /**
     * 姓名
     */
    private String username;

    /**
     * 学号
     */
    private Integer stuId;

    /**
     * 毕业年份
     */
    private String endYear;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 认证状态
     */
    private Integer status;
}
