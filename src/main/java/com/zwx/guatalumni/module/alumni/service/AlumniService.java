package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniListVo;

/**
 * <p>
 * 校友表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
public interface AlumniService extends IService<Alumni> {

    PageVo<AlumniListVo> findList(AlumniParam alumniParam);
}
