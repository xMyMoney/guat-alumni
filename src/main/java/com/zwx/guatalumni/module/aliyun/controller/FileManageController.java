package com.zwx.guatalumni.module.aliyun.controller;

import com.zwx.guatalumni.common.base.BaseController;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.module.aliyun.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/file")
public class FileManageController extends BaseController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam("file") MultipartFile file) {
        return setResult(ossService.uploadFile(file));
    }

}
