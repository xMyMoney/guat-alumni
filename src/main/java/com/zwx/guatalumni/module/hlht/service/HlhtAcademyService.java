package com.zwx.guatalumni.module.hlht.service;

import com.zwx.guatalumni.common.model.vo.OptionsTreeVo;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.module.hlht.model.entity.HlhtAcademy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 院系表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
public interface HlhtAcademyService extends IService<HlhtAcademy> {

    List<OptionsVo> getOptions();

    List<OptionsTreeVo> getTree();
}
