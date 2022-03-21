package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.MajorParam;
import com.zwx.guatalumni.module.alumni.model.vo.MajorVo;

/**
 * <p>
 * 专业表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
public interface MajorService extends IService<Major> {

    PageVo<MajorVo> findList(MajorParam majorParam);
}
