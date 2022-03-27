package com.zwx.guatalumni.module.donation.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;

/**
 * <p>
 * 捐赠项目 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
public interface DonationService extends IService<Donation> {

    PageVo<DonationVo> findList(DonationParam donationParam);
}
