package com.zwx.guatalumni.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: BasePageEntity
 * @author: andy
 * @date: 2016-02-27
 * @version: v1.0
 * @Description: 分页请求参数基类
 */
@Data
@ApiModel(value = "BasePageParam", description = "分页请求参数基类")
public class BasePageParam implements BaseEntity{

    @ApiModelProperty(value = "页码 默认1，第一页", example = "1")
    private int current = 1;

    @ApiModelProperty(value = "每页大小 默认每页10条", example = "10")
    private int pageSize = 10;
}
