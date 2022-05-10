package com.zwx.guatalumni.common.handler;

import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * java运行异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult ExceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResponseResult(ResultType.OTHER_ERROR.getValue(),ResultType.OTHER_ERROR.getDesc(), null);
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult BusinessExceptionHandler(BusinessException e) {
        if(!StringUtils.isBlank(e.getLocalizedMessage())) {
            return new ResponseResult(ResultType.OTHER_ERROR.getValue(),ResultType.OTHER_ERROR.getDesc(), null);
        }
        return new ResponseResult(e.getCode(),e.getMsg(), null);
    }
}
