package com.zwx.guatalumni.module.activity.service.impl;

import com.zwx.guatalumni.module.activity.model.Activity;
import com.zwx.guatalumni.module.activity.dao.ActivityMapper;
import com.zwx.guatalumni.module.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
