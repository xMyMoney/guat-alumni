package com.zwx.guatalumni.module.user.dao;

import com.zwx.guatalumni.module.user.model.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-04-27
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
