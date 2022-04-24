package com.zwx.guatalumni.module.user.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParam {
    private String avatar;
    private String username;
    private Integer gender;
    private String nation;
    private Date birthday;
    private String phone;
    private String address;
    private String company;
    private String jor;
    private String stuId;

}
