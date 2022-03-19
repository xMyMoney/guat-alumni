package com.zwx.guatalumni.module.activity.dao;

import com.zwx.guatalumni.module.activity.model.entity.ActivityCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwx.guatalumni.module.activity.model.param.ActivityCategoryParam;
import com.zwx.guatalumni.module.activity.model.vo.ActivityCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 活动类别表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-16
 */
@Mapper
public interface ActivityCategoryMapper extends BaseMapper<ActivityCategory> {
    /**
     * 分页查询活动分类
     * @param param
     * @return
     */
    List<ActivityCategoryVo>  selectPage(ActivityCategoryParam param);
}
