package com.zwx.guatalumni.module.alumni.model.convert;

import com.zwx.guatalumni.common.constant.ApplyRecordDesc;
import com.zwx.guatalumni.common.constant.HandleApplyDesc;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.donation.model.entity.DonationApply;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ApplyInfoConvert {


    @Mappings(value = {
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "status",target = "applyStatus"),
            @Mapping(source = "createTime",target = "applyTime",dateFormat = "yyyy-MM-dd")
    })
    public abstract AlumniApplyVo toAlumniApplyVo(BackApply applyInfo);

    @AfterMapping
    protected void updateResult(@MappingTarget AlumniApplyVo alumniApplyVo,BackApply backApply) {
        alumniApplyVo.setApplyType(ApplyRecordDesc.BackSchool.getApplyDesc());
    }

    public abstract List<AlumniApplyVo> backApplyToAlumniApplyVoList(List<BackApply> applyList);

    @Mappings(value = {
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "status",target = "applyStatus"),
            @Mapping(source = "createTime",target = "applyTime",dateFormat = "yyyy-MM-dd")
    })
    public abstract AlumniApplyVo toAlumniApplyVo(ProveApply proveApply);

    @AfterMapping
    protected void updateResult(@MappingTarget AlumniApplyVo alumniApplyVo,ProveApply proveApply) {
        if (proveApply.getProveType().equals(ApplyRecordDesc.DEGREE.getApplyType())) {
            alumniApplyVo.setApplyType(ApplyRecordDesc.DEGREE.getApplyDesc());
        }else {
            alumniApplyVo.setApplyType(ApplyRecordDesc.GRADUATION.getApplyDesc());
        }
    }

    public abstract List<AlumniApplyVo> proveApplyToAlumniApplyVoList(List<ProveApply> applyList);


    @Mappings(value = {
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "status",target = "applyStatus"),
            @Mapping(source = "createTime",target = "applyTime",dateFormat = "yyyy-MM-dd")
    })
    public abstract AlumniApplyVo toAlumniApplyVo(DonationApply applyInfo);

    @AfterMapping
    protected void updateResult(@MappingTarget AlumniApplyVo alumniApplyVo,DonationApply donationApply) {
        alumniApplyVo.setApplyType(ApplyRecordDesc.DONATION.getApplyDesc());
    }

    public abstract List<AlumniApplyVo> donationApplyToAlumniApplyVoList(List<DonationApply> applyList);
}
