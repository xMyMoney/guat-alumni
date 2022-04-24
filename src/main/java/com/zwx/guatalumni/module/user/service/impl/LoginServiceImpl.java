package com.zwx.guatalumni.module.user.service.impl;

import cn.hutool.core.date.DateUtil;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.module.alumni.dao.AlumniMapper;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.model.vo.LoginInfoVo;
import com.zwx.guatalumni.module.user.model.vo.UserInfoVo;
import com.zwx.guatalumni.module.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private AlumniMapper alumniMapper;

    @Override
    public BaseResp login(LoginParam loginParam) {
        BaseResp<LoginInfoVo> baseResp = new BaseResp<>();
        Alumni alumni = alumniMapper.getInfoByStuId(loginParam.getStuId());
        if (alumni == null) {
            baseResp.setErrMsg("该学号不存在");
            return baseResp;
        }
        if (!alumni.getPassword().equals(loginParam.getPassword())) {
            baseResp.setErrMsg("密码错误");
            return baseResp;
        }
        // 添加token
        LoginInfoVo loginInfo = new LoginInfoVo();
        loginInfo.setAlumni(alumniMapper.getLoginInfo(alumni.getId()));
        baseResp.setData(loginInfo);
        return baseResp;
    }

}
