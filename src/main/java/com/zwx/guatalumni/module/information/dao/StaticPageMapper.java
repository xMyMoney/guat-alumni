package com.zwx.guatalumni.module.information.dao;

import com.zwx.guatalumni.module.information.model.entity.StaticPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 静态页面 Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2022-03-27
 */
@Mapper
public interface StaticPageMapper extends BaseMapper<StaticPage> {

    StaticPage getPageByType(@Param("page_type") String pageType);
}
