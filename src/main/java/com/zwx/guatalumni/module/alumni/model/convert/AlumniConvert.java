package com.zwx.guatalumni.module.alumni.model.convert;

import com.zwx.guatalumni.common.constant.CommonConstant;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.param.AlumniInfoParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthInfo;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniBaseInfo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author x
 */
@Mapper(componentModel = "spring")
public abstract class AlumniConvert {

    @Mappings(value = {
            @Mapping(source = "birthday",target = "birthday",dateFormat = "yyyy-MM-dd")
    })
    public abstract AlumniBaseInfo toBaseInfoVo(Alumni alumni);


    public abstract AlumniAuthInfo toAuthInfoVo(Alumni alumni);

    @Mappings(value = {
            @Mapping(source = "birthday",target = "birthday",dateFormat = "yyyy-MM-dd")
    })
    public abstract Alumni toAlumni(AlumniBaseInfo baseInfo);


    @Mappings(value = {
            @Mapping(source = "authTime",target = "authTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    public abstract Alumni toAlumni(AlumniAuthInfo authInfo);
    @AfterMapping
    protected void updateResult(AlumniAuthInfo authInfo,@MappingTarget Alumni alumni) {
        alumni.setAcademyId(authInfo.getAcademyMajorIds().get(0));
        alumni.setMajorId(authInfo.getAcademyMajorIds().get(1));
    }


    public abstract Alumni toAlumni(AlumniInfoParam alumniInfo);

    @AfterMapping
    protected void updateResult(AlumniInfoParam alumniInfo,@MappingTarget Alumni alumni) {
        alumni.setAcademyId(alumniInfo.getAcademyMajorIds().get(0));
        alumni.setMajorId(alumniInfo.getAcademyMajorIds().get(1));
    }


}
