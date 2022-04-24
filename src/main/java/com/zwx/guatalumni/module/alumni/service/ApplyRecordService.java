package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.ApplyRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;

/**
 * <p>
 * 申请记录 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
public interface ApplyRecordService extends IService<ApplyRecord> {

    PageVo<AlumniApplyVo> getList(String id);
}
