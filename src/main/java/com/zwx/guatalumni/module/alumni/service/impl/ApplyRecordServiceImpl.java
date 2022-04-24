package com.zwx.guatalumni.module.alumni.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ApplyRecordDesc;
import com.zwx.guatalumni.common.constant.HandleApplyDesc;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.ApplyRecord;
import com.zwx.guatalumni.module.alumni.dao.ApplyRecordMapper;
import com.zwx.guatalumni.module.alumni.model.entity.BackApply;
import com.zwx.guatalumni.module.alumni.model.entity.ProveApply;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniApplyVo;
import com.zwx.guatalumni.module.alumni.service.ApplyRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.alumni.service.BackApplyService;
import com.zwx.guatalumni.module.alumni.service.ProveApplyService;
import com.zwx.guatalumni.module.donation.service.DonationApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 申请记录 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-20
 */
@Service
public class ApplyRecordServiceImpl extends ServiceImpl<ApplyRecordMapper, ApplyRecord> implements ApplyRecordService {

    @Autowired
    private BackApplyService backApplyService;

    @Autowired
    private ProveApplyService proveApplyService;

    @Autowired
    private DonationApplyService donationApplyService;

    @Override
    public PageVo<AlumniApplyVo> getList(String id) {
        List<AlumniApplyVo> backList =  backApplyService.listByApplyId(id);
        List<AlumniApplyVo> proveList = proveApplyService.listByApplyId(id);
        List<AlumniApplyVo> donationList = donationApplyService.listByApplyId(id);
        List<AlumniApplyVo> list = Stream.of(backList,proveList,donationList).flatMap(Collection::stream).collect(Collectors.toList());
        list.sort(Comparator.comparing(AlumniApplyVo::getApplyTime).reversed());
        return new PageVo<>(list,list.size());
    }
}
