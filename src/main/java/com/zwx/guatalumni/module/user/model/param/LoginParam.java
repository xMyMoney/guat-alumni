package com.zwx.guatalumni.module.user.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParam {

    private String username;
    private String stuId;
    private String password;
}
