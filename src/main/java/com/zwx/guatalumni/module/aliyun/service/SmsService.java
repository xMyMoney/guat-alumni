package com.zwx.guatalumni.module.aliyun.service;

import java.util.Date;

public interface SmsService {

    /**
     * 发送生日祝福短信
     * @param alumniId
     * @return
     */
    void sendBirthdaySms(Integer alumniId);

    /**
     * 审批通过短信
     * @param alumniId
     * @param content
     * @param passTime
     */
    void sendNoticeSms(Integer alumniId, String content, Date passTime);

    void sendNoticeSms(String username,String phone, String content, Date passTime);
}
