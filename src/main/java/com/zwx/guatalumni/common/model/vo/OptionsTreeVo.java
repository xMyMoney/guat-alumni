package com.zwx.guatalumni.common.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionsTreeVo {
    private Integer value;
    private String label;
    private List<OptionsVo> children;

    public OptionsTreeVo(Integer id, String name) {
        this.value = id;
        this.label = name;
    }
}
