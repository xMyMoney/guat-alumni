package com.zwx.guatalumni.common.constant;

import com.zwx.guatalumni.common.utils.StringUtil;

public enum ResultType {

    SUCCESS(0, "成功"),
    REQUEST_PARA_ERROR(1, "参数不正确"),
    JSON_PARA_EXCEPTION(2, "JSON参数格式错误"),
    DB_OPERATE_ERROR(3, "数据库操作失败"),
    USER_NO_AUTH(4, "用户未授权"),
    SYS_SO_BUSY(5, "服务器忙"),
    USER_NO_LOGIN(6, "用户未登录"),
    OTHER_ERROR(7, "其他错误"),
    NEED_CONFIRM(8, "当保存操作时需要进行再次确认");

    private int value;
    private String desc;
    /**
     * 用户自定义显示内容
     */
    private String myDesc = null;

    ResultType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    /**
     * int到enum的转换函数
     *
     * @param value value
     * @return ResultType
     */
    public static ResultType valueOf(int value) {
        switch (value) {
            case 0:
                return SUCCESS;
            case 1:
                return REQUEST_PARA_ERROR;
            case 2:
                return JSON_PARA_EXCEPTION;
            case 3:
                return DB_OPERATE_ERROR;
            case 4:
                return USER_NO_AUTH;
            case 5:
                return SYS_SO_BUSY;
            case 6:
                return USER_NO_LOGIN;
            case 7:
                return OTHER_ERROR;
            default:
                return null;
        }

    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        String ret = StringUtil.validEmpty(myDesc) ? myDesc : desc;
        //清空自定义内容
        this.myDesc = null;
        return ret;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDesc(String desc) {
        this.myDesc = desc;
    }
}
