package com.zwx.guatalumni.module.user.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.user.model.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.user.model.param.AdminParam;
import com.zwx.guatalumni.module.user.model.param.LoginParam;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-27
 */
public interface AdminService extends IService<Admin> {

    BaseResp login(LoginParam loginParam);

    PageVo<Admin> getList(AdminParam adminParam);
}
