package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.information.model.entity.NewsCategory;
import com.zwx.guatalumni.module.information.model.param.NewsCategoryParam;
import com.zwx.guatalumni.module.information.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/sys/newsCategory")
public class SysNewsCategoryController extends BaseController {

    @Autowired
    private NewsCategoryService newsCategoryService;

    @GetMapping("/list")
    public ResponseResult getList(NewsCategoryParam newsCategoryParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(newsCategoryService.findList(newsCategoryParam));
        return setResult(baseResp);
    }

    @GetMapping("/list/all")
    public ResponseResult getListAll() {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(newsCategoryService.getCategoryOptions());
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(newsCategoryService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addNewsCategory(@RequestBody NewsCategory newsCategory) {
        BaseResp baseResp = new BaseResp();
        if (!newsCategoryService.save(newsCategory)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateNewsCategory(@RequestBody NewsCategory newsCategory) {
        BaseResp baseResp = new BaseResp();
        if (!newsCategoryService.updateById(newsCategory)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteNewsCategory(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!newsCategoryService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/list")
    public ResponseResult deleteBatch(List<Integer> ids) {
        BaseResp baseResp = new BaseResp();
        newsCategoryService.deleteBatch(ids);
        return setResult(baseResp);
    }

}

