package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.hlht.service.HlhtAcademyService;
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
@RequestMapping("/sys/academy")
public class SysAcademyController extends BaseController {

    @Autowired
    private HlhtAcademyService hlhtAcademyService;


    @GetMapping("/options")
    public ResponseResult getOptions() {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(hlhtAcademyService.getOptions());
        return setResult(baseResp);
    }

    @GetMapping("/options/tree")
    public ResponseResult getTree() {
        return setResult(hlhtAcademyService.getTree());
    }
}

