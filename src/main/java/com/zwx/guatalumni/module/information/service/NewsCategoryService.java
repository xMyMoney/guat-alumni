package com.zwx.guatalumni.module.information.service;

import com.zwx.guatalumni.common.model.OptionsVo;
import com.zwx.guatalumni.common.model.PageResult;
import com.zwx.guatalumni.module.information.model.entity.NewsCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.information.model.param.NewsCategoryParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻分类表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public interface NewsCategoryService extends IService<NewsCategory> {

    PageResult<NewsCategory> findList(NewsCategoryParam newsCategoryParam);

    void deleteBatch(List<Integer> ids);

    void delById(Integer id);

    List<OptionsVo> getCategoryOptions();
}
