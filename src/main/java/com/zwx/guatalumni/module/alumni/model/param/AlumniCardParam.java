package com.zwx.guatalumni.module.alumni.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniCardParam extends BasePageParam {

    private String alumniId;
    private String searchKey;
    private Integer searchType;
    private Integer sortType;
}
