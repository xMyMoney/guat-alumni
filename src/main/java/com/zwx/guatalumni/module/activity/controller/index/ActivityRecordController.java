package com.zwx.guatalumni.module.activity.controller.index;


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
@RequestMapping("/activity-record")
public class ActivityRecordController extends BaseController {

    @Autowired
    private ActivityRecordService activityRecordService;

    @GetMapping("/list/{id}")
    public ResponseResult getJoinedList(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(activityRecordService.getJoinedList(id));
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

    @DeleteMapping("/one/{id}")
    public ResponseResult delActivityRecord(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        if (!activityRecordService.removeById(id)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }
}

