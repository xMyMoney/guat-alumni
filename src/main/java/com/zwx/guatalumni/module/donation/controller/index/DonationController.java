package com.zwx.guatalumni.module.donation.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donation")
public class DonationController extends BaseController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/list")
    public ResponseResult getList(SearchParam searchParam) {
        return setResult(donationService.getList(searchParam));
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        return setResult(donationService.getOne(id));
    }

    @GetMapping("/options")
    public ResponseResult getOptions() {
        return setResult(donationService.getOptions());
    }
}
