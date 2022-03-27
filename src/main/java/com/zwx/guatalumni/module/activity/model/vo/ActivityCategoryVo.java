package com.zwx.guatalumni.module.activity.model.vo;

import com.zwx.guatalumni.module.activity.model.entity.ActivityCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityCategoryVo extends ActivityCategory {
    private int activityCount;
}
