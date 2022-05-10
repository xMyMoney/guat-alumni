package com.zwx.guatalumni.module.activity.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRankVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRecordVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityStatisticsVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationRankVo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

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

    List<ActivityVo> getJoinedList(String id);

    List<ActivityRankVo> getRankById(String id);

    Workbook export(String activityId);

    void remind(String id);

    ActivityStatisticsVo getStatistics(String id);
}
