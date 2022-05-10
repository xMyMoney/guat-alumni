package com.zwx.guatalumni.module.user.controller;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.user.model.entity.Admin;
import com.zwx.guatalumni.module.user.model.param.AdminParam;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-04-27
 */
@RestController
@RequestMapping("/sys/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public ResponseResult login(@RequestBody LoginParam loginParam) {
        return setResult(adminService.login(loginParam));
    }

    @PostMapping("/one")
    public ResponseResult add(@RequestBody Admin admin) {
        adminService.save(admin);
        return setResult(ResultType.SUCCESS);
    }

    @PutMapping("/one")
    public ResponseResult update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return setResult(ResultType.SUCCESS);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult delete(@PathVariable String id) {
        adminService.removeById(id);
        return setResult(ResultType.SUCCESS);
    }

    @GetMapping("/list")
    public ResponseResult getList(AdminParam adminParam) {
        return setResult(adminService.getList(adminParam));
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        return setResult(adminService.getById(id));
    }

}

