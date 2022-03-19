package com.zwx.guatalumni.module.activity.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.activity.model.entity.ActivityCategory;
import com.zwx.guatalumni.module.activity.model.param.ActivityCategoryParam;
import com.zwx.guatalumni.module.activity.service.ActivityCategoryService;
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
@RequestMapping("/activityCategory")
public class ActivityCategoryController extends BaseController {

    @Autowired
    private ActivityCategoryService activityCategoryService;

    @GetMapping("/list")
    public ResponseResult getList(ActivityCategoryParam activityCategoryParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityCategoryService.findList(activityCategoryParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityCategoryService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addActivityCategoryCategory(@RequestBody ActivityCategory activityCategory) {
        BaseResp baseResp = new BaseResp();
        if (!activityCategoryService.save(activityCategory)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateActivityCategoryCategory(@RequestBody ActivityCategory activityCategory) {
        BaseResp baseResp = new BaseResp();
        if (!activityCategoryService.updateById(activityCategory)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteActivityCategoryCategory(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!activityCategoryService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/list")
    public ResponseResult deleteBatch(List<Integer> ids) {
        BaseResp baseResp = new BaseResp();
        if (!activityCategoryService.deleteBatch(ids)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

}

