package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.module.information.model.entity.News;
import com.zwx.guatalumni.module.information.model.entity.ResBean;
import com.zwx.guatalumni.module.information.model.param.NewsParam;
import com.zwx.guatalumni.module.information.service.NewsService;
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
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/list")
    public ResBean getList(NewsParam newsParam) {
        Map<String,Object> res = new HashMap<>();
        res.put("list",newsService.findList(newsParam));
        res.put("total",newsService.count());
        return new ResBean<>("1",200,res);
    }

    @GetMapping("/one/{id}")
    public ResBean getOne(@PathVariable String id) {
        return new ResBean("1",200,newsService.getById(id));
    }

    @PostMapping("/one")
    public void addNews(@RequestBody News news) {
        newsService.save(news);
    }

    @PutMapping("/one")
    public void updateNews(@RequestBody News news) {
        newsService.updateById(news);
    }

    @DeleteMapping("/one/{id}")
    public void deleteNews(@PathVariable Integer id) {
        newsService.removeById(id);
    }

    @DeleteMapping("/list")
    public void deleteBatch(List<Integer> ids) {
        newsService.deleteBatch(ids);
    }

}

