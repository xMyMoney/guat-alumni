package com.zwx.guatalumni.module.alumni.dao;

import com.zwx.guatalumni.module.alumni.model.entity.FriendApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 交换名片申请 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@Mapper
public interface FriendApplyMapper extends BaseMapper<FriendApply> {

    FriendApply getByApplyId(@Param("applyId") Integer applyId, @Param("alumniId") Integer alumniId);
}
