package com.zwx.guatalumni.module.donation.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.donation.model.param.DonationApplyParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationApplyVo;

/**
 * <p>
 * 捐赠申请 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
public interface DonationApplyService extends IService<DonationApply> {

    PageVo<DonationApplyVo> findList(DonationApplyParam donationApplyParam);
}
