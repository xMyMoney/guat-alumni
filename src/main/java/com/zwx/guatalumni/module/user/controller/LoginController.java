package com.zwx.guatalumni.module.user.controller;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseResult login(@RequestBody LoginParam loginParam) {
        return setResult(loginService.login(loginParam));
    }
}
