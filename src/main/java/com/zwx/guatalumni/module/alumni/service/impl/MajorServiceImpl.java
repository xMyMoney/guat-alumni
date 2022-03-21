package com.zwx.guatalumni.module.alumni.service.impl;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Major;
import com.zwx.guatalumni.module.alumni.dao.MajorMapper;
import com.zwx.guatalumni.module.alumni.model.param.MajorParam;
import com.zwx.guatalumni.module.alumni.model.vo.MajorVo;
import com.zwx.guatalumni.module.alumni.service.MajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 专业表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

    @Autowired
    MajorMapper majorMapper;

    @Override
    public PageVo<MajorVo> findList(MajorParam majorParam) {
        int total = majorMapper.getTotal(majorParam);
        majorParam.setCurrent((majorParam.getCurrent()-1) * majorParam.getPageSize());
        List<MajorVo> list = majorMapper.getList(majorParam);
        return new PageVo<>(list,total);
    }
}
