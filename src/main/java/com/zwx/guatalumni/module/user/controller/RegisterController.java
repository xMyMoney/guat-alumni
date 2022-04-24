package com.zwx.guatalumni.module.user.controller;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.user.model.param.RegisterParam;
import com.zwx.guatalumni.module.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseResult register(@RequestBody Alumni registerParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        baseResp = registerService.register(registerParam);
        return setResult(baseResp);
    }

    @PutMapping
    public ResponseResult updateRegister(@RequestBody Alumni registerParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        baseResp = registerService.register(registerParam);
        return setResult(baseResp);
    }

    @GetMapping("/info/{id}")
    public ResponseResult updateRegister(@PathVariable String id) {
        BaseResp<Void> baseResp = new BaseResp<>();
        return setResult(registerService.getById(id));
    }
}
