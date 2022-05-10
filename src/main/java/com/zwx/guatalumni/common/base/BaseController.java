package com.zwx.guatalumni.common.base;

import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.utils.CommonUtil;
import com.zwx.guatalumni.common.utils.HttpUtil;
import com.zwx.guatalumni.common.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author x
 */
@Configuration
@RestController
public class BaseController {

    /**
     * 输出日志对象
     */
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);


    /**
     * 设置返回结果输出到response中
     *
     * @param <T>      the type parameter
     * @param code   状态
     * @param msg  错误信息
     * @param data   返回数据
     */
    public <T> ResponseResult setResult(int code, String msg, List<T> data) {
        ResponseResult result = new ResponseResult(code, msg, data);
        return result;
    }

    /**
     * 设置返回结果输出到response中 重载
     *
     * @param <T>        the type parameter
     * @param resultType 结果类型
     * @param data     返回数据
     */
    public <T> ResponseResult setResult(ResultType resultType, T data) {
        ResponseResult result = new ResponseResult(resultType.getValue(), resultType.getDesc(), data);
        return result;
    }

    /**
     * 统一返回结果封装
     *
     * @param baseResp the base resp
     * @return result
     * @ResponseBody 以json串方式返回
     */
    public ResponseResult setResult(BaseResp baseResp) {
        return setResult(baseResp.getResultType(), baseResp.getData());
    }


    public ResponseResult setResult(ResultType resultType) {
        ResponseResult result = new ResponseResult();
        result.setCode(resultType.getValue());
        result.setMsg(resultType.getDesc());
        result.setData(new ArrayList());
        return result;
    }

    public <T> ResponseResult setResult(T data) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResultType.SUCCESS.getValue());
        result.setMsg(ResultType.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    /**
     * 从request中获取token
     *
     * @param request request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }


    protected Integer getAlumniId(HttpServletRequest request) {
        return JWTUtils.getAlumniId(request.getHeader("Authorization"));
    }

}
