package com.zwx.guatalumni.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.StatusConstant;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.alumni.dao.AlumniMapper;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.zwx.guatalumni.module.alumni.service.CompareResultService;
import com.zwx.guatalumni.module.hlht.service.HlhtAlumniService;
import com.zwx.guatalumni.module.user.model.param.RegisterParam;
import com.zwx.guatalumni.module.user.service.LoginService;
import com.zwx.guatalumni.module.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl extends ServiceImpl<AlumniMapper,Alumni> implements RegisterService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private HlhtAlumniService hlhtAlumniService;

    @Autowired
    private CompareResultService compareResultService;

    @Override
    public BaseResp<Void> register(Alumni registerParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        // 自动审核
        boolean checkInfo = check(registerParam);
        if (!checkInfo) {
            baseResp.setErrMsg("请等待工作人员审核");
        }else {
            registerParam.setStatus(StatusConstant.PASS);
            smsService.sendNoticeSms(registerParam.getUsername(),registerParam.getPhone(),"注册",new Date());
        }
        this.saveOrUpdate(registerParam);
        return baseResp;
    }

    private boolean check(Alumni registerParam) {
        CompareResult compareResult = hlhtAlumniService.compareAlumni(registerParam);
        compareResultService.saveOrUpdate(compareResult);
        return compareResult.getResultStatus() == 1;
    }
}
