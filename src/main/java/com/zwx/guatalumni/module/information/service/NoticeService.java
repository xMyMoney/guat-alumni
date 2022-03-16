package com.zwx.guatalumni.module.information.service;

import com.zwx.guatalumni.module.information.model.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.information.model.param.NoticeParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Service
public interface NoticeService extends IService<Notice> {

    void deleteBatch(List<Integer> ids);

    List<Notice> findList(NoticeParam noticeParam);
}
