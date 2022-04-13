package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.module.alumni.model.entity.AlumniFriend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniFriendVo;

import java.util.List;

/**
 * <p>
 * 校友关系 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
public interface AlumniFriendService extends IService<AlumniFriend> {

    List<AlumniFriendVo> findList(String id);

    /**
     * 关联校友使其成为双向好友
     * @param alumniId
     * @param applyId
     * @return
     */
    boolean relateAlumni(Integer alumniId, Integer applyId);

    List<Integer> getFriendIds(String alumniId);
}
