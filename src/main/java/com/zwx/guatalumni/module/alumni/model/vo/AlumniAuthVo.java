package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
AlumniAuthVo {
    private Integer id;
    private Integer alumniId;
    private String stuId;
    private String username;
    private String academy;
    private String major;
    private String classes;
    private String endYear;
    private Integer status;
    private String compareInfo;
}
