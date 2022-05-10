package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 对比结果记录 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Mapper
public interface CompareResultMapper extends BaseMapper<CompareResult> {

    List<AlumniAuthVo> getList(AlumniParam alumniParam);

    int getTotal(AlumniParam alumniParam);
}
