package com.zwx.guatalumni.module.hlht.service.impl;

import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.zwx.guatalumni.module.alumni.service.CompareResultService;
import com.zwx.guatalumni.module.hlht.model.entity.HlhtAlumni;
import com.zwx.guatalumni.module.hlht.dao.HlhtAlumniMapper;
import com.zwx.guatalumni.module.hlht.service.HlhtAlumniService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 校友表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Service
public class HlhtAlumniServiceImpl extends ServiceImpl<HlhtAlumniMapper, HlhtAlumni> implements HlhtAlumniService {

    @Autowired
    private CompareResultService compareResultService;

    @Override
    public CompareResult compareAlumni(Alumni alumni) {
        CompareResult compareResult = compareResultService.getCompareResult(alumni.getId());
        if (compareResult == null) {
            compareResult = new CompareResult(alumni.getId(),1,"信息一致");
        }
        List<HlhtAlumni> hlhtAlumniList = this.list();
        boolean exist = hlhtAlumniList.stream().anyMatch(v -> v.getStuId().equals(alumni.getStuId()));
        if (!exist) {
            compareResult.setResultStatus(2);
            compareResult.setResultInfo("该学号不存在");
        }
        boolean isStudent = hlhtAlumniList.stream().anyMatch(v -> v.getUsername().equals(alumni.getUsername()));
        if (!isStudent) {
            compareResult.setResultStatus(2);
            compareResult.setResultInfo("姓名与学号不匹配");
        }
        return compareResult;
    }
}
