package com.zwx.guatalumni.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "BaseParam", description = "请求参数基类")
public class BaseParam implements BaseEntity {
    @ApiModelProperty(value = "请求token", required = true, notes = "常在请求头中添加，具体请求可以不用重复添加", hidden = true)
    private String token;
    @ApiModelProperty(value = "当前登录用户主键", hidden = true)
    private String currUserPkId;
    @ApiModelProperty(value = "当前登录角色主键", notes = "默认不传", hidden = true)
    private String currRolePkId;
    @ApiModelProperty(value = "当前登录用户名称", notes = "默认不传", hidden = true)
    private String currUserName;
    @ApiModelProperty(value = "语言类型", notes = "默认中文简写", hidden = true)
    private int lang = 1;
    @ApiModelProperty(value = "角色类型", notes = "默认不传", hidden = true)
    private int currRoleType;
    @ApiModelProperty(value = "运营商组织机构代码（9位）", notes = "默认不传", hidden = true)
    private String currOperatorId;
    @ApiModelProperty(value = "角色区域Id", notes = "默认不传", hidden = true)
    private int currRoleAreaCode;

    /**
     * 除APP请求之外的请求，以下字段采用Session中的数据
     */
    public void setEmptyAuthParam() {
        this.token = "";
        this.currUserPkId = "";
        this.currRolePkId = "";
        this.currUserName = "";
        this.currRoleType = 0;
        this.currOperatorId = null;
        this.currRoleAreaCode = 1;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCurrUserPkId() {
        return currUserPkId;
    }

    public void setCurrUserPkId(String currUserPkId) {
        this.currUserPkId = currUserPkId;
    }

    public String getCurrRolePkId() {
        return currRolePkId;
    }

    public void setCurrRolePkId(String currRolePkId) {
        this.currRolePkId = currRolePkId;
    }

    public String getCurrUserName() {
        return currUserName;
    }

    public void setCurrUserName(String currUserName) {
        this.currUserName = currUserName;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public int getCurrRoleType() {
        return currRoleType;
    }

    public void setCurrRoleType(int currRoleType) {
        this.currRoleType = currRoleType;
    }

    public String getCurrOperatorId() {
        return currOperatorId;
    }

    public void setCurrOperatorId(String currOperatorId) {
        this.currOperatorId = currOperatorId;
    }

    public int getCurrRoleAreaCode() {
        return currRoleAreaCode == 0 ? 1 : currRoleAreaCode;
    }

    public void setCurrRoleAreaCode(int currRoleAreaCode) {
        this.currRoleAreaCode = currRoleAreaCode;
    }
}
