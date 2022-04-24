package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniApplyVo {
    private Integer id;
    private Integer applyId;
    private String applyType;
    private String applyTime;
    private Integer applyStatus;
    private String reply;
}
