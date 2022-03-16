package com.zwx.guatalumni.module.information.controller.sys;


import com.zwx.guatalumni.module.information.model.entity.Notice;
import com.zwx.guatalumni.module.information.model.entity.ResBean;
import com.zwx.guatalumni.module.information.model.param.NoticeParam;
import com.zwx.guatalumni.module.information.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public ResBean getList(NoticeParam noticeParam) {
        Map<String,Object> res = new HashMap<>();
        res.put("list",noticeService.findList(noticeParam));
        res.put("total",noticeService.count());
        return new ResBean<>("1",200,res);
    }

    @GetMapping("/one/{id}")
    public ResBean getOne(@PathVariable String id) {
        return new ResBean("1",200,noticeService.getById(id));
    }

    @PostMapping("/one")
    public void addNotice(@RequestBody Notice notice) {
        noticeService.save(notice);
    }

    @PutMapping("/one")
    public void updateNotice(@RequestBody Notice notice) {
        noticeService.updateById(notice);
    }

    @DeleteMapping("/one/{id}")
    public void deleteNotice(@PathVariable Integer id) {
        noticeService.removeById(id);
    }

    @DeleteMapping("/list")
    public void deleteBatch(List<Integer> ids) {
        noticeService.deleteBatch(ids);
    }

}

