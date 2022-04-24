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
import com.zwx.guatalumni.module.alumni.model.entity.ApplyRecord;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.dao.ProveApplyMapper;
import com.zwx.guatalumni.module.alumni.model.param.ApplyParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.alumni.service.ApplyRecordService;
import com.zwx.guatalumni.module.alumni.service.ProveApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 证明申请 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Service
public class ProveApplyServiceImpl extends ServiceImpl<ProveApplyMapper, ProveApply> implements ProveApplyService {

    @Autowired
    private ApplyInfoConvert applyInfoConvert;

    @Autowired
    private ProveApplyMapper proveApplyMapper;

    @Autowired
    private SmsService smsService;

    @Override
    public BaseResp<Void> proveApply(ProveApply applyParam) {
        BaseResp<Void> baseResp = new BaseResp<>();
        if (applyParam.getId() == null) {
            QueryWrapper<ProveApply> wrapper = new QueryWrapper<>();
            wrapper.lambda()
                    .eq(ProveApply::getApplyId,applyParam.getApplyId())
                    .eq(ProveApply::getProveType,applyParam.getProveType());
            ProveApply one = this.getOne(wrapper);
            if (one != null) {
                baseResp.setResultType(ResultType.OTHER_ERROR,"申请已存在，请耐心等候！");
                return baseResp;
            }
        }
        this.saveOrUpdate(applyParam);
        return baseResp;
    }

    @Override
    public List<AlumniApplyVo> listByApplyId(String id) {
        QueryWrapper<ProveApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(ProveApply::getApplyId,id);
        List<ProveApply> list = this.list(queryWrapper);
        return applyInfoConvert.proveApplyToAlumniApplyVoList(list);
    }

    @Override
    public void handle(HandleApplyParam handleApplyParam) {
        UpdateWrapper<ProveApply> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(ProveApply::getStatus,handleApplyParam.getStatus())
                .eq(ProveApply::getId,handleApplyParam.getId());
        this.update(updateWrapper);
        if (handleApplyParam.getStatus().equals(HandleApplyDesc.AGREE.getStatus())) {
            // 发送短信通知
            smsService.sendNoticeSms(handleApplyParam.getApplyId(), handleApplyParam.getApplyDesc(),new Date());
        }else {
            smsService.sendNoticeSms(handleApplyParam.getApplyId(),handleApplyParam.getApplyDesc(),null);
        }
    }

    @Override
    public PageVo<ProveApply> list(ApplyParam applyParam) {
        IPage<ProveApply> page = new Page<>(applyParam.getCurrent(),applyParam.getPageSize());
        QueryWrapper<ProveApply> queryWrapper = new QueryWrapper();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(applyParam.getUsername()),ProveApply::getUsername,applyParam.getUsername())
                .eq(!StringUtils.isEmpty(applyParam.getApplyTime()),ProveApply::getCreateTime,applyParam.getApplyTime())
                .eq(!StringUtils.isEmpty(applyParam.getStatus()),ProveApply::getStatus,applyParam.getStatus());
        proveApplyMapper.selectPage(page,queryWrapper);
        return new PageVo<>(page.getRecords(),page.getTotal());
    }
}
