package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.zwx.guatalumni.module.alumni.dao.CompareResultMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthVo;
import com.zwx.guatalumni.module.alumni.service.CompareResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 对比结果记录 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Service
public class CompareResultServiceImpl extends ServiceImpl<CompareResultMapper, CompareResult> implements CompareResultService {

    @Autowired
    private CompareResultMapper compareResultMapper;

    @Override
    public CompareResult getCompareResult(Integer id) {
        QueryWrapper<CompareResult> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CompareResult::getAlumniId,id);
        return this.getOne(queryWrapper);
    }

    @Override
    public PageVo<AlumniAuthVo> getAlumniAuthList(AlumniParam alumniParam) {
        alumniParam.setCurrent((alumniParam.getCurrent()-1)*alumniParam.getPageSize());
        List<AlumniAuthVo> list = compareResultMapper.getList(alumniParam);
        int total = compareResultMapper.getTotal(alumniParam);
        return new PageVo<>(list,total);
    }
}
