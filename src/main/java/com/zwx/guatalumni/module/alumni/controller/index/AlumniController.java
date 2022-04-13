package com.zwx.guatalumni.module.alumni.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.param.AlumniCardParam;
import com.zwx.guatalumni.module.alumni.service.AlumniFriendService;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumni")
public class AlumniController extends BaseController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping("/list")
    public ResponseResult getList(AlumniCardParam alumniCardParam) {
        return setResult(alumniService.findList(alumniCardParam));
    }
}
