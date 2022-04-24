package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.ApplyRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 申请记录 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Mapper
public interface ApplyRecordMapper extends BaseMapper<ApplyRecord> {

    List<AlumniApplyVo> getList(@Param("id") String id);
}
