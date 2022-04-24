package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.information.model.entity.News;
import com.zwx.guatalumni.module.information.model.param.NewsParam;
import com.zwx.guatalumni.module.information.service.NewsService;
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
@RequestMapping("/sys/news")
public class SysNewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/list")
    public ResponseResult getList(NewsParam newsParam) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(newsService.findList(newsParam));
        return setResult(baseResp);
    }

    @GetMapping("/one/{id}")
    public ResponseResult getOne(@PathVariable String id) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(newsService.getById(id));
        return setResult(baseResp);
    }

    @PostMapping("/one")
    public ResponseResult addNews(@RequestBody News news) {
        BaseResp baseResp = new BaseResp();
        if (!newsService.save(news)) {
            baseResp.setSaveFailMsg();
        }
        return setResult(baseResp);
    }

    @PutMapping("/one")
    public ResponseResult updateNews(@RequestBody News news) {
        BaseResp baseResp = new BaseResp();
        if (!newsService.updateById(news)) {
            baseResp.setUpdateFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/one/{id}")
    public ResponseResult deleteNews(@PathVariable Integer id) {
        BaseResp baseResp = new BaseResp();
        if (!newsService.removeById(id)) {
            baseResp.setDeleteFailMsg();
        }
        return setResult(baseResp);
    }

    @DeleteMapping("/list")
    public ResponseResult deleteBatch(List<Integer> ids) {
        BaseResp baseResp = new BaseResp();
        newsService.deleteBatch(ids);
        return setResult(baseResp);
    }

}

