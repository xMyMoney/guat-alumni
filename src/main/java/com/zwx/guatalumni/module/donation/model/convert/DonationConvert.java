package com.zwx.guatalumni.module.donation.model.convert;

import com.zwx.guatalumni.module.donation.model.entity.Donation;
import com.zwx.guatalumni.module.donation.model.vo.DonationDetailVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationItemVo;
import com.zwx.guatalumni.module.donation.model.vo.DonationVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DonationConvert {

    public abstract List<DonationVo> toDonationVo(List<Donation> donation);

    public abstract DonationItemVo toDonationItem(Donation donation);

    public abstract List<DonationItemVo> toDonationItems(List<Donation> donation);

    public abstract DonationDetailVo toDonationDetail(Donation donation);
}
