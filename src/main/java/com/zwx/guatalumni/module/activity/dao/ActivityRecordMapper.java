package com.zwx.guatalumni.module.activity.dao;

import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRankVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRecordVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityStatisticsVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 活动记录表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Mapper
public interface ActivityRecordMapper extends BaseMapper<ActivityRecord> {

    int getTotal(ActivityRecordParam activityRecordParam);

    List<ActivityRecordVo> getList(ActivityRecordParam activityRecordParam);

    List<ActivityVo> getJoined(@Param("id") String id);

    List<ActivityRankVo> getRankById(@Param("id") String id);

    ActivityStatisticsVo getStatictics(@Param("id")String id);
}
