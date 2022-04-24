package com.zwx.guatalumni.module.donation.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import com.zwx.guatalumni.module.donation.model.param.DonationApplyParam;
import com.zwx.guatalumni.module.donation.service.DonationApplyService;
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
@RequestMapping("/sys/donation-apply")
public class SysDonationApplyController extends BaseController {

    @Autowired
    private DonationApplyService donationApplyService;

    @PutMapping("/handle")
    public ResponseResult apply(@RequestBody HandleApplyParam handleApplyParam) {
        donationApplyService.handle(handleApplyParam);
        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/list")
    public ResponseResult getList(DonationApplyParam donationApplyParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationApplyService.findList(donationApplyParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(donationApplyService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addDonationApply(@RequestBody DonationApply donationApply) {
        BaseResp baseResp = new BaseResp();
        if (!donationApplyService.save(donationApply)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateDonationApply(@RequestBody DonationApply donationApply) {
        BaseResp baseResp = new BaseResp();
        if (!donationApplyService.updateById(donationApply)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteDonationApply(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!donationApplyService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

