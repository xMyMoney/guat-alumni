package com.zwx.guatalumni.module.alumni.model.vo;

import lombok.Data;

/**
 * 分页列表数据
 * @author x
 */
@Data
public class AlumniListVo {
    /**
     * id
     */

    private Integer id;

    /**
     * 学号
     */
    private String stuId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 毕业年份
     */
    private String endYear;

    /**
     * 院系id
     */
    private String academy;

    /**
     * 专业id
     */
    private String major;


    /**
     * 星级
     */
    private Integer star;

    /**
     * 认证状态
     */
    private Integer status;
}
