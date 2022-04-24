package com.zwx.guatalumni.module.alumni.controller.index;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.service.ApplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 申请记录 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/apply-record")
public class ApplyRecordController extends BaseController {

    @Autowired
    private ApplyRecordService applyRecordService;

    @GetMapping("/list/{id}")
    public ResponseResult getList(@PathVariable String id) {
        return setResult(applyRecordService.getList(id));
    }
}

