package com.zwx.guatalumni.services;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.utils.JWTUtils;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void test() {
//        BaseResp login = loginService.login(new LoginParam("1", "123"));
    }
}
