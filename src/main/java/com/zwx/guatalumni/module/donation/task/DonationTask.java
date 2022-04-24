package com.zwx.guatalumni.module.donation.task;

import com.zwx.guatalumni.module.donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DonationTask {

    @Autowired
    private DonationService donationService;

    /**
     * 每天0点执行检查捐赠项目状态
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void checkStatus() {
        donationService.checkStatus();
    }
}
