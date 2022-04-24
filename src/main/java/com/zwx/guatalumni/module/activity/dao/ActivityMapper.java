package com.zwx.guatalumni.module.activity.dao;

import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityParam;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 校友活动表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

    List<ActivityVo> getList(ActivityParam activityParam);

    int getTotal(ActivityParam activityParam);

    List<ActivityVo> getListCard(SearchParam searchParam);

    ActivityVo getOne(@Param("activityId") Integer activityId,@Param("alumniId") Integer alumniId);
}
