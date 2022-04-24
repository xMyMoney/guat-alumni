package com.zwx.guatalumni.common.model.vo;

import lombok.Data;

@Data
public class OptionsVo {
    private Integer value;
    private String label;
    private String text;

    public OptionsVo(Integer value, String label) {
        this.value = value;
        this.label = label;
        this.text = label;
    }
}
