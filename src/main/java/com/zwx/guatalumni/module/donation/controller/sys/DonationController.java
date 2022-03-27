package com.zwx.guatalumni.module.donation.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.service.DonationService;
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
@RequestMapping("/donation")
public class DonationController extends BaseController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/list")
    public ResponseResult getList(DonationParam donationParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationService.findList(donationParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addDonation(@RequestBody Donation donation) {
        BaseResp baseResp = new BaseResp();
        if (!donationService.save(donation)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateDonation(@RequestBody Donation donation) {
        BaseResp baseResp = new BaseResp();
        if (!donationService.updateById(donation)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteDonation(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!donationService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

