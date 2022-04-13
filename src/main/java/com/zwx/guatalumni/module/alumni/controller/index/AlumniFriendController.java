package com.zwx.guatalumni.module.alumni.controller.index;


import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.alumni.service.AlumniFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 校友关系 前端控制器
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@RestController
@RequestMapping("/alumni-friend")
public class AlumniFriendController extends BaseController {

    @Autowired
    AlumniFriendService alumniFriendService;

    @GetMapping("/list/{id}")
    public ResponseResult getFriends(@PathVariable String id) {
        return setResult(alumniFriendService.findList(id));
    }

}

