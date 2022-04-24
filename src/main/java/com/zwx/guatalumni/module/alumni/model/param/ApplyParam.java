package com.zwx.guatalumni.module.alumni.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyParam extends BasePageParam {
    private String username;
    private Date applyTime;
    private Integer status;
}
