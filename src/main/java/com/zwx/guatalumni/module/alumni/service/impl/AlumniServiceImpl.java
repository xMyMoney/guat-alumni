package com.zwx.guatalumni.module.alumni.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.hash.Hash;
import com.zwx.guatalumni.common.constant.FileConstant;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.zwx.guatalumni.module.alumni.dao.AlumniMapper;
import com.zwx.guatalumni.module.alumni.model.param.AlumniCardParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniInfoParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.*;
import com.zwx.guatalumni.module.alumni.model.convert.AlumniConvert;
import com.zwx.guatalumni.module.alumni.service.AlumniFriendService;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

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

    @Autowired
    private AlumniFriendService alumniFriendService;

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
        AlumniAuthInfo authInfo = alumniMapper.getAuthInfo(id);
        authInfo.setAcademyMajorIds(ListUtil.toList(7,3));
        return authInfo;
    }

    @Override
    public boolean save(AlumniInfoParam alumniInfo) {
        Alumni alumni = alumniConvert.toAlumni(alumniInfo);
        return this.save(alumni);
    }

    @Override
    public Workbook export() {
        List<Alumni> alumniList = this.list();
        Workbook workbook = null;
        TemplateExportParams exportParams = new TemplateExportParams(FileConstant.ALUMNI_INFO_EXPORT, 0);
        Map<String ,Object> data = new HashMap<>();
        List<Map<String ,Object>> sheetData = new ArrayList<>();
        if (!alumniList.isEmpty()) {
            int id = 1;
            for (Alumni alumni : alumniList) {
                Map<String ,Object> row = new HashMap<>();
                row.put("id",id++);
                row.put("username",alumni.getUsername());
                row.put("gender",alumni.getGender());
                row.put("nation",alumni.getNation());
                row.put("birthday",alumni.getBirthday());
                row.put("phone",alumni.getPhone());
                row.put("address",alumni.getAddress());
                row.put("stuId",alumni.getStuId());
                row.put("education",alumni.getEducation());
                row.put("beginYear",alumni.getBeginYear());
                row.put("endYear",alumni.getEndYear());
                row.put("academy",alumni.getAcademyId());
                row.put("major",alumni.getMajorId());
                sheetData.add(row);
            }
        }
        data.put("mapList",sheetData);
        workbook = ExcelExportUtil.exportExcel(exportParams,data);
        return workbook;
    }

    @Override
    public AlumniStatisticsVo getStatistics(String id) {
        return alumniMapper.statisticsById(id);
    }

    @Override
    public PageVo<AlumniFriendVo> findList(AlumniCardParam alumniCardParam) {
        alumniCardParam.setCurrent((alumniCardParam.getCurrent()-1)*alumniCardParam.getPageSize());
        List<AlumniFriendVo> list = alumniMapper.getCardList(alumniCardParam);
        List<Integer> friendIds = alumniFriendService.getFriendIds(alumniCardParam.getAlumniId());
        for (int i = 0; i < list.size(); i++) {
            if (friendIds.contains(list.get(i).getId())) {
                list.get(i).setIsFriend(true);
            }
        }
        return new PageVo<>(list,0);
    }

    @Override
    public AlumniInfoVo login() {
        return  alumniMapper.getAlumniInfo(1);
    }

    private Alumni getOne(String id) {
        return this.getById(id);
    }
}
