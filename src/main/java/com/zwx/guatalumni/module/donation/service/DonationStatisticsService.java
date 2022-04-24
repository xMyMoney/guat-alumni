package com.zwx.guatalumni.module.donation.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.module.donation.model.vo.DonationRankVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationStatisticsVo;

import java.util.List;

public interface DonationStatisticsService {
    DonationStatisticsVo getOneStatistics(String id);

    List<DonationRankVo> getOneRank(String id);

    List<DonationRankVo> getOneRankLatest(String id);
}
