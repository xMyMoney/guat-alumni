package com.zwx.guatalumni.common.exception;

/**
 * @name: BaseRuntimeException.java
 * @author: andy
 * @date: 2017/10/30
 * @version: 1.0
 * @Description: 基础运行时异常
 */
public class BaseRuntimeException extends RuntimeException {
    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
