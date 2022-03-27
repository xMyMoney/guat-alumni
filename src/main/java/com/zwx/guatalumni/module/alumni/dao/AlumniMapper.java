package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthInfo;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 校友表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Mapper
public interface AlumniMapper extends BaseMapper<Alumni> {

    int getTotal(AlumniParam alumniParam);

    List<AlumniListVo> getList(AlumniParam alumniParam);

    AlumniAuthInfo getAuthInfo(String id);
}
