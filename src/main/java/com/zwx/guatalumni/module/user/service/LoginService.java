package com.zwx.guatalumni.module.user.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    BaseResp login(LoginParam loginParam);
}
