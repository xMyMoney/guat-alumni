package com.zwx.guatalumni.module.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.zwx.guatalumni.module.activity.dao.ActivityRecordMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRecordVo;
import com.zwx.guatalumni.module.activity.service.ActivityRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 活动记录表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Service
public class ActivityRecordServiceImpl extends ServiceImpl<ActivityRecordMapper, ActivityRecord> implements ActivityRecordService {

    @Autowired
    ActivityRecordMapper activityRecordMapper;

    @Override
    public PageVo<ActivityRecordVo> findList(ActivityRecordParam activityRecordParam) {
//        int total = activityRecordMapper.getTotal(activityRecordParam);
//        List<ActivityRecordVo> list = activityRecordMapper.getList(activityRecordParam);
        int total = 10;
        List<ActivityRecordVo> list = new ArrayList<>();
        list.add(new ActivityRecordVo(1,"校友1","活动",1,new Date()));
        list.add(new ActivityRecordVo(2,"校友2","活动2",0,new Date()));
        return new PageVo<>(list,total);
    }
}
