package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.information.model.entity.StaticPage;
import com.zwx.guatalumni.module.information.service.StaticPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 静态页面 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-27
 */
@RestController
@RequestMapping("/static-page")
public class StaticPageController extends BaseController {
    
    @Autowired
    StaticPageService staticPageService;
    
    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(staticPageService.getById(id));
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateStaticPage(@RequestBody StaticPage staticPage) {
        BaseResp baseResp = new BaseResp();
        if (!staticPageService.updateById(staticPage)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }
}

