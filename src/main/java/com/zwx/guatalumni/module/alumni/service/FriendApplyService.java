package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.module.alumni.model.entity.FriendApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AlumniApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.FriendApplyVo;

import java.util.List;

/**
 * <p>
 * 交换名片申请 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
public interface FriendApplyService extends IService<FriendApply> {


    boolean updateById(AlumniApplyParam applyParam);

    List<FriendApplyVo> getListApplyById(String id);
}
