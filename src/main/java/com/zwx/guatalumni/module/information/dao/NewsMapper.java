package com.zwx.guatalumni.module.information.dao;

import com.zwx.guatalumni.module.information.model.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 新闻表 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    void defaultCategory(Integer categoryId);
}
