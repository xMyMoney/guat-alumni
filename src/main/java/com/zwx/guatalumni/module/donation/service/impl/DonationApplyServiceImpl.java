package com.zwx.guatalumni.module.donation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zwx.guatalumni.common.constant.ApplyRecordDesc;
import com.zwx.guatalumni.common.constant.HandleApplyDesc;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
import com.zwx.guatalumni.module.alumni.model.convert.ApplyInfoConvert;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import com.zwx.guatalumni.module.donation.dao.DonationApplyMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationApplyParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationApplyVo;
import com.zwx.guatalumni.module.donation.service.DonationApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 捐赠申请 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Service
public class DonationApplyServiceImpl extends ServiceImpl<DonationApplyMapper, DonationApply> implements DonationApplyService {

    @Autowired
    private DonationApplyMapper applyMapper;

    @Autowired
    private SmsService smsService;

    @Autowired
    private ApplyInfoConvert applyInfoConvert;

    @Override
    public PageVo<DonationApplyVo> findList(DonationApplyParam donationApplyParam) {
        int total = applyMapper.getTotal(donationApplyParam);
        donationApplyParam.setCurrent((donationApplyParam.getCurrent() - 1) * donationApplyParam.getPageSize());
        List<DonationApplyVo> list = applyMapper.getList(donationApplyParam);
        return new PageVo<>(list,total);
    }

    @Override
    public void handle(HandleApplyParam handleApplyParam) {
        UpdateWrapper<DonationApply> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(DonationApply::getStatus,handleApplyParam.getStatus())
                .eq(DonationApply::getId,handleApplyParam.getId());
        this.update(updateWrapper);
        if (handleApplyParam.getStatus().equals(HandleApplyDesc.AGREE.getStatus())) {
            // 发送短信通知
            smsService.sendNoticeSms(handleApplyParam.getApplyId(), ApplyRecordDesc.DONATION.getApplyDesc(), new Date());
        }else {
            smsService.sendNoticeSms(handleApplyParam.getApplyId(),ApplyRecordDesc.DONATION.getApplyDesc(), null);
        }
    }

    @Override
    public List<AlumniApplyVo> listByApplyId(String id) {
        QueryWrapper<DonationApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(DonationApply::getApplyId,id);
        List<DonationApply> list = this.list(queryWrapper);
        return applyInfoConvert.donationApplyToAlumniApplyVoList(list);
    }
}
