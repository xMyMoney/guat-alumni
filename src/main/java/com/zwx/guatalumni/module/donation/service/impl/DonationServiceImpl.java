package com.zwx.guatalumni.module.donation.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.constant.StatusConstant;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.donation.model.convert.DonationConvert;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.zwx.guatalumni.module.donation.dao.DonationMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationDetailVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationItemVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationStatisticsVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;
import com.zwx.guatalumni.module.donation.service.DonationRecordService;
import com.zwx.guatalumni.module.donation.service.DonationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.donation.service.DonationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private DonationRecordService donationRecordService;

    @Autowired
    private DonationStatisticsService donationStatisticsService;

    @Override
    public PageVo<DonationVo> findList(DonationParam donationParam) {
        IPage<Donation> page = new Page<>(donationParam.getCurrent(),donationParam.getPageSize());
        QueryWrapper<Donation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(donationParam.getTitle()),Donation::getTitle,donationParam.getTitle())
                .like(!StringUtils.isEmpty(donationParam.getContent()),Donation::getContent,donationParam.getContent())
                .eq(!StringUtils.isEmpty(donationParam.getStatus()),Donation::getStatus,donationParam.getStatus());
        List<Donation> donations = donationMapper.selectPage(page, queryWrapper).getRecords();
        return new PageVo<>(donationConvert.toDonationVo(donations),this.count(queryWrapper));
    }

    @Override
    public boolean delDonation(Integer id) {
        if (this.removeById(id)) {
            return donationRecordService.delByDonationId(id);
        }
        return true;
    }

    @Override
    public void checkStatus() {
        List<Donation> list = this.list();
        Date today = DateUtil.parse(DateUtil.today());
        for (Donation donation : list) {
            Date beginTime = donation.getBeginTime();
            Date endTime = donation.getEndTime();
            if (today.compareTo(beginTime) >= 0 && today.compareTo(endTime) <= 0) {
                donation.setStatus(StatusConstant.ING);
                this.updateById(donation);
            }else if (today.compareTo(endTime) > 0) {
                donation.setStatus(StatusConstant.END);
                this.updateById(donation);
            }
        }
    }

    @Override
    public List<OptionsVo> getOptions() {
        List<Donation> donationList = this.list();
        List<OptionsVo> optionsVos = new ArrayList<>();
        donationList.forEach(v->optionsVos.add(new OptionsVo(v.getId(),v.getTitle())));
        return optionsVos;
    }

    @Override
    public List<DonationItemVo> getList() {
        List<Donation> list = this.list();
        return donationConvert.toDonationItems(list);
    }

    @Override
    public DonationDetailVo getOne(String id) {
        Donation donation = this.getById(id);
        DonationStatisticsVo statistics = donationStatisticsService.getOneStatistics(id);
        DonationDetailVo donationDetail = donationConvert.toDonationDetail(donation);
        donationDetail.setRate(Math.round(statistics.getTotal() / statistics.getTarget().floatValue() * 100));
        donationDetail.setTotal(statistics.getTotal());
        donationDetail.setRemain(statistics.getRemain());
        return donationDetail;
    }

    @Override
    public List<DonationItemVo> getList(SearchParam searchParam) {
        return donationMapper.getListCard(searchParam);
    }
}
