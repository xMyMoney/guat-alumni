package com.zwx.guatalumni.common.exception;
/**
 * 业务异常
 */
public class BusinessException extends RuntimeException{

    private Integer code;
    private String msg;

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public BusinessException(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.code = 500;
        this.msg = cause.getMessage();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

