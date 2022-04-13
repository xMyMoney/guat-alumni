package com.zwx.guatalumni.module.alumni.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniInfoParam {


    private Integer id;

    /**
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
    private Date birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 详细地址
     */
    private String address;

    private String company;

    private String jor;

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
     * 院系专业id
     */
    private List<Integer> academyMajorIds;



    /**
     * 星级
     */
    private Integer star;


}
