package com.zwx.guatalumni.common.exception;


import com.zwx.guatalumni.common.base.BaseResp;
import com.zwx.guatalumni.common.constant.ResultType;

/**
 * @name: ReturnValuesRuntimeException.java
 * @author: andy
 * @date: 2017/10/30
 * @version: 1.0
 * @Description: 带返回值的运行时异常，用于触发事务回滚的同时，同步返回分页格式返回体
 */
public class ReturnPageValuesRuntimeException extends RuntimeException {
    /**
     * 返回结果值
     */
    private int retStatus;

    /**
     * 返回结果描述
     */
    private String retMsg;

    /**
     * 构造带但返回值的运行时异常
     *
     * @param errMessage 异常描述信息
     */
    public ReturnPageValuesRuntimeException(String errMessage) {
        super(errMessage);
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param resultType 返回类型枚举
     * @param errMessage 异常描述信息
     */
    public ReturnPageValuesRuntimeException(ResultType resultType, String errMessage) {
        super(errMessage);
        this.retStatus = resultType.getValue();
        this.retMsg = resultType.getDesc();
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param resultType 返回类型枚举
     * @param retMsg     返回结果描述
     * @param errMessage 异常描述信息
     */
    public ReturnPageValuesRuntimeException(ResultType resultType, String retMsg, String errMessage) {
        super(errMessage);
        this.retStatus = resultType.getValue();
        this.retMsg = retMsg;
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param errMessage 异常描述信息
     * @param cause      异常对象
     */
    public ReturnPageValuesRuntimeException(String errMessage, Throwable cause) {
        super(errMessage, cause);
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param resultType 返回类型枚举
     * @param errMessage 异常描述信息
     * @param cause      异常对象
     */
    public ReturnPageValuesRuntimeException(ResultType resultType, String errMessage, Throwable cause) {
        super(errMessage, cause);
        this.retStatus = resultType.getValue();
        this.retMsg = resultType.getDesc();
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param resultType 返回类型枚举
     * @param retMsg     返回结果描述
     * @param errMessage 异常描述信息
     * @param cause      异常对象
     */
    public ReturnPageValuesRuntimeException(ResultType resultType, String retMsg, String errMessage, Throwable cause) {
        super(errMessage, cause);
        this.retStatus = resultType.getValue();
        this.retMsg = retMsg;
    }

    /**
     * 构造带但返回值的运行时异常
     *
     * @param baseResp 通用返回对象
     */
    public ReturnPageValuesRuntimeException(BaseResp baseResp) {
        if (baseResp != null && baseResp.getResultType() != null) {
            ResultType resultType = baseResp.getResultType();
            this.retStatus = resultType.getValue();
            this.retMsg = resultType.getDesc();
        }
    }

    public int getRetStatus() {
        return retStatus;
    }

    public void setRetStatus(int retStatus) {
        this.retStatus = retStatus;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
