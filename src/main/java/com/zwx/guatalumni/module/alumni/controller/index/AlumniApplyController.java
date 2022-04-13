package com.zwx.guatalumni.module.alumni.controller.index;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.AlumniApply;
import com.zwx.guatalumni.module.alumni.model.param.AlumniApplyParam;
import com.zwx.guatalumni.module.alumni.service.AlumniApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 交换名片申请 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@RestController
@RequestMapping("/alumni-apply")
public class AlumniApplyController extends BaseController {

    @Autowired
    AlumniApplyService alumniApplyService;

    @PostMapping
    public ResponseResult applyChange(@RequestBody AlumniApply applyInfo) {
        BaseResp baseResp = new BaseResp();
        if (!alumniApplyService.save(applyInfo)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/handle")
    public ResponseResult handleApply(@RequestBody AlumniApplyParam param) {
        BaseResp baseResp = new BaseResp();
        if (!alumniApplyService.updateById(param)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @GetMapping("/list/{id}")
    public ResponseResult listApply(@PathVariable String id) {
        return setResult(alumniApplyService.getListApplyById(id));
    }
}

