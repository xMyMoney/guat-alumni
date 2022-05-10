package com.zwx.guatalumni.module.aliyun.model.param;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * 短信发送参数
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsParam {
    private List<String> phones;
    private Integer bussType;
    private String sendContent;
}
