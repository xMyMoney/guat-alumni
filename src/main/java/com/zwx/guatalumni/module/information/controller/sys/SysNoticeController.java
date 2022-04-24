package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.information.model.entity.Notice;
import com.zwx.guatalumni.module.information.model.param.NoticeParam;
import com.zwx.guatalumni.module.information.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/sys/notice")
public class SysNoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public ResponseResult getList(NoticeParam noticeParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(noticeService.findList(noticeParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(noticeService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addNotice(@RequestBody Notice notice) {
        BaseResp baseResp = new BaseResp();
        if (!noticeService.save(notice)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateNotice(@RequestBody Notice notice) {
        BaseResp baseResp = new BaseResp();
        if (!noticeService.updateById(notice)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteNotice(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!noticeService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/list")
    public ResponseResult deleteBatch(List<Integer> ids) {
        BaseResp baseResp = new BaseResp();
        noticeService.deleteBatch(ids);
        return setResult(baseResp);
    }

}

