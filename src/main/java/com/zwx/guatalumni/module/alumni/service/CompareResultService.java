package com.zwx.guatalumni.module.alumni.service;

import com.zwx.guatalumni.common.model.vo.PageVo;
import com.zwx.guatalumni.module.alumni.model.entity.CompareResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.guatalumni.module.alumni.model.param.AlumniParam;
import com.zwx.guatalumni.module.alumni.model.vo.AlumniAuthVo;

import java.util.List;

/**
 * <p>
 * 对比结果记录 服务类
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
public interface CompareResultService extends IService<CompareResult> {

    CompareResult getCompareResult(Integer id);

    PageVo<AlumniAuthVo> getAlumniAuthList(AlumniParam alumniParam);
}
