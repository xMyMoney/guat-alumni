package com.zwx.guatalumni.module.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.module.information.model.entity.News;
import com.zwx.guatalumni.module.information.dao.NewsMapper;
import com.zwx.guatalumni.module.information.model.param.NewsParam;
import com.zwx.guatalumni.module.information.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 新闻表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findList(NewsParam newsParam) {
        IPage<News> page = new Page<>(newsParam.getCurrent(),newsParam.getPageSize());
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(newsParam.getTitle()),News::getTitle,newsParam.getTitle())
                .like(!StringUtils.isEmpty(newsParam.getContent()),News::getContent,newsParam.getContent())
                .eq(null != newsParam.getCategoryId(),News::getCategoryId,newsParam.getCategoryId());
        return newsMapper.selectPage(page,queryWrapper).getRecords();
    }

    @Override
    public void deleteBatch(List<Integer> ids) {

    }

    @Override
    public void defaultCategory(Integer categoryId) {
        newsMapper.defaultCategory(categoryId);
    }
}
