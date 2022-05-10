package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.service.AlumniAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/alumni-auth")
public class SysAlumniAuthController extends BaseController {

    @Autowired
    private AlumniAuthService alumniAuthService;

    @GetMapping("/list")
    public ResponseResult getList(AlumniParam alumniParam) {
        return setResult(alumniAuthService.getList(alumniParam));
    }

    @PutMapping("/handle")
    public ResponseResult handle(@RequestBody HandleApplyParam handleParam) {
        alumniAuthService.handleStatus(handleParam);
        return setResult(ResultType.SUCCESS);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult delOne(@PathVariable String id) {
        alumniAuthService.removeById(id);
        return setResult(ResultType.SUCCESS);
    }
}
