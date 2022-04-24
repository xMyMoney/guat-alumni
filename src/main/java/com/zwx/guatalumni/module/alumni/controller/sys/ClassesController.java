package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Classes;
import com.zwx.guatalumni.module.alumni.model.param.ClassesParam;
import com.zwx.guatalumni.module.alumni.service.ClassesService;
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
@RequestMapping("/sys/classes")
public class ClassesController extends BaseController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public ResponseResult getList(ClassesParam classesParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(classesService.findList(classesParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(classesService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addClasses(@RequestBody Classes classes) {
        BaseResp baseResp = new BaseResp();
        if (!classesService.save(classes)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateClasses(@RequestBody Classes classes) {
        BaseResp baseResp = new BaseResp();
        if (!classesService.updateById(classes)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteClasses(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!classesService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

