package com.zwx.guatalumni.module.alumni.service.impl;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Classes;
import com.zwx.guatalumni.module.alumni.dao.ClassesMapper;
import com.zwx.guatalumni.module.alumni.model.param.ClassesParam;
import com.zwx.guatalumni.module.alumni.model.vo.ClassesVo;
import com.zwx.guatalumni.module.alumni.service.ClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public PageVo<ClassesVo> findList(ClassesParam classesParam) {
        int total = classesMapper.getTotal(classesParam);
        classesParam.setCurrent((classesParam.getCurrent()-1) * classesParam.getPageSize());
        List<ClassesVo> list = classesMapper.getList(classesParam);
        return new PageVo<>(list,total);
    }
}
