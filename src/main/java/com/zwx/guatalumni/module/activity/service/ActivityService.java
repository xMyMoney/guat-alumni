package com.zwx.guatalumni.module.activity.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.activity.model.param.ActivityParam;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;

import java.util.List;

/**
 * <p>
 * 校友活动表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
public interface ActivityService extends IService<Activity> {

    PageVo<ActivityVo> findList(ActivityParam activityParam);

    boolean deleteBatch(List<Integer> ids);

    boolean defaultCategory(Integer id);

    List<ActivityVo> getList(SearchParam searchParam);


    ActivityVo getOneById(Integer activityId, Integer alumniId);
}
