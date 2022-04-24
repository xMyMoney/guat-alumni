package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.param.ApplyParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.service.ProveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/prove-apply")
public class SysProveApplyController extends BaseController {

    @Autowired
    private ProveApplyService proveApplyService;

    @PutMapping("/handle")
    public ResponseResult apply(@RequestBody HandleApplyParam handleApplyParam) {
        proveApplyService.handle(handleApplyParam);
        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/list")
    public ResponseResult getList(ApplyParam applyParam) {
        return setResult(proveApplyService.list(applyParam));
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        return setResult(proveApplyService.getById(id));
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult delOne(@PathVariable String id) {
        return setResult(proveApplyService.removeById(id));
    }
}
