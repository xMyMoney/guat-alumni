package com.zwx.guatalumni.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.user.model.param.RegisterParam;
import org.springframework.stereotype.Service;

public interface RegisterService extends IService<Alumni> {
    BaseResp<Void> register(Alumni registerParam);
}
