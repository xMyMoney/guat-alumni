package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.Data;

@Data
public class AlumniAuthInfo {

    private Integer id;

    /**
     * 入学年份
     */
    private String beginYear;

    /**
     * 毕业年份
     */
    private String endYear;

    /**
     * 学号
     */
    private String stuId;

    /**
     * 学历id
     */
    private Integer education;

    /**
     * 院系
     */
    private String academy;

    /**
     * 专业id
     */
    private String major;

    /**
     * 认证状态
     */
    private Integer status;

    /**
     * 认证时间
     */
    private String authTime;
}
