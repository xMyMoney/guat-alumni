package com.zwx.guatalumni.module.activity.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.zwx.guatalumni.module.activity.model.param.ActivityParam;
import com.zwx.guatalumni.module.activity.service.ActivityService;
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
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/list")
    public ResponseResult getList(ActivityParam activityParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityService.findList(activityParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addActivity(@RequestBody Activity activity) {
        BaseResp baseResp = new BaseResp();
        if (!activityService.save(activity)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateActivity(@RequestBody Activity activity) {
        BaseResp baseResp = new BaseResp();
        if (!activityService.updateById(activity)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteActivity(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!activityService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/list")
    public ResponseResult deleteBatch(List<Integer> ids) {
        BaseResp baseResp = new BaseResp();
        if (!activityService.deleteBatch(ids)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

}

