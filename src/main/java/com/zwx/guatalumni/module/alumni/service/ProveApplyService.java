package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.ApplyParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;

import java.util.List;

/**
 * <p>
 * 证明申请 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
public interface ProveApplyService extends IService<ProveApply> {

    BaseResp<Void> proveApply(ProveApply applyParam);

    List<AlumniApplyVo> listByApplyId(String id);

    void handle(HandleApplyParam handleApplyParam);

    PageVo<ProveApply> list(ApplyParam applyParam);
}
