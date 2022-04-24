package com.zwx.guatalumni.module.donation.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.donation.service.DonationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donation/statistics")
public class DonationStatisticsController extends BaseController {

    @Autowired
    private DonationStatisticsService donationStatisticsService;

    @GetMapping("/rank/latest/{id}")
    public ResponseResult getRankLatest(@PathVariable String id) {
        return setResult(donationStatisticsService.getOneRankLatest(id));
    }

    @GetMapping("/rank/{id}")
    public ResponseResult getRank(@PathVariable String id) {
        return setResult(donationStatisticsService.getOneRank(id));
    }
}
