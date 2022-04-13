package com.zwx.guatalumni.module.alumni.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniInfoVo;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.zwx.guatalumni.module.alumni.service.impl.AlumniServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlumniLoginController extends BaseController {

    @Autowired
    AlumniService alumniService;

    @PostMapping("/login")
    public ResponseResult login() {
        AlumniInfoVo alumni = alumniService.login();
        return setResult(alumni);
    }

    @DeleteMapping("/logout")
    public ResponseResult logout() {
        return null;
    }


}
