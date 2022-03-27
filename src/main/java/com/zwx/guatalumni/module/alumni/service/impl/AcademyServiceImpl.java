package com.zwx.guatalumni.module.alumni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Academy;
import com.zwx.guatalumni.module.alumni.dao.AcademyMapper;
import com.zwx.guatalumni.module.alumni.model.param.AcademyParam;
import com.zwx.guatalumni.module.alumni.service.AcademyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 院系表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyMapper, Academy> implements AcademyService {

    @Autowired
    AcademyMapper academyMapper;

    @Override
    public PageVo<Academy> findList(AcademyParam academyParam) {
        IPage<Academy> page = new Page<>(academyParam.getCurrent(),academyParam.getPageSize());
        QueryWrapper<Academy> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(!StringUtils.isEmpty(academyParam.getName()),Academy::getName,academyParam.getName())
                .like(!StringUtils.isEmpty(academyParam.getOldName()),Academy::getOldName,academyParam.getOldName());
        return new PageVo<>(academyMapper.selectPage(page,queryWrapper).getRecords(),academyMapper.selectCount(queryWrapper));
    }

    @Override
    public List<OptionsVo> getOptions() {
        List<Academy> list = this.list();
        List<OptionsVo> options = new ArrayList<>();
        list.forEach(v -> {
            options.add(new OptionsVo(v.getId(),v.getName()));
        });
        return options;
    }
}
