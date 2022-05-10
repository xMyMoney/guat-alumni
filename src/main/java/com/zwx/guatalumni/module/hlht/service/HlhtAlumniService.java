package com.zwx.guatalumni.module.hlht.service;

import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.zwx.guatalumni.module.hlht.model.entity.HlhtAlumni;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 校友表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
public interface HlhtAlumniService extends IService<HlhtAlumni> {

    CompareResult compareAlumni(Alumni alumni);
}
