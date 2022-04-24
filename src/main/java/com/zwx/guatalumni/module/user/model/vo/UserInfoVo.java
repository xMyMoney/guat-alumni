package com.zwx.guatalumni.module.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {
    private Integer id;
    private String avatar;
    private String username;
    private String password;
    private Integer gender;
    private String birthday;
    private String phone;
    private String company;
    private String jor;
    private String address;
    private Integer star;
    private Integer beginYear;
    private Integer education;
    private String academy;
    private String major;
    private Integer status;
    private String stuId;
}
