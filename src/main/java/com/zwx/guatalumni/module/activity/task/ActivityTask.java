package com.zwx.guatalumni.module.activity.task;

import com.zwx.guatalumni.module.activity.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@EnableScheduling
public class ActivityTask {

    @Autowired
    private ActivityService activityService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void checkStatus() {
        log.info("开始检查活动状态");
        activityService.checkStatus();
        log.info("结束检查活动状态");
    }
}
