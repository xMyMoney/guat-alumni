package com.zwx.guatalumni.module.donation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationRecord;
import com.zwx.guatalumni.module.donation.dao.DonationRecordMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationRecordParam;
import com.zwx.guatalumni.module.donation.model.vo.DonatedVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationRecordVo;
import com.zwx.guatalumni.module.donation.service.DonationRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 捐赠记录表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Service
public class DonationRecordServiceImpl extends ServiceImpl<DonationRecordMapper, DonationRecord> implements DonationRecordService {

    @Autowired
    DonationRecordMapper donationRecordMapper;

    @Override
    public PageVo<DonationRecordVo> findList(DonationRecordParam donationRecordParam) {
        int total = donationRecordMapper.getTotal(donationRecordParam);
        donationRecordParam.setCurrent((donationRecordParam.getCurrent() - 1) * donationRecordParam.getPageSize());
        List<DonationRecordVo> list = donationRecordMapper.getList(donationRecordParam);
        return new PageVo<>(list,total);
    }

    @Override
    public boolean delByDonationId(Integer id) {
        QueryWrapper<DonationRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(DonationRecord::getDonationId,id);
        return this.remove(queryWrapper);
    }

    @Override
    public List<DonatedVo> getList(String id) {
        return donationRecordMapper.getDonations(id);
    }
}
