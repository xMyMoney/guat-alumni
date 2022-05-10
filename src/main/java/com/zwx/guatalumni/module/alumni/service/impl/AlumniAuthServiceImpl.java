package com.zwx.guatalumni.module.alumni.service.impl;

import com.zwx.guatalumni.common.constant.ApplyRecordDesc;
import com.zwx.guatalumni.common.constant.HandleApplyDesc;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthVo;
import com.zwx.guatalumni.module.alumni.service.AlumniAuthService;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.zwx.guatalumni.module.alumni.service.CompareResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AlumniAuthServiceImpl implements AlumniAuthService {

    @Autowired
    private CompareResultService compareResultService;

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private SmsService smsService;

    @Override
    public PageVo<AlumniAuthVo> getList(AlumniParam alumniParam) {
        return compareResultService.getAlumniAuthList(alumniParam);
    }

    @Override
    public void handleStatus(HandleApplyParam handleParam) {
        // 更新状态
        Alumni alumni = alumniService.getById(handleParam.getId());
        if (alumni != null) {
            alumni.setStatus(handleParam.getStatus());
            alumniService.updateById(alumni);
            CompareResult compareResult = new CompareResult(alumni.getId(), handleParam.getStatus());

            if (handleParam.getStatus().equals(HandleApplyDesc.AGREE.getStatus())) {
                compareResult.setResultInfo("人工认证");
                // 发送邮件
                smsService.sendNoticeSms(handleParam.getId(), ApplyRecordDesc.AUTH.getApplyDesc(), new Date());
            }else {
                compareResult.setResultInfo(handleParam.getReply());
                smsService.sendNoticeSms(handleParam.getId(), ApplyRecordDesc.AUTH.getApplyDesc(), null);
            }
            compareResultService.updateById(compareResult);
        }

    }

    @Override
    public void removeById(String id) {
        compareResultService.removeById(id);
    }
}
