package com.zwx.guatalumni.common.model.vo;

import lombok.Data;

@Data
public class OptionsVo {
    private Integer value;
    private String label;

    public OptionsVo(Integer id, String name) {
        this.value = id;
        this.label = name;
    }
}
