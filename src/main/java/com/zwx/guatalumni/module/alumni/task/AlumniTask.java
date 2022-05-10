package com.zwx.guatalumni.module.alumni.task;

import com.zwx.guatalumni.module.alumni.service.AlumniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@EnableScheduling
public class AlumniTask {

    @Autowired
    private AlumniService alumniService;

    /**
     * 每天早上九点检查是否有校友今日生日并发送生日祝福短信
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendBirthdaySms() {
        log.info("发送生日短信");
        alumniService.sendBirthdaySms();
    }

    /**
     * 更新星级
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void updateStar() {
        log.info("更新校友星级");
        alumniService.updateStar();
    }
}
