package com.zwx.guatalumni.module.hlht.service.impl;

import com.zwx.guatalumni.common.model.vo.OptionsTreeVo;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.module.hlht.model.entity.HlhtAcademy;
import com.zwx.guatalumni.module.hlht.dao.HlhtAcademyMapper;
import com.zwx.guatalumni.module.hlht.model.entity.HlhtMajor;
import com.zwx.guatalumni.module.hlht.service.HlhtAcademyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwx.guatalumni.module.hlht.service.HlhtMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 院系表 服务实现类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Service
public class HlhtAcademyServiceImpl extends ServiceImpl<HlhtAcademyMapper, HlhtAcademy> implements HlhtAcademyService {

    @Autowired
    private HlhtMajorService hlhtMajorService;

    @Override
    public List<OptionsVo> getOptions() {
        List<HlhtAcademy> list = this.list();
        List<OptionsVo> options = new ArrayList<>();
        list.forEach(v -> {
            options.add(new OptionsVo(v.getId(),v.getName()));
        });
        return options;
    }

    @Override
    public List<OptionsTreeVo> getTree() {
        List<HlhtAcademy> academyList = this.list();
        List<HlhtMajor> majorList = hlhtMajorService.list();
        List<OptionsTreeVo> tree = new ArrayList<>();
        for (HlhtAcademy academy : academyList) {
            OptionsTreeVo optionsTreeVo = new OptionsTreeVo(academy.getId(),academy.getName());
            List<HlhtMajor> collect = majorList.stream().filter(v -> v.getAcademyId().equals(academy.getId())).collect(Collectors.toList());
            List<OptionsVo> options = new ArrayList<>();
            collect.forEach(v -> {
                options.add(new OptionsVo(v.getId(),v.getName()));
            });
            optionsTreeVo.setChildren(options);
            tree.add(optionsTreeVo);
        }
        return tree;
    }
}
