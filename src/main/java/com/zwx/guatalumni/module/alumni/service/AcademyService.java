package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Academy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AcademyParam;

/**
 * <p>
 * 院系表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
public interface AcademyService extends IService<Academy> {

    PageVo<Academy> findList(AcademyParam academyParam);
}
