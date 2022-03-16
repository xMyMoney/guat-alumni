package com.zwx.guatalumni.module.information.model.entity;

public class ResBean<T> {
    private String msg;
    private Integer code;
    private T data;

    public ResBean() {
    }

    public ResBean(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
