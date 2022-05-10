package com.zwx.guatalumni.module.aliyun.service;

import com.zwx.guatalumni.module.aliyun.model.vo.FileVo;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    FileVo uploadFile(MultipartFile file);

}
