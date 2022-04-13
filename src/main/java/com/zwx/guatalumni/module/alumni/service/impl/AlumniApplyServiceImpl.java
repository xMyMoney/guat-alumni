package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.AlumniApply;
import com.zwx.guatalumni.module.alumni.dao.AlumniApplyMapper;
import com.zwx.guatalumni.module.alumni.model.entity.AlumniFriend;
import com.zwx.guatalumni.module.alumni.model.param.AlumniApplyParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.alumni.service.AlumniApplyService;
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
public class AlumniApplyServiceImpl extends ServiceImpl<AlumniApplyMapper, AlumniApply> implements AlumniApplyService {

    @Autowired
    AlumniApplyMapper applyMapper;

    @Autowired
    AlumniService alumniService;

    @Autowired
    AlumniFriendService alumniFriendService;

    @Override
    public boolean updateById(AlumniApplyParam applyParam) {
        AlumniApply applyInfo = applyMapper.getByApplyId(applyParam.getApplyId(),applyParam.getAlumniId());
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
    public List<AlumniApplyVo> getListApplyById(String id) {
        List<AlumniApplyVo> applyVoList = new ArrayList<>();
        QueryWrapper<AlumniApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AlumniApply::getAlumniId,id);
        List<AlumniApply> applyList = this.list(queryWrapper);
        for (AlumniApply apply : applyList) {
            AlumniApplyVo applyVo = new AlumniApplyVo();
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
