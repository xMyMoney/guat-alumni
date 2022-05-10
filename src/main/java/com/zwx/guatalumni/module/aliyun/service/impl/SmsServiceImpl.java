package com.zwx.guatalumni.module.aliyun.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.zwx.guatalumni.common.constant.SmsConstant;
import com.zwx.guatalumni.module.aliyun.model.entity.SmsConfig;
import com.zwx.guatalumni.module.aliyun.model.entity.SmsTemplate;
import com.zwx.guatalumni.module.aliyun.model.param.SmsParam;
import com.zwx.guatalumni.module.aliyun.service.SmsConfigService;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.aliyun.service.SmsTemplateService;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.teaopenapi.models.*;

import java.util.*;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private SmsConfigService smsConfigService;

    @Autowired
    private AlumniService alumniService;

    @Override
    public void sendBirthdaySms(Integer alumniId) {
        Alumni alumni = alumniService.getById(alumniId);
        SmsParam smsParam = new SmsParam();
        smsParam.setPhones(Arrays.asList(alumni.getPhone()));
        smsParam.setBussType(SmsConstant.BirthBussType);
        Map<String,String> map = new HashMap<>();
        map.put("username",alumni.getUsername());
        smsParam.setSendContent(JSON.toJSONString(map));
        this.sendSms(smsParam);
    }

    @Override
    public void sendNoticeSms(Integer alumniId, String content, Date passTime) {
        Alumni alumni = alumniService.getById(alumniId);
        SmsParam smsParam = new SmsParam();
        smsParam.setPhones(Arrays.asList(alumni.getPhone()));
        Map<String,String> map = new HashMap<>();
        map.put("username",alumni.getUsername());
        if (null == passTime) {
            smsParam.setBussType(SmsConstant.UNApprovedBussType);
            map.put("applyType",content);
        }else {
            smsParam.setBussType(SmsConstant.ApprovedBussType);
            map.put("content",content);
            map.put("passTime", DateUtil.formatDateTime(passTime));
        }
        smsParam.setSendContent(JSON.toJSONString(map));
        this.sendSms(smsParam);
    }

    @Override
    public void sendNoticeSms(String username,String phone, String content, Date passTime) {
        SmsParam smsParam = new SmsParam();
        smsParam.setPhones(Arrays.asList(phone));
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        if (null == passTime) {
            smsParam.setBussType(SmsConstant.UNApprovedBussType);
            map.put("applyType",content);
        }else {
            smsParam.setBussType(SmsConstant.ApprovedBussType);
            map.put("content",content);
            map.put("passTime", DateUtil.formatDateTime(passTime));
        }
        smsParam.setSendContent(JSON.toJSONString(map));
        this.sendSms(smsParam);
    }

    private Client getClient() {
        SmsConfig smsConfig = smsConfigService.getById(1);
        Config config = new Config()
                // AccessKey ID
                .setAccessKeyId(smsConfig.getAccessKeyId())
                // AccessKey Secret
                .setAccessKeySecret(smsConfig.getAccessKeySecret());
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = null;
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void sendSms(SmsParam smsParam) {
        // 获取短信模板
        SmsTemplate smsTemplate = smsTemplateService.getByBussType(smsParam.getBussType());
        // 获取短信配置
        SmsConfig smsConfig = smsConfigService.getById(1);
        Client client = this.getClient();
        SendSmsRequest request = new SendSmsRequest()
                .setPhoneNumbers(smsParam.getPhones().get(0))
                .setSignName(smsConfig.getSign())
                .setTemplateCode(smsTemplate.getTemplateCode())
                .setTemplateParam(smsParam.getSendContent());
        try {
            SendSmsResponse response = client.sendSms(request);
            if (SmsConstant.OK.equals(response.getBody().code)) {
                System.out.println("发送成功");
            }else {
                System.out.println(response.getBody().getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
