package com.zwx.guatalumni.module.donation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.convert.DonationConvert;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.zwx.guatalumni.module.donation.dao.DonationMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;
import com.zwx.guatalumni.module.donation.service.DonationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 捐赠项目 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Service
public class DonationServiceImpl extends ServiceImpl<DonationMapper, Donation> implements DonationService {

    @Autowired
    DonationMapper donationMapper;

    @Autowired
    DonationConvert donationConvert;

    @Override
    public PageVo<DonationVo> findList(DonationParam donationParam) {
        IPage<Donation> page = new Page<>(donationParam.getCurrent(),donationParam.getPageSize());
        QueryWrapper<Donation> queryWrapper = new QueryWrapper<>();
        List<Donation> donations = donationMapper.selectPage(page, queryWrapper).getRecords();
        return new PageVo<>(donationConvert.toDonationVo(donations),this.count(queryWrapper));
    }
}
