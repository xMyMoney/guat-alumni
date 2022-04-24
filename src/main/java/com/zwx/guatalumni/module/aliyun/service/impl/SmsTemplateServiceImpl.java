package com.zwx.guatalumni.module.aliyun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.module.aliyun.model.entity.SmsTemplate;
import com.zwx.guatalumni.module.aliyun.dao.SmsTemplateMapper;
import com.zwx.guatalumni.module.aliyun.service.SmsTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短信模板 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-17
 */
@Service
public class SmsTemplateServiceImpl extends ServiceImpl<SmsTemplateMapper, SmsTemplate> implements SmsTemplateService {

    @Override
    public SmsTemplate getByBussType(Integer bussType) {
        QueryWrapper<SmsTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SmsTemplate::getBussType,bussType);
        return this.getOne(queryWrapper);
    }
}
