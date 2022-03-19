package com.zwx.guatalumni.module.information.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.information.model.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.information.model.param.NewsParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public interface NewsService extends IService<News> {

    PageVo<News> findList(NewsParam newsParam);

    void deleteBatch(List<Integer> ids);

    void defaultCategory(Integer categoryId);
}
