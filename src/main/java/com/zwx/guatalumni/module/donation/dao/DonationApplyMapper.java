package com.zwx.guatalumni.module.donation.dao;

import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationApplyParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationApplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 捐赠申请 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Mapper
public interface DonationApplyMapper extends BaseMapper<DonationApply> {

    int getTotal(DonationApplyParam donationApplyParam);

    List<DonationApplyVo> getList(DonationApplyParam donationApplyParam);
}
