package com.zwx.guatalumni.module.donation.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.activity.model.param.SearchParam;
import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.donation.model.param.DonationParam;
import com.zwx.guatalumni.module.donation.model.vo.DonationDetailVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationItemVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;

import java.util.List;

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

    boolean delDonation(Integer id);

    void checkStatus();

    List<OptionsVo> getOptions();

    List<DonationItemVo> getList();

    DonationDetailVo getOne(String id);

    List<DonationItemVo> getList(SearchParam searchParam);
}
