package com.zwx.guatalumni.module.alumni.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.Data;

@Data
public class MajorParam extends BasePageParam {
    private String name;
    private String academy;
}
