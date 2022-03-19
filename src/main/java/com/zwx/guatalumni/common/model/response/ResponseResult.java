package com.zwx.guatalumni.common.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回基类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResponseResult", description = "返回对象基类")
public class ResponseResult<T> implements ResponseEntity {

    @ApiModelProperty(value = "返回结果值", required = true)
    private int code;
    @ApiModelProperty(value = "返回结果描述", required = true)
    private String msg;
    @ApiModelProperty(value = "返回结果对象", required = true)
    private T data;
}
