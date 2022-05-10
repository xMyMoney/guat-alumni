package com.zwx.guatalumni.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.common.utils.JWTUtils;
import com.zwx.guatalumni.module.user.model.entity.Admin;
import com.zwx.guatalumni.module.user.dao.AdminMapper;
import com.zwx.guatalumni.module.user.model.param.AdminParam;
import com.zwx.guatalumni.module.user.model.param.LoginParam;
import com.zwx.guatalumni.module.user.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-27
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public BaseResp login(LoginParam loginParam) {
        BaseResp<String> baseResp = new BaseResp<>();
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Admin::getUsername,loginParam.getUsername());
        Admin admin = this.getOne(queryWrapper);
        if (admin == null) {
            baseResp.setErrMsg("用户不存在");
            return baseResp;
        }
        if (!admin.getPassword().equals(loginParam.getPassword())) {
            baseResp.setErrMsg("密码错误");
            return baseResp;
        }
        Map<String, String> payload = new HashMap<>();
        payload.put("id", admin.getId().toString());
        baseResp.setData(JWTUtils.getToken(payload));
        return baseResp;
    }

    @Override
    public PageVo<Admin> getList(AdminParam adminParam) {
        IPage<Admin> page = new Page<>(adminParam.getCurrent(),adminParam.getPageSize());
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        this.page(page,queryWrapper);
        return new PageVo<>(page.getRecords(),page.getTotal());
    }
}
