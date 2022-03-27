package com.zwx.guatalumni.module.donation.dao;

import com.zwx.guatalumni.module.donation.model.entity.DonationCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 捐赠类别表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
@Mapper
public interface DonationCategoryMapper extends BaseMapper<DonationCategory> {

}
