package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniBaseInfo {

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
     * 认证状态
     */
    private Integer status;
}
