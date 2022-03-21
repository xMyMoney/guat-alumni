package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.param.MajorParam;
import com.zwx.guatalumni.module.alumni.model.vo.MajorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 专业表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Mapper
public interface MajorMapper extends BaseMapper<Major> {

    int getTotal(MajorParam majorParam);

    List<MajorVo> getList(MajorParam majorParam);
}
