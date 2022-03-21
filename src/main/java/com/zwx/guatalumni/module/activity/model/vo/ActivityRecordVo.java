package com.zwx.guatalumni.module.activity.model.vo;

import lombok.Data;

import java.util.Date;
@Data
public class ActivityRecordVo {
    private Integer id;
    private String alumniName;
    private String activityName;
    private Integer signIn;
    private Date signTime;

    public ActivityRecordVo(Integer id, String alumniName, String activityName, Integer signIn, Date signTime) {
        this.id = id;
        this.alumniName = alumniName;
        this.activityName = activityName;
        this.signIn = signIn;
        this.signTime = signTime;
    }
}
