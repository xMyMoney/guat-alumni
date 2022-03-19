package com.zwx.guatalumni.module.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.zwx.guatalumni.module.activity.dao.ActivityMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityParam;
import com.zwx.guatalumni.module.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 校友活动表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageVo<Activity> findList(ActivityParam activityParam) {
        IPage<Activity> page = new Page<>(activityParam.getCurrent(),activityParam.getPageSize());
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(!StringUtils.isEmpty(activityParam.getTitle()),Activity::getTitle,activityParam.getTitle())
                .eq(!StringUtils.isEmpty(activityParam.getContent()),Activity::getContent,activityParam.getContent())
                .eq(null != activityParam.getCategoryId(),Activity::getCategoryId,activityParam.getCategoryId());
        return new PageVo<>(activityMapper.selectPage(page,queryWrapper).getRecords(),this.count());
    }

    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = activityMapper.deleteBatchIds(ids);
        return row > 0;
    }
}
