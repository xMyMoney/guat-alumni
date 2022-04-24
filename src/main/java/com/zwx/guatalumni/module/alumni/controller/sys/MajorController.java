package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Major;
import com.zwx.guatalumni.module.alumni.model.param.MajorParam;
import com.zwx.guatalumni.module.alumni.service.MajorService;
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
@RequestMapping("/sys/major")
public class MajorController extends BaseController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/list")
    public ResponseResult getList(MajorParam majorParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(majorService.findList(majorParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(majorService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addMajor(@RequestBody Major major) {
        BaseResp baseResp = new BaseResp();
        if (!majorService.save(major)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateMajor(@RequestBody Major major) {
        BaseResp baseResp = new BaseResp();
        if (!majorService.updateById(major)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteMajor(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!majorService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }
}

