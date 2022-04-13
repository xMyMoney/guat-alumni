package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.module.alumni.model.entity.AlumniApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AlumniApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;

import java.util.List;

/**
 * <p>
 * 交换名片申请 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
public interface AlumniApplyService extends IService<AlumniApply> {


    boolean updateById(AlumniApplyParam applyParam);

    List<AlumniApplyVo> getListApplyById(String id);
}
