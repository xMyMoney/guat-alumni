package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.module.alumni.model.entity.AlumniFriend;
import com.zwx.guatalumni.module.alumni.dao.AlumniFriendMapper;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniFriendVo;
import com.zwx.guatalumni.module.alumni.service.AlumniFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 校友关系 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@Service
public class AlumniFriendServiceImpl extends ServiceImpl<AlumniFriendMapper, AlumniFriend> implements AlumniFriendService {

    @Autowired
    AlumniFriendMapper alumniFriendMapper;

    @Override
    public List<AlumniFriendVo> findList(String id) {
        List<Integer> friendIds = getFriendIds(id);
        if(!friendIds.isEmpty()) {
            List<AlumniFriendVo> friendVos = alumniFriendMapper.getListById(friendIds);
            friendVos.stream().forEach(v->v.setIsFriend(true));
            return friendVos;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean relateAlumni(Integer alumniId, Integer applyId) {
        this.save(new AlumniFriend(alumniId,applyId));
        this.save(new AlumniFriend(applyId,alumniId));
        return true;
    }

    @Override
    public List<Integer> getFriendIds(String alumniId) {
        QueryWrapper<AlumniFriend> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AlumniFriend::getAlumniId,alumniId);
        List<AlumniFriend> alumniFriendList = this.list(queryWrapper);
        List<Integer> friendIds = alumniFriendList.stream().map(AlumniFriend::getFriendId).collect(Collectors.toList());
        return friendIds;
    }
}
