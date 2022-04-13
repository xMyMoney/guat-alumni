package com.zwx.guatalumni.common.base;

import com.zwx.guatalumni.common.constant.ResultType;
import com.zwx.guatalumni.common.model.response.ResponseResult;
import com.zwx.guatalumni.common.utils.CommonUtil;
import com.zwx.guatalumni.common.utils.HttpUtil;
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


    /**
     * Sets result.
     *
     * @param resultType the result type
     * @return the result
     */
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
     * 组装请求参数，并写入session信息
     *
     * @param <F>       the type parameter
     * @param baseParam the base param
     * @return 具体参数类 auth request object
     */
//    protected <F> F getAuthRequestObject(BaseParam baseParam) {
//        if (baseParam != null) {
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            HttpServletRequest request = attributes.getRequest();
//            String token = getTokenFromRequest(request);
//
//            // 根据token更新用户登录信息
//            baseParam.setToken(token);
//            Map<String, String> userMap = this.getAll(token);
//            if (userMap != null && userMap.keySet().size() > 0) {
//                baseParam.setCurrUserPkId(StringUtils.isNotBlank(userMap.get(CommonConstant.SESSION_USER_PKID)) ? userMap.get(CommonConstant.SESSION_USER_PKID) : "");
//                baseParam.setCurrUserName(StringUtils.isNotBlank(userMap.get(CommonConstant.SESSION_USER_NAME)) ? userMap.get(CommonConstant.SESSION_USER_NAME) : "");
//                baseParam.setCurrRolePkId(StringUtils.isNotBlank(userMap.get(CommonConstant.SESSION_ROLE_PKID)) ? userMap.get(CommonConstant.SESSION_ROLE_PKID) : "");
//                baseParam.setCurrRoleType(StringUtils.isNotBlank(userMap.get(CommonConstant.SESSION_ROLE_TYPE)) ? Byte.parseByte(userMap.get(CommonConstant.SESSION_ROLE_TYPE)) : 0);
//                baseParam.setCurrRoleAreaCode(StringUtils.isNotBlank(userMap.get(CommonConstant.SESSION_AREA_CODE)) ? Byte.parseByte(userMap.get(CommonConstant.SESSION_AREA_CODE)) : 0);
//                baseParam.setCurrOperatorId(userMap.get(CommonConstant.SESSION_OPERATOR_ID));
//                baseParam.setLang(LangType.codeOf(request.getHeader("LANG")).getValue());
//            }
//
//            // 将用户主键设置到请求上下文中
//            request.setAttribute(CommonConstant.SESSION_USER_PKID, baseParam.getCurrUserPkId());
//            request.setAttribute(CommonConstant.SESSION_USER_NAME, baseParam.getCurrUserName());
//        }
//        return (F) baseParam;
//    }

    /**
     * 获取请求IP
     *
     * @return ip addr
     */
    public String getIpAddr() {
        String ipAddress = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }

            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                    //根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        //"***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }

        return ipAddress;
    }

    /**
     * 设置返回401
     *
     * @return ResponseResult un authorized response
     */
//    public ResponseResult setUnAuthorizedResponse() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = attributes.getResponse();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 设置401
//        response.setCode(HttpCode.UNAUTHORIZED.value());
//
//        // 返回对象
//        ResponseResult result = new ResponseResult();
//        result.setCode(ResultType.USER_NO_AUTH.getValue());
//        result.setMsg(ResultType.USER_NO_AUTH.getDesc());
//        String token = getTokenFromRequest(request);
//        if (StringUtils.isNotBlank(token)) {
//            String crowededOut = stringRedisTemplate.opsForValue().get("impcf_crowded_out:" + token);
//            if (crowededOut != null) {
//                // 用户被挤下去，返回“ACCOUNT_BEEN_CROWDED_OUT”
//                result.setMsg("ACCOUNT_BEEN_CROWDED_OUT");
//                // 清空 croweded out 缓存标记，保证只返回一次给前端
//                stringRedisTemplate.delete("impcf_crowded_out:" + token);
//                return result;
//            }
//        }
//        return result;
//    }

//    /**
//     * 设置返回401
//     *
//     * @return ResponsePageResult un authorized page response
//     */
//    public ResponsePageResult setUnAuthorizedPageResponse() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = attributes.getResponse();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 设置401
////        response.setStatus((HttpCode.UNAUTHORIZED.value());
//
//        // 返回对象
//        ResponsePageResult result = new ResponsePageResult();
//        result.setCode(ResultType.USER_NO_AUTH.getValue());
//        result.setMsg(ResultType.USER_NO_AUTH.getDesc());
//        String token = CommonUtil.getRequestAttribute(request, "access_token", HttpUtil.getRequestQueryString(request));
////        if (StringUtils.isNotBlank(token)) {
////            String crowededOut = stringRedisTemplate.opsForValue().get("impcf_crowded_out:" + token);
////            if (crowededOut != null) {
////                // 用户被挤下去，返回“ACCOUNT_BEEN_CROWDED_OUT”
////                result.setMsg("ACCOUNT_BEEN_CROWDED_OUT");
////                // 清空 croweded out 缓存标记，保证只返回一次给前端
////                stringRedisTemplate.delete("impcf_crowded_out:" + token);
////                return result;
////            }
////        }
//        return result;
//    }

    /**
     * 从request中获取access_token
     *
     * @param request request
     * @return token
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        return CommonUtil.getRequestAttribute(request, "access_token", HttpUtil.getRequestQueryString(request));
    }

    /**
     * 是否是管理员（超级管理员、平台、政府、区发改）
     *
     * @param baseParam 参数
     * @return boolean
     */
//    protected boolean isAdmin(BaseParam baseParam) {
//        if (baseParam == null) {
//            return false;
//        }
//        RoleType roleType = RoleType.valueOf(baseParam.getCurrRoleType());
//        return roleType == RoleType.PLATFORM || roleType == RoleType.GOVERNMENT || roleType == RoleType.SUPER_ADMIN
//                || roleType == RoleType.AREA_GOVERNMENT;
//    }

}
