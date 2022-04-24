package com.zwx.guatalumni.module.aliyun.service;

import com.zwx.guatalumni.module.aliyun.model.entity.SmsTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 短信模板 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-17
 */
public interface SmsTemplateService extends IService<SmsTemplate> {

    SmsTemplate getByBussType(Integer bussType);
}
