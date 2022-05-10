package com.zwx.guatalumni.module.hlht.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 校友表
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
public class HlhtAlumni implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
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
     * 所属公司
     */
    private String company;

    /**
     * 职位
     */
    private String jor;

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

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 密码
     */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJor() {
        return jor;
    }

    public void setJor(String jor) {
        this.jor = jor;
    }

    public String getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(String beginYear) {
        this.beginYear = beginYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HlhtAlumni{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", avatar=" + avatar +
        ", username=" + username +
        ", gender=" + gender +
        ", nation=" + nation +
        ", birthday=" + birthday +
        ", phone=" + phone +
        ", address=" + address +
        ", company=" + company +
        ", jor=" + jor +
        ", beginYear=" + beginYear +
        ", endYear=" + endYear +
        ", stuId=" + stuId +
        ", education=" + education +
        ", academyId=" + academyId +
        ", majorId=" + majorId +
        ", classesId=" + classesId +
        ", star=" + star +
        ", status=" + status +
        ", authTime=" + authTime +
        ", loginTime=" + loginTime +
        ", password=" + password +
        "}";
    }
}
