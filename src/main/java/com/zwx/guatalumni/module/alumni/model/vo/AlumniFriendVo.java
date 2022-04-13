package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 校友名片
 * @author x
 */
@Data
@AllArgsConstructor
public class AlumniFriendVo {
    private Integer id;
    private String avatar;
    private String username;
    private Integer gender;
    private String major;
    private String address;
    private String beginYear;
    private String endYear;
    private String education;
    private String company;
    private String jor;
    private Date loginTime;
    private String phone;
    private Boolean isFriend;

    public AlumniFriendVo() {
        this.isFriend = false;
    }
}
