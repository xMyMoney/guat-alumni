package com.zwx.guatalumni.module.alumni.model.convert;

import com.zwx.guatalumni.common.constant.CommonConstant;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
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


    public abstract Alumni toAlumni(AlumniAuthInfo authInfo);


}
