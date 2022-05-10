package com.zwx.guatalumni.module.activity.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.constant.StatusConstant;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.zwx.guatalumni.module.activity.dao.ActivityMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityParam;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;
import com.zwx.guatalumni.module.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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
    public PageVo<ActivityVo> findList(ActivityParam activityParam) {
        activityParam.setCurrent((activityParam.getCurrent()-1)*activityParam.getPageSize());
        List<ActivityVo> list = activityMapper.getList(activityParam);
        int total = activityMapper.getTotal(activityParam);
        return new PageVo<>(list,total);
    }

    @Override
    public boolean deleteBatch(List<Integer> ids) {
        int row = activityMapper.deleteBatchIds(ids);
        return row > 0;
    }

    @Override
    public boolean defaultCategory(Integer id) {
        UpdateWrapper<Activity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(Activity::getCategoryId,0)
                .eq(Activity::getCategoryId,id);
        return this.update(updateWrapper);
    }

    @Override
    public List<ActivityVo> getList(SearchParam searchParam) {
        return activityMapper.getListCard(searchParam);
    }

    @Override
    public ActivityVo getOneById(Integer activityId, Integer alumniId) {
        return activityMapper.getOne(activityId,alumniId);
    }

    @Override
    public void checkStatus() {
        List<Activity> activityList = this.list();
        for (Activity activity : activityList) {
            activity.setStatus(getStatus(activity));
            this.updateById(activity);
        }
    }

    private Integer getStatus(Activity activity) {
        Date today = DateUtil.parse(DateUtil.today());
        Date beginTime = activity.getBeginTime();
        Date endTime = activity.getEndTime();
        if (today.compareTo(beginTime) >= 0 && today.compareTo(endTime) <= 0) {
           return StatusConstant.ING;
        }else if (today.compareTo(endTime) > 0) {
           return StatusConstant.END;
        }
        return StatusConstant.NOT_START;
    }

    @Override
    public List<OptionsVo> getOptions() {
        List<Activity> activityList = this.list();
        List<OptionsVo> options = new ArrayList<>();
        activityList.forEach(v->options.add(new OptionsVo(v.getId(),v.getTitle())));
        return options;
    }

    @Override
    public boolean saveActivity(Activity activity) {
        Integer status = getStatus(activity);
        activity.setStatus(status);
        return this.save(activity);
    }


}
