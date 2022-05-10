package com.zwx.guatalumni.module.alumni.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.hash.Hash;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zwx.guatalumni.common.constant.FileConstant;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.aliyun.service.SmsService;
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
import com.zwx.guatalumni.module.user.model.vo.UserInfoVo;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SmsService smsService;

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

    @Override
    public List<String> getPhoneNumbers(List<Integer> alumniIds) {
        List<Alumni> alumniList = this.listByIds(alumniIds);
        return alumniList.stream().map(Alumni::getPhone).collect(Collectors.toList());
    }

    @Override
    public void sendBirthdaySms() {
        List<Alumni> alumniList = this.list();
        String today = DateUtil.today().substring(5);
        for (Alumni alumni : alumniList) {
            String alumniBirthday = DateUtil.format(alumni.getBirthday(), "YYYY-MM-dd").substring(5);
            if (today.equals(alumniBirthday)) {
                smsService.sendBirthdaySms(alumni.getId());
            }
        }
    }

    @Override
    public List<OptionsVo> getOptions() {
        List<Alumni> alumniList = this.list();
        List<OptionsVo> optionsVos = new ArrayList<>();
        alumniList.forEach(v->optionsVos.add(new OptionsVo(v.getId(),v.getUsername())));
        return optionsVos;
    }

    @Override
    public UserInfoVo getLoginInfo(Integer id) {
        return alumniMapper.getLoginInfo(id);
    }

    @Override
    public void updateStar() {
        List<StarVo> starList = alumniMapper.getRecords();
        for (StarVo starVo : starList) {
            Integer star = getStar(starVo);
            UpdateWrapper<Alumni> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda()
                    .eq(Alumni::getId,starVo.getAlumniId())
                    .set(Alumni::getStar,star);
            this.update(updateWrapper);
        }
    }

    @Override
    public void export(HttpServletResponse response) {
        Workbook workbook = this.export();
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("content-Type", "application/vnd.ms-excel");
//            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(FileConstant.ALUMNI_INFO_NAME,"UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(FileConstant.ALUMNI_INFO_NAME,"UTF-8"));
            workbook.write(outputStream);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (workbook != null) {
                try {
                    workbook.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            IoUtil.close(outputStream);
        }
    }


    private Alumni getOne(String id) {
        return this.getById(id);
    }

    private Integer getStar(StarVo starVo) {
        Integer donationCount = starVo.getDonationCount();
        if (donationCount >= 0 && donationCount <= 2) {
            return 1;
        }else if(donationCount >= 3 && donationCount <= 4) {
            return 2;
        }else if(donationCount >= 5 && donationCount <= 8) {
            return 3;
        }else if(donationCount >= 9 && donationCount <= 15) {
            return 4;
        }else {
            return 5;
        }
    }

}
