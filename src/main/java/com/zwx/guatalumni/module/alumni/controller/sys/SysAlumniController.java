package com.zwx.guatalumni.module.alumni.controller.sys;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.param.AlumniInfoParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthInfo;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniBaseInfo;
import com.zwx.guatalumni.module.alumni.model.convert.AlumniConvert;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
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
@RequestMapping("/sys/alumni")
public class SysAlumniController extends BaseController {

    @Autowired
    private AlumniService alumniService;

    @Autowired
    AlumniConvert alumniConvert;

    @GetMapping("/list")
    public ResponseResult getList(AlumniParam alumniParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(alumniService.findList(alumniParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(alumniService.getById(id));
        return setResult(baseResp);
    }

    @GetMapping("/one/statistics/{id}")
    public ResponseResult getStatistics(@PathVariable String id) {
        return setResult(alumniService.getStatistics(id));
    }

    @GetMapping("/one/base/{id}")
    public ResponseResult getBaseInfo(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(alumniService.getBaseInfoById(id));
        return setResult(baseResp);
    }

    @PutMapping("/one/base")
    public ResponseResult updateBaseInfo(@RequestBody AlumniBaseInfo baseInfo) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.updateById(alumniConvert.toAlumni(baseInfo))) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @GetMapping("/one/auth/{id}")
    public ResponseResult getAuthInfo(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(alumniService.getAuthInfoById(id));
        return setResult(baseResp);
    }

    @PutMapping("/one/auth")
    public ResponseResult updateAuthInfo(@RequestBody AlumniAuthInfo authInfo) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.updateById(alumniConvert.toAlumni(authInfo))) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addAlumni(@RequestBody AlumniInfoParam alumni) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.save(alumni)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateAlumni(@RequestBody Alumni alumni) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.updateById(alumni)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteAlumni(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!alumniService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @GetMapping("/export")
    public ResponseResult<Void> export(HttpServletResponse response) {
        Workbook workbook = alumniService.export();
        try {
            response.setHeader("content-Type","application/vnd-ms-excel");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("校友信息.xlsx","UTF-8"));
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

    @GetMapping("/options")
    public ResponseResult getOptions() {
        return setResult(alumniService.getOptions());
    }
}

