package com.zwx.guatalumni.module.information.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.module.information.model.entity.Notice;
import com.zwx.guatalumni.module.information.dao.NoticeMapper;
import com.zwx.guatalumni.module.information.model.param.NoticeParam;
import com.zwx.guatalumni.module.information.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findList(NoticeParam noticeParam) {
        IPage<Notice> page = new Page<>(noticeParam.getCurrent(),noticeParam.getPageSize());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(noticeParam.getTitle()),Notice::getTitle,noticeParam.getTitle())
                .like(!StringUtils.isEmpty(noticeParam.getContent()),Notice::getContent,noticeParam.getContent());
        return noticeMapper.selectPage(page,queryWrapper).getRecords();
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        noticeMapper.deleteBatchIds(ids);
    }


}
