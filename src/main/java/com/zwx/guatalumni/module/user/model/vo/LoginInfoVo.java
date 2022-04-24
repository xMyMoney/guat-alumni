package com.zwx.guatalumni.module.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoVo {
    private UserInfoVo alumni;
    private String token;
}
