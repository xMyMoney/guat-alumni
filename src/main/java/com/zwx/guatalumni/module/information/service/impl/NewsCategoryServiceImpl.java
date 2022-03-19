package com.zwx.guatalumni.module.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.information.model.entity.NewsCategory;
import com.zwx.guatalumni.module.information.dao.NewsCategoryMapper;
import com.zwx.guatalumni.module.information.model.param.NewsCategoryParam;
import com.zwx.guatalumni.module.information.service.NewsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.information.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 新闻分类表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements NewsCategoryService {

    @Autowired
    private NewsCategoryMapper categoryMapper;

    @Autowired
    private NewsService newsService;

    @Override
    public PageVo<NewsCategory> findList(NewsCategoryParam newsCategoryParam) {
        IPage<NewsCategory> page = new Page<>(newsCategoryParam.getCurrent(), newsCategoryParam.getPageSize());
        QueryWrapper<NewsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(newsCategoryParam.getName()), NewsCategory::getName, newsCategoryParam.getName());
        return new PageVo<>(categoryMapper.selectPage(page,queryWrapper).getRecords(),this.count());
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        categoryMapper.deleteBatchIds(ids);
    }

    @Override
    public void delById(Integer id) {
        if (id == 0) {
            return;
        }
        this.removeById(id);
        newsService.defaultCategory(id);
    }

    @Override
    public List<OptionsVo> getCategoryOptions() {
        List<NewsCategory> categories = this.list();
        List<OptionsVo> options = new ArrayList<>();
        categories.forEach(v -> {
            options.add(new OptionsVo(v.getId(),v.getName()));
        });
        return options;
    }
}
