package com.zwx.guatalumni.module.alumni.task;

import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlumniBirthdayTask {

    @Autowired
    private AlumniService alumniService;

    /**
     * 每天早上九点检查是否有校友今日生日并发送生日祝福短信
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendBirthdaySms() {
        alumniService.sendBirthdaySms();
    }
}
