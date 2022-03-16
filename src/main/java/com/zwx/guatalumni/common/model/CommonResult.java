package com.zwx.guatalumni.common.model;


import com.zwx.guatalumni.common.constant.ResultCode;

/**
 * 自定义统一响应体
 */
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param msg 提示信息
     * @param data    获取的数据
     */
    public static <T> CommonResult<T> success(String msg, T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 失败返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> error(T data) {
        return new CommonResult<>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg(), data);
    }

    /**
     * 失败返回结果
     *
     * @param msg 提示信息
     * @param data    获取的数据
     */
    public static <T> CommonResult<T> error(String msg, T data) {
        return new CommonResult<>(ResultCode.ERROR.getCode(), msg, data);
    }
}

