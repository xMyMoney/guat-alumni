package com.zwx.guatalumni.module.donation.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.donation.model.entity.DonationRecord;
import com.zwx.guatalumni.module.donation.model.param.DonationRecordParam;
import com.zwx.guatalumni.module.donation.service.DonationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/donationRecord")
public class DonationRecordController extends BaseController {

    @Autowired
    private DonationRecordService donationRecordService;

    @GetMapping("/list")
    public ResponseResult getList(DonationRecordParam donationRecordParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationRecordService.findList(donationRecordParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationRecordService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addDonationRecord(@RequestBody DonationRecord donationRecord) {
        BaseResp baseResp = new BaseResp();
        if (!donationRecordService.save(donationRecord)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateDonationRecord(@RequestBody DonationRecord donationRecord) {
        BaseResp baseResp = new BaseResp();
        if (!donationRecordService.updateById(donationRecord)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteDonationRecord(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!donationRecordService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

