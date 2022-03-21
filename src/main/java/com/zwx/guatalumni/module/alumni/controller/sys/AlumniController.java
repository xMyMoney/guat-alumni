package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
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
@RequestMapping("/alumni")
public class AlumniController extends BaseController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping("/list")
    public ResponseResult getList(AlumniParam alumniParam) {
        BaseResp baseResp = new BaseResp();
        System.out.println(alumniParam.toString());
        baseResp.setData(alumniService.findList(alumniParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(alumniService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addAlumni(@RequestBody Alumni alumni) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.save(alumni)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateAlumni(@RequestBody Alumni alumni) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.updateById(alumni)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteAlumni(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}
