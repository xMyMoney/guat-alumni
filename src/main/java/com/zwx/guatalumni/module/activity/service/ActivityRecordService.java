package com.zwx.guatalumni.module.activity.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRecordVo;

/**
 * <p>
 * 活动记录表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
public interface ActivityRecordService extends IService<ActivityRecord> {

    PageVo<ActivityRecordVo> findList(ActivityRecordParam activityRecordParam);
}
