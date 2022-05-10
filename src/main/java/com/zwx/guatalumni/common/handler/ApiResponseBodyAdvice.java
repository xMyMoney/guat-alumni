package com.zwx.guatalumni.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //返回类型本身就是 RespBean
        if (o instanceof ResponseResult) {
            return o;
        }
        // String类型不能直接包装，所以要进行些特别的处理
        if(o instanceof String){
            try {
                return objectMapper.writeValueAsString(new ResponseResult(ResultType.SUCCESS.getValue(),ResultType.SUCCESS.getDesc(),o));
            } catch (JsonProcessingException e) {
                throw new BusinessException("返回String类型错误");
            }
        }
        // 将原本的数据包装在RespBean里
        return new ResponseResult(ResultType.SUCCESS.getValue(),ResultType.SUCCESS.getDesc(),o);
    }
}
