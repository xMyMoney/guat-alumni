package com.zwx.guatalumni.module.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.common.utils.PageUtil;
import com.zwx.guatalumni.module.activity.model.entity.ActivityCategory;
import com.zwx.guatalumni.module.activity.dao.ActivityCategoryMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityCategoryParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityCategoryVo;
import com.zwx.guatalumni.module.activity.service.ActivityCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 活动类别表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Service
public class ActivityCategoryServiceImpl extends ServiceImpl<ActivityCategoryMapper, ActivityCategory> implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryMapper activityCategoryMapper;

    @Override
    public PageVo<ActivityCategoryVo> findList(ActivityCategoryParam activityCategoryParam) {
        QueryWrapper<ActivityCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                        .eq(!StringUtils.isEmpty(activityCategoryParam.getName()),ActivityCategory::getName,activityCategoryParam.getName());
        int total = this.count(queryWrapper);
        activityCategoryParam.setCurrent((activityCategoryParam.getCurrent() - 1) * activityCategoryParam.getPageSize());
        List<ActivityCategoryVo> list = activityCategoryMapper.selectPage(activityCategoryParam);
        return new PageVo<>(list,total);
    }

    @Override
    public boolean deleteBatch(List<Integer> ids) {
        return false;
    }
}
