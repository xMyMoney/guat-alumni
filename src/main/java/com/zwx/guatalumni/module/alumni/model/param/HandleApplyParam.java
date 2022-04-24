package com.zwx.guatalumni.module.alumni.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返校申请参数
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleApplyParam {
    private Integer id;
    private String applyDesc;
    private Integer applyId;
    private Integer status;
    private String reason;
    private String reply;
}
