package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Classes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.ClassesParam;
import com.zwx.guatalumni.module.alumni.model.vo.ClassesVo;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
public interface ClassesService extends IService<Classes> {

    PageVo<ClassesVo> findList(ClassesParam classesParam);
}
