package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.module.information.model.entity.NewsCategory;
import com.zwx.guatalumni.module.information.model.entity.ResBean;
import com.zwx.guatalumni.module.information.model.param.NewsCategoryParam;
import com.zwx.guatalumni.module.information.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 新闻分类表 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/category")
public class NewsCategoryController {

    @Autowired
    private NewsCategoryService newsCategoryService;

    @GetMapping("/list/all")
    public ResBean getCategoryAll() {
        return new ResBean<>("1",200, newsCategoryService.getCategoryOptions());
    }

    @GetMapping("/list")
    public ResBean getList(NewsCategoryParam newsCategoryParam) {
        return new ResBean<>("1",200, newsCategoryService.findList(newsCategoryParam));
    }

    @GetMapping("/one/{id}")
    public ResBean getOne(@PathVariable String id) {
        return new ResBean("1",200, newsCategoryService.getById(id));
    }

    @PostMapping("/one")
    public void addCategory(@RequestBody NewsCategory newsCategory) {
        newsCategoryService.save(newsCategory);
    }

    @PutMapping("/one")
    public void updateCategory(@RequestBody NewsCategory newsCategory) {
        newsCategoryService.updateById(newsCategory);
    }

    @DeleteMapping("/one/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        newsCategoryService.delById(id);
    }

    @DeleteMapping("/list")
    public void deleteBatch(List<Integer> ids) {
        newsCategoryService.deleteBatch(ids);
    }

}

