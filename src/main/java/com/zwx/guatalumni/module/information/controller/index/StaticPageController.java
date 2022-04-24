package com.zwx.guatalumni.module.information.controller.index;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.information.service.StaticPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/static-page")
public class StaticPageController extends BaseController {

    @Autowired
    StaticPageService staticPageService;

    @GetMapping("/one/{pageType}")
    public ResponseResult getOne(@PathVariable String pageType) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(staticPageService.getPageInfo(pageType));
        return setResult(baseResp);
    }

    @GetMapping("/slideshow")
    public ResponseResult getSlideshow() {
        return setResult(ResultType.SUCCESS);
    }
}
