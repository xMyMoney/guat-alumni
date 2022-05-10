package com.zwx.guatalumni.module.activity.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.constant.FileConstant;
import com.zwx.guatalumni.common.constant.SmsConstant;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.zwx.guatalumni.module.activity.dao.ActivityRecordMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRankVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityRecordVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityStatisticsVo;
import com.zwx.guatalumni.module.activity.model.vo.ActivityVo;
import com.zwx.guatalumni.module.activity.service.ActivityRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.activity.service.ActivityService;
import com.zwx.guatalumni.module.aliyun.model.param.SmsParam;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private ActivityService activityService;

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private SmsService smsService;

    @Override
    public PageVo<ActivityRecordVo> findList(ActivityRecordParam activityRecordParam) {
        activityRecordParam.setCurrent((activityRecordParam.getCurrent()-1)*activityRecordParam.getPageSize());
        int total = activityRecordMapper.getTotal(activityRecordParam);
        List<ActivityRecordVo> list = activityRecordMapper.getList(activityRecordParam);
        return new PageVo<>(list,total);
    }

    @Override
    public List<ActivityVo> getJoinedList(String id) {

        return activityRecordMapper.getJoined(id);
    }

    @Override
    public List<ActivityRankVo> getRankById(String id) {
        return activityRecordMapper.getRankById(id);
    }

    @Override
    public Workbook export(String activityId) {
        Activity activity = activityService.getById(activityId);
        QueryWrapper<ActivityRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(ActivityRecord::getActivityId,activityId);
        List<ActivityRecord> recordList = this.list(queryWrapper);
        List<Integer> alumniIds = recordList.stream().map(ActivityRecord::getAlumniId).collect(Collectors.toList());
        List<Alumni> alumniList = alumniService.listByIds(alumniIds);

        Workbook workbook = null;
        TemplateExportParams exportParams = new TemplateExportParams(FileConstant.ACTIVITY_INFO_EXPORT, 0);
        Map<String ,Object> data = new HashMap<>();
        data.put("activity",activity.getTitle());
        data.put("time",DateUtil.format(activity.getBeginTime(),"YYYY年MM月dd日"));
        data.put("address",activity.getPlace());
        List<Map<String ,Object>> sheetData = new ArrayList<>();
        if (!recordList.isEmpty()) {
            int id = 1;
            for (ActivityRecord record : recordList) {
                Alumni alumni = alumniList.stream().filter(a->a.getId().equals(record.getAlumniId())).findFirst().orElse(null);
                if (alumni != null) {
                    Map<String ,Object> row = new HashMap<>();
                    row.put("id",id++);
                    row.put("username",alumni.getUsername());
                    row.put("phone",alumni.getPhone());
                    row.put("star",alumni.getStar());
                    sheetData.add(row);
                }
            }
        }
        data.put("mapList",sheetData);
        workbook = ExcelExportUtil.exportExcel(exportParams,data);
        return workbook;
    }

    @Override
    public void remind(String id) {
        QueryWrapper<ActivityRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(ActivityRecord::getActivityId,id);
        List<ActivityRecord> records = this.list(queryWrapper);
        Activity activity = activityService.getById(id);
        List<Integer> alumniIds = records.stream().map(ActivityRecord::getAlumniId).collect(Collectors.toList());
        List<Alumni> alumniList = alumniService.listByIds(alumniIds);
        Map<String,String> map = new HashMap<>();
        map.put("activityName",activity.getTitle());
        map.put("beginTime", DateUtil.formatDateTime(activity.getBeginTime()));
        SmsParam smsParam = new SmsParam();
        smsParam.setBussType(SmsConstant.RemindBussType);
        for (Alumni alumni : alumniList) {
            map.put("username",alumni.getUsername());
            smsParam.setPhones(Arrays.asList(alumni.getPhone()));
            smsParam.setSendContent(JSON.toJSONString(map));
            smsService.sendSms(smsParam);
        }
    }

    @Override
    public ActivityStatisticsVo getStatistics(String id) {
        ActivityStatisticsVo statisticsVo = activityRecordMapper.getStatictics(id);
        Integer joined = statisticsVo.getJoined();
        Integer quota = statisticsVo.getQuota();
        if (joined < quota) {
            statisticsVo.setRemain(quota-joined);
        }else {
            statisticsVo.setRemain(0);
        }
        return statisticsVo;
    }
}
