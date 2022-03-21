package com.zwx.guatalumni.module.alumni.model.vo;

import com.zwx.guatalumni.module.alumni.model.entity.Classes;
import lombok.Data;

@Data
public class ClassesVo extends Classes {
    private String academy;
    private String major;
}
