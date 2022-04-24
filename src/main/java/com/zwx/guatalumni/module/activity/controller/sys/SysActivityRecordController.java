package com.zwx.guatalumni.module.activity.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.service.ActivityRecordService;
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
@RequestMapping("/sys/activityRecord")
public class SysActivityRecordController extends BaseController {

    @Autowired
    private ActivityRecordService activityRecordService;

    @GetMapping("/list")
    public ResponseResult getList(ActivityRecordParam activityRecordParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityRecordService.findList(activityRecordParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityRecordService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addActivityRecord(@RequestBody ActivityRecord activityRecord) {
        BaseResp baseResp = new BaseResp();
        if (!activityRecordService.save(activityRecord)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateActivityRecord(@RequestBody ActivityRecord activityRecord) {
        BaseResp baseResp = new BaseResp();
        if (!activityRecordService.updateById(activityRecord)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteActivityRecord(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!activityRecordService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

//    @DeleteMapping("/list")
//    public ResponseResult deleteBatch(List<Integer> ids) {
//        BaseResp baseResp = new BaseResp();
//        if (!activityRecordService.deleteBatch(ids)) {
//            baseResp.setDeleteFailMsg();
//        }
//        return setResult(baseResp);
//    }

}

