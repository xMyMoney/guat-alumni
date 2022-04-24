package com.zwx.guatalumni.module.information.service.impl;

import com.zwx.guatalumni.module.information.model.entity.StaticPage;
import com.zwx.guatalumni.module.information.dao.StaticPageMapper;
import com.zwx.guatalumni.module.information.service.StaticPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 静态页面 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-27
 */
@Service
public class StaticPageServiceImpl extends ServiceImpl<StaticPageMapper, StaticPage> implements StaticPageService {

    @Autowired
    private StaticPageMapper staticPageMapper;

    @Override
    public StaticPage getPageInfo(String pageType) {
        return staticPageMapper.getPageByType(pageType);
    }
}
