package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendApplyVo {
    private Integer id;
    private Integer applyId;
    private String username;
    private String avatar;
    private Integer gender;
    private String message;
}
