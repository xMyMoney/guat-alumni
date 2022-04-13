package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Academy;
import com.zwx.guatalumni.module.alumni.model.param.AcademyParam;
import com.zwx.guatalumni.module.alumni.service.AcademyService;
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
@RequestMapping("/academy")
public class AcademyController extends BaseController {

    @Autowired
    private AcademyService academyService;

    @GetMapping("/list")
    public ResponseResult getList(AcademyParam academyParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(academyService.findList(academyParam));
        return setResult(baseResp);
    }

    @GetMapping("/options")
    public ResponseResult getOptions() {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(academyService.getOptions());
        return setResult(baseResp);
    }

    @GetMapping("/options/tree")
    public ResponseResult getTree() {
        return setResult(academyService.getTree());
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(academyService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addAcademy(@RequestBody Academy academy) {
        BaseResp baseResp = new BaseResp();
        if (!academyService.save(academy)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateAcademy(@RequestBody Academy academy) {
        BaseResp baseResp = new BaseResp();
        if (!academyService.updateById(academy)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteAcademy(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!academyService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

