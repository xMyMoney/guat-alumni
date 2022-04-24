package com.zwx.guatalumni.module.donation.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.donation.service.DonationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author x
 */
@RestController
@RequestMapping("/sys/donation/statistics")
public class SysDonationStatisticsController extends BaseController {

    @Autowired
    private DonationStatisticsService donationStatisticsService;

    @GetMapping("/one/{id}")
    public ResponseResult getOneStatistics(@PathVariable String id) {
        return setResult(donationStatisticsService.getOneStatistics(id));
    }

    @GetMapping("/one/rank/{id}")
    public ResponseResult getOneRank(@PathVariable String id) {
        return setResult(donationStatisticsService.getOneRank(id));
    }
}
