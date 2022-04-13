package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.AlumniFriend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniFriendVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 校友关系 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@Mapper
public interface AlumniFriendMapper extends BaseMapper<AlumniFriend> {

    List<AlumniFriendVo> getListById(@Param("friendIds") List<Integer> friendIds);
}
