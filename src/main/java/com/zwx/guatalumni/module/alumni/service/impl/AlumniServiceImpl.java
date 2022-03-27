package com.zwx.guatalumni.module.alumni.service.impl;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.dao.AlumniMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthInfo;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniBaseInfo;
import com.zwx.guatalumni.module.alumni.model.convert.AlumniConvert;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniListVo;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
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
 * @since 2022-03-20
 */
@Service
public class AlumniServiceImpl extends ServiceImpl<AlumniMapper, Alumni> implements AlumniService {

    @Autowired
    AlumniMapper alumniMapper;

    @Autowired
    AlumniConvert alumniConvert;

    @Override
    public PageVo<AlumniListVo> findList(AlumniParam alumniParam) {
        int total = alumniMapper.getTotal(alumniParam);
        alumniParam.setCurrent((alumniParam.getCurrent() - 1) * alumniParam.getPageSize());
        List<AlumniListVo> list = alumniMapper.getList(alumniParam);
        return new PageVo<>(list,total);
    }

    @Override
    public AlumniBaseInfo getBaseInfoById(String id) {
        Alumni alumni = getOne(id);
        return alumniConvert.toBaseInfoVo(alumni);
    }

    @Override
    public AlumniAuthInfo getAuthInfoById(String id) {
        return alumniMapper.getAuthInfo(id);
    }

    private Alumni getOne(String id) {
        return this.getById(id);
    }
}
