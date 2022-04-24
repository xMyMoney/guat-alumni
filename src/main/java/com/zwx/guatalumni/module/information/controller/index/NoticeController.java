package com.zwx.guatalumni.module.information.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.information.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public ResponseResult getList() {
        return setResult(noticeService.list());
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        return setResult(noticeService.getById(id));
    }

    @GetMapping("/one/hot")
    public ResponseResult getOneHot() {
        return setResult(noticeService.getHotById());
    }

}
