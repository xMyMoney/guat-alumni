package com.zwx.guatalumni.module.donation.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.donation.model.entity.DonationRecord;
import com.zwx.guatalumni.module.donation.service.DonationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donation-record")
public class DonationRecordController extends BaseController {

    @Autowired
    private DonationRecordService donationRecordService;

    @PostMapping
    public ResponseResult addRecord(@RequestBody DonationRecord donationRecord) {
        donationRecordService.save(donationRecord);
        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/list/{id}")
    public ResponseResult getDonated(@PathVariable String id) {
        return setResult(donationRecordService.getList(id));
    }

}
