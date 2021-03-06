package com.zwx.guatalumni.module.donation.dao;

import com.zwx.guatalumni.module.donation.model.entity.DonationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationRecordParam;
import com.zwx.guatalumni.module.donation.model.vo.DonatedVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationRankVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 捐赠记录表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Mapper
public interface DonationRecordMapper extends BaseMapper<DonationRecord> {

    int getTotal(DonationRecordParam donationRecordParam);

    List<DonationRecordVo> getList(DonationRecordParam donationRecordParam);

    List<DonationRankVo> getRankById(@Param("id") String id);

    List<DonationRankVo> getRankLatestById(@Param("id") String id);

    List<DonatedVo> getDonations(@Param("id")String id);
}
