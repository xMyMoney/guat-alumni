package com.zwx.guatalumni.module.aliyun.service.impl;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.zwx.guatalumni.module.aliyun.model.entity.OssConfig;
import com.zwx.guatalumni.module.aliyun.model.vo.FileVo;
import com.zwx.guatalumni.module.aliyun.service.OssConfigService;
import com.zwx.guatalumni.module.aliyun.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author x
 */
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OssConfigService ossConfigService;

    @Override
    public FileVo uploadFile(MultipartFile file) {
        OssConfig ossConfig = ossConfigService.getById(1);
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(),ossConfig.getAccessKeyId(),ossConfig.getAccessKeySecret());
        if (!ossClient.doesBucketExist(ossConfig.getBucketName())) {
            ossClient.createBucket(ossConfig.getBucketName());
            ossClient.setBucketAcl(ossConfig.getBucketName(), CannedAccessControlList.PublicRead);
        }
        //获取上传文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //文件名：uuid.扩展名
        String original = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        String fileType = original.substring(original.lastIndexOf("."));
        String newName = fileName + fileType;
        String fileUrl = ossConfig.getDir() + "/" + newName;

        //文件上传至阿里云
        ossClient.putObject(ossConfig.getBucketName(), fileUrl, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //获取url地址
        // https://education-return.oss-cn-shanghai.aliyuncs.com/1.jpg
        String uploadUrl = "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint() + "/" + fileUrl;
        String uploadName = fileUrl;
        return new FileVo(uploadName,uploadUrl);
    }
}
