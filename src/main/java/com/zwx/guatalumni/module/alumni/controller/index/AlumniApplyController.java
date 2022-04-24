package com.zwx.guatalumni.module.alumni.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.service.BackApplyService;
import com.zwx.guatalumni.module.alumni.service.ProveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumni-apply")
public class AlumniApplyController extends BaseController {

    @Autowired
    private BackApplyService backApplyService;

    @Autowired
    private ProveApplyService proveApplyService;

    @PostMapping("/back")
    public ResponseResult backApply(@RequestBody BackApply applyParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        baseResp = backApplyService.backApply(applyParam);
        return setResult(baseResp);
    }

    @GetMapping("/back/one/{id}")
    public ResponseResult getBackApplyInfo(@PathVariable String id) {
        return setResult(backApplyService.getById(id));
    }

    @PostMapping("/prove")
    public ResponseResult proveApply(@RequestBody ProveApply applyParam) {
        BaseResp<Void> baseResp = proveApplyService.proveApply(applyParam);
        return setResult(baseResp);
    }

    @GetMapping("/prove/one/{id}")
    public ResponseResult getProveApplyInfo(@PathVariable String id) {
        return setResult(proveApplyService.getById(id));
    }
}
