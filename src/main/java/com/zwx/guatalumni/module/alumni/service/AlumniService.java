package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.model.vo.OptionsVo;
import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.Alumni;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AlumniCardParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniInfoParam;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.*;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * <p>
 * 校友表 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
public interface AlumniService extends IService<Alumni> {


    PageVo<AlumniListVo> findList(AlumniParam alumniParam);

    AlumniBaseInfo getBaseInfoById(String id);

    AlumniAuthInfo getAuthInfoById(String id);

    boolean save(AlumniInfoParam alumniInfo);

    Workbook export();

    AlumniStatisticsVo getStatistics(String id);

    PageVo<AlumniFriendVo> findList(AlumniCardParam alumniCardParam);

    AlumniInfoVo login();

    List<String> getPhoneNumbers(List<Integer> alumniIds);

    void sendBirthdaySms();

    List<OptionsVo> getOptions();
}
