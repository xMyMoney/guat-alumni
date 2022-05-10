package com.zwx.guatalumni.module.alumni.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 校友表
 * </p>
 *
 * @author zwx
 * @since 2022-03-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumni implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

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
     * 院系id
     */
    private Integer academyId;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 班级id
     */
    private Integer classesId;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 认证状态
     */
    private Integer status;

    /**
     * 认证时间
     */
    private Date authTime;

    private String company;

    private String jor;

    private String password;

    private Date loginTime;

    public Alumni(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }
}
