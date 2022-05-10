package com.zwx.guatalumni.module.activity.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.FileConstant;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.activity.model.entity.ActivityRecord;
import com.zwx.guatalumni.module.activity.model.param.ActivityRecordParam;
import com.zwx.guatalumni.module.activity.service.ActivityRecordService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/sys/activity-record")
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

    @GetMapping("/export/{id}")
    public ResponseResult export(HttpServletResponse response, @PathVariable String id) {
        Workbook workbook = activityRecordService.export(id);
        try {
            response.setHeader("content-Type","application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(FileConstant.ACTIVITY_INFO_NAME,"UTF-8"));
            workbook.write(response.getOutputStream());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (workbook != null) {
                try {
                    workbook.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/rank/{id}")
    public ResponseResult getRank(@PathVariable String id) {
        return setResult(activityRecordService.getRankById(id));
    }

    @GetMapping("/remind/{id}")
    public ResponseResult remind(@PathVariable String id) {
        activityRecordService.remind(id);
        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/statistics/{id}")
    public ResponseResult statistics(@PathVariable String id) {
        return setResult(activityRecordService.getStatistics(id));
    }
}

