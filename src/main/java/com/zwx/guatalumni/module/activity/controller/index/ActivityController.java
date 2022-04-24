package com.zwx.guatalumni.module.activity.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/list")
    public ResponseResult getList(SearchParam searchParam) {
        return setResult(activityService.getList(searchParam));
    }

    @GetMapping("/one")
    public ResponseResult getOne(Integer activityId,Integer alumniId) {
        return setResult(activityService.getOneById(activityId,alumniId));
    }

}
