package com.zwx.guatalumni.module.alumni.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniApplyParam {
    private Integer applyId;
    private Integer alumniId;
    private Integer status;
}
