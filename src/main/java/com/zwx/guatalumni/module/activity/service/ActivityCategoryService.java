package com.zwx.guatalumni.module.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.ActivityCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.activity.model.param.ActivityCategoryParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityCategoryVo;

import java.util.List;

/**
 * <p>
 * 活动类别表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
public interface ActivityCategoryService extends IService<ActivityCategory> {

    PageVo<ActivityCategoryVo> findList(ActivityCategoryParam activityCategoryParam);

    boolean deleteBatch(List<Integer> ids);
}
