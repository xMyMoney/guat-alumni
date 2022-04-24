package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ApplyRecordDesc;
import com.zwx.guatalumni.common.constant.HandleApplyDesc;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.alumni.model.convert.ApplyInfoConvert;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.dao.BackApplyMapper;
import com.zwx.guatalumni.module.alumni.model.param.ApplyParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.alumni.service.ApplyRecordService;
import com.zwx.guatalumni.module.alumni.service.BackApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 返校申请 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Service
public class BackApplyServiceImpl extends ServiceImpl<BackApplyMapper, BackApply> implements BackApplyService {

    @Autowired
    private SmsService smsService;

    @Autowired
    ApplyInfoConvert applyInfoConvert;

    @Autowired
    private BackApplyMapper backApplyMapper;

    @Override
    public void handle(HandleApplyParam handleApplyParam) {
        UpdateWrapper<BackApply> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(BackApply::getStatus,handleApplyParam.getStatus())
                .eq(BackApply::getId,handleApplyParam.getId());
        this.update(updateWrapper);
        if (handleApplyParam.getStatus().equals(HandleApplyDesc.AGREE.getStatus())) {
            // 发送短信通知
            smsService.sendNoticeSms(handleApplyParam.getApplyId(), ApplyRecordDesc.BackSchool.getApplyDesc(),new Date());
        }else {
            smsService.sendNoticeSms(handleApplyParam.getApplyId(),ApplyRecordDesc.BackSchool.getApplyDesc(),null);
        }
    }

    @Override
    public BaseResp<Void> backApply(BackApply applyParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        // 申请返校
        // 1.校验
        // 1.1是否存在同一天返校申请
        checkApplyInfo(applyParam,baseResp);
        if(!baseResp.isSuccess()) {
            return baseResp;
        }
        // 申请保存或更新
        this.saveOrUpdate(applyParam);
        return baseResp;
    }

    @Override
    public List<AlumniApplyVo> listByApplyId(String id) {
        QueryWrapper<BackApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(BackApply::getApplyId,id);
        List<BackApply> list = this.list(queryWrapper);
        return applyInfoConvert.backApplyToAlumniApplyVoList(list);
    }

    @Override
    public PageVo<BackApply> list(ApplyParam applyParam) {
        IPage<BackApply> page = new Page<>(applyParam.getCurrent(),applyParam.getPageSize());
        QueryWrapper<BackApply> queryWrapper = new QueryWrapper();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(applyParam.getUsername()),BackApply::getUsername,applyParam.getUsername())
                .eq(!StringUtils.isEmpty(applyParam.getApplyTime()),BackApply::getCreateTime,applyParam.getApplyTime())
                .eq(!StringUtils.isEmpty(applyParam.getStatus()),BackApply::getStatus,applyParam.getStatus());
        backApplyMapper.selectPage(page,queryWrapper);
        return new PageVo<>(page.getRecords(),page.getTotal());
    }

    private void checkApplyInfo(BackApply applyParam,BaseResp<Void> baseResp) {
        List<BackApply> applyList = this.list();
        List<BackApply> tempList = new ArrayList<>();
        if (applyParam.getId() == null) {
            tempList = applyList.stream().filter(v -> v.getApplyId().equals(applyParam.getApplyId()))
                    .filter(v -> v.getBackTime().compareTo(applyParam.getBackTime()) == 0).collect(Collectors.toList());
        }else {
            tempList = applyList.stream().filter(v -> !v.getId().equals(applyParam.getId()))
                    .filter(v -> v.getBackTime().compareTo(applyParam.getBackTime()) == 0).collect(Collectors.toList());
        }
        if (!tempList.isEmpty()) {
            baseResp.setResultType(ResultType.OTHER_ERROR,"同一天返校只能申请一次");
        }
    }
}
