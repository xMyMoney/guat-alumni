package com.zwx.guatalumni.module.donation.service.impl;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import com.zwx.guatalumni.module.donation.dao.DonationApplyMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationApplyParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationApplyVo;
import com.zwx.guatalumni.module.donation.service.DonationApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    DonationApplyMapper applyMapper;

    @Override
    public PageVo<DonationApplyVo> findList(DonationApplyParam donationApplyParam) {
        int total = applyMapper.getTotal(donationApplyParam);
        donationApplyParam.setCurrent((donationApplyParam.getCurrent() - 1) * donationApplyParam.getPageSize());
        List<DonationApplyVo> list = applyMapper.getList(donationApplyParam);
        return new PageVo<>(list,total);
    }
}
