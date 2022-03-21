package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.Classes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.param.ClassesParam;
import com.zwx.guatalumni.module.alumni.model.vo.ClassesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 班级表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Mapper
public interface ClassesMapper extends BaseMapper<Classes> {

    int getTotal(ClassesParam classesParam);

    List<ClassesVo> getList(ClassesParam classesParam);
}
