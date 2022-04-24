package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.FriendApply;
import com.zwx.guatalumni.module.alumni.dao.FriendApplyMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.FriendApplyVo;
import com.zwx.guatalumni.module.alumni.service.FriendApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.alumni.service.AlumniFriendService;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 交换名片申请 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@Service
public class FriendApplyServiceImpl extends ServiceImpl<FriendApplyMapper, FriendApply> implements FriendApplyService {

    @Autowired
    FriendApplyMapper applyMapper;

    @Autowired
    AlumniService alumniService;

    @Autowired
    AlumniFriendService alumniFriendService;

    @Override
    public boolean updateById(AlumniApplyParam applyParam) {
        FriendApply applyInfo = applyMapper.getByApplyId(applyParam.getApplyId(),applyParam.getAlumniId());
        if (applyInfo != null) {
            applyInfo.setStatus(applyParam.getStatus());
            this.updateById(applyInfo);
            if (applyParam.getStatus() == 1) {
                if(alumniFriendService.relateAlumni(applyInfo.getAlumniId(),applyParam.getApplyId())) {
                    return this.removeById(applyInfo);
                }
            }
        }
        return true;
    }

    @Override
    public List<FriendApplyVo> getListApplyById(String id) {
        List<FriendApplyVo> applyVoList = new ArrayList<>();
        QueryWrapper<FriendApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(FriendApply::getAlumniId,id);
        List<FriendApply> applyList = this.list(queryWrapper);
        for (FriendApply apply : applyList) {
            FriendApplyVo applyVo = new FriendApplyVo();
            applyVo.setId(apply.getId());
            applyVo.setApplyId(apply.getApplyId());
            applyVo.setMessage(apply.getMessage());
            Alumni alumni = alumniService.getById(apply.getApplyId());
            applyVo.setUsername(alumni.getUsername());
            applyVo.setAvatar(alumni.getAvatar());
            applyVo.setGender(alumni.getGender());
            applyVoList.add(applyVo);
        }
        return applyVoList;
    }
}
