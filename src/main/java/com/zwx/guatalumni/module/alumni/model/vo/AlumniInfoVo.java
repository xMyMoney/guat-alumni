package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniInfoVo {
    private Integer id;

    /**--*+
     * 头像
     */
    private String avatar;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 星级
     */
    private Integer star;

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

    private List<Integer> academyMajorIds;
}
