package com.zwx.guatalumni.module.activity.dao;

import com.zwx.guatalumni.module.activity.model.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 校友活动表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}
