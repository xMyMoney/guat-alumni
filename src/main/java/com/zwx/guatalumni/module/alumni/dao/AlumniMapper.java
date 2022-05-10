package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniCardParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.*;
import com.zwx.guatalumni.module.user.model.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    AlumniStatisticsVo statisticsById(@Param("id") String id);

    List<AlumniFriendVo> getCardList(AlumniCardParam alumniCardParam);

    AlumniInfoVo getAlumniInfo(int id);

    Alumni getInfoByStuId(@Param("stuId") String stuId);

    UserInfoVo getLoginInfo(@Param("id") Integer id);

    List<StarVo> getRecords();
}
