package com.zwx.guatalumni.module.information.service;

import com.zwx.guatalumni.module.information.model.entity.StaticPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 静态页面 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-27
 */
@Service
public interface StaticPageService extends IService<StaticPage> {

    StaticPage getPageInfo(String pageType);
}
