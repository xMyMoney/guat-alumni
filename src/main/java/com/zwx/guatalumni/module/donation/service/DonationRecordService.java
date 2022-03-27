package com.zwx.guatalumni.module.donation.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.donation.model.param.DonationRecordParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationRecordVo;

/**
 * <p>
 * 捐赠记录表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-26
 */
public interface DonationRecordService extends IService<DonationRecord> {

    PageVo<DonationRecordVo> findList(DonationRecordParam donationRecordParam);
}
