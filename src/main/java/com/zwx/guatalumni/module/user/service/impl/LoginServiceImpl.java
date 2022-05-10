package com.zwx.guatalumni.module.user.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.utils.JWTUtils;
import com.zwx.guatalumni.module.alumni.dao.AlumniMapper;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.model.vo.LoginInfoVo;
import com.zwx.guatalumni.module.user.model.vo.UserInfoVo;
import com.zwx.guatalumni.module.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

        LoginInfoVo loginInfo = new LoginInfoVo();
        loginInfo.setAlumni(alumniService.getLoginInfo(alumni.getId()));
        switch (loginInfo.getAlumni().getStatus()) {
            case 0:
                baseResp.setErrMsg("信息审核中");
                break;
            case 1:
                // 设置token
                Map<String, String> payload = new HashMap<>();
                payload.put("id", alumni.getId().toString());
                loginInfo.setToken(JWTUtils.getToken(payload));
                //更新登录时间
                updateLoginTime(loginInfo.getAlumni().getId());
                break;
            case 2:
                baseResp.setErrMsg("信息审核不通过");
                break;
            default:
                break;
        }
        baseResp.setData(loginInfo);
        return baseResp;
    }

    private void updateLoginTime(Integer id) {
        UpdateWrapper<Alumni> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .eq(Alumni::getId,id).set(Alumni::getLoginTime,new Date());
        alumniService.update(updateWrapper);
    }

}
