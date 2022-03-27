package com.zwx.guatalumni.module.donation.dao;

import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 捐赠项目 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Mapper
public interface DonationMapper extends BaseMapper<Donation> {

}
