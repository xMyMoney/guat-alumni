package com.zwx.guatalumni.module.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRecordVo {
    private Integer id;
    private String username;
    private String title;
    private String createTime;
    private Integer signIn;
    private Date signTime;


}
