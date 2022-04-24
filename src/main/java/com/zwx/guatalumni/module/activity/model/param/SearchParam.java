package com.zwx.guatalumni.module.activity.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchParam {

    private String searchKey;
    private Integer searchType;
}
