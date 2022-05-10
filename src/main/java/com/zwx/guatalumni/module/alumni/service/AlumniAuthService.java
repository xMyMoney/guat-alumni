package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.param.HandleApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthVo;

public interface AlumniAuthService {
    PageVo<AlumniAuthVo> getList(AlumniParam alumniParam);

    void handleStatus(HandleApplyParam handleParam);

    void removeById(String id);
}
