package com.zwx.guatalumni.module.donation.service.impl;

import com.zwx.guatalumni.module.donation.dao.DonationMapper;
import com.zwx.guatalumni.module.donation.dao.DonationRecordMapper;
import com.zwx.guatalumni.module.donation.model.vo.DonationRankVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationStatisticsVo;
import com.zwx.guatalumni.module.donation.service.DonationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationStatisticsServiceImpl implements DonationStatisticsService {

    @Autowired
    private DonationMapper donationMapper;

    @Autowired
    private DonationRecordMapper donationRecordMapper;

    @Override
    public DonationStatisticsVo getOneStatistics(String id) {
        DonationStatisticsVo donationStatisticsVo = donationMapper.getStatisticsById(id);
        int remain = donationStatisticsVo.getTarget() - donationStatisticsVo.getTotal();
        if (remain < 0) {
            donationStatisticsVo.setRemain(0);
        }else {
            donationStatisticsVo.setRemain(remain);
        }
        return donationStatisticsVo;
    }

    @Override
    public List<DonationRankVo> getOneRank(String id) {
        List<DonationRankVo> rankVo = donationRecordMapper.getRankById(id);
        for (int i = 1; i <= rankVo.size(); i++) {
            rankVo.get(i-1).setRanking(i);
        }
        return rankVo;
    }

    @Override
    public List<DonationRankVo> getOneRankLatest(String id) {
        return donationRecordMapper.getRankLatestById(id);
    }
}
