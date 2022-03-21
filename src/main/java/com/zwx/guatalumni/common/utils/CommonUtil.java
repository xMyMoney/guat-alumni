package com.zwx.guatalumni.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公共工具类
 */
public class CommonUtil {

    /**
     * 获取请求URL参数,适用于GET和POST请求
     *
     * @param name
     * @param str
     * @return
     */
    public static String getQueryStringValue(String name, String str) {
        if (StringUtil.validEmpty(str)) {
            String[] paramArr = str.split("&");
            for (String param : paramArr) {
                if (StringUtil.validEmpty(param) && param.indexOf("=") > -1) {
                    String[] valArr = param.split("=");
                    if (name.equalsIgnoreCase(valArr[0])) {
                        return valArr.length > 1 ? valArr[1] : "";
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取请求Token
     *
     * @return
     */
    public static String getRequestAttribute(HttpServletRequest request, String code, String queryStr) {
        String token = "";
        String headerValue = request.getHeader("Authorization");
        if (headerValue == null) {
            headerValue = request.getHeader("authorization");
        }
        if (StringUtils.isNotBlank(headerValue)) {
            String[] strs = headerValue.split(" ");
            if (strs.length > 1) {
                token = strs[1];
            }
            // token = headerValue.replace("bearer ", "").trim();
        }
        if (token.length() == 0) {
            token = request.getHeader(code) == null ? getQueryStringValue(code, queryStr) : request.getHeader(code);
        }
        return token;
    }

    /**
     * 获取项目根目录
     *
     * @return
     */
    public static String getProjectRootPath(Class clazz) {
        String classPath = "";
        try {
            classPath = clazz.getResource("/").getPath();  //WEB-INF/classes/
            classPath = URLDecoder.decode(classPath, "UTF-8");   //转码
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = classPath.split("WEB-INF")[0];
        String osName = System.getProperty("os.name");
        if (StringUtil.validEmpty(osName) && osName.toLowerCase().indexOf("windows") > -1) {
            path = path.length() > 0 ? path.substring(1) : path;
            path = path.replace("/", "\\");
        }
        return path;
    }

    /**
     * 对象转换为List
     *
     * @param list
     * @return
     */
    public static boolean validateList(List<? extends Object> list) {
        return list != null && list.size() > 0;
    }

    /**
     * 组装order by 排序字段，同时通过反射验证字段是否正确
     *
     * @param clazz
     * @param gOrder
     * @return
     */
    public static String getOrderBy(Class clazz, String gOrder) {
        StringBuilder orderStr = new StringBuilder("order by ");
        if (StringUtils.isNotBlank(gOrder)) {
            String[] orderStrArr = gOrder.trim().split(",");

            if (orderStrArr.length > 0) {
                Field[] fields = clazz.getDeclaredFields();
                for (String order : orderStrArr) {
                    if (StringUtils.isBlank(order)) {
                        continue;
                    }
                    String[] orderArr = order.split("=");
                    if (orderArr.length == 2) {
                        String fieldName = orderArr[0].trim();
                        // 判断是否完全存在
                        if (Arrays.stream(fields).anyMatch(v -> fieldName.equals(v.getName()))) {
                            orderStr.append(fieldName);
                            if ("asc".equalsIgnoreCase(orderArr[1])) {
                                orderStr.append(" asc ,");
                            } else if ("desc".equalsIgnoreCase(orderArr[1])) {
                                orderStr.append(" desc ,");
                            }
                        }
                    }
                }
                if (orderStr.length() > 9) {
                    orderStr.deleteCharAt(orderStr.length() - 1);
                }
            }
        }
        return orderStr.length() > 9 ? orderStr.toString() : "";
    }

    /**
     * 检测一个范围格式
     *
     * @param value
     * @param format
     * @return false 不通过
     */
    public static boolean isValidByOneFormat(String value, String format) {
        if (value.length() != format.length()) {
            return false;
        }

        String[] formatArr = format.split("~");
        String[] valueArr = value.split("~");
        if (formatArr.length != valueArr.length) {
            return false;
        }

        for (int i = 0; i < formatArr.length; i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatArr[i]);
            try {
                simpleDateFormat.parse(valueArr[i]);
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean isDouble(String value) {
        if (value != null) {
            try {
                new Double(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean isBigDecimal(String value) {
        if (value != null) {
            try {
                new BigDecimal(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean isInteger(String value) {
        if (value != null) {
            try {
                new Integer(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static BigDecimal getDecimalFromMap(Map<String, Object> map, String key) {
        if (map != null && map.size() > 0 && map.get(key) != null) {
            Object val = map.get(key);
            if (isBigDecimal(val.toString())) {
                return new BigDecimal(val.toString());
            }
        }
        return null;
    }

    /**
     * 获取当前月的最后一天
     *
     * @return Date
     */
    public static Date getThisMonthLastday() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }

    /**
     * double 四舍五入保留几位小数
     *
     * @param value value
     * @param i     i
     * @return double
     */
    public static double roundDouble(double value, int i) {
        return (double) Math.round(value * Math.pow(10, i)) / Math.pow(10, i);
    }

    /**
     * 判断集合是否不为空
     *
     * @param list 集合
     * @param <T>  泛型类
     * @return 布尔值
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        return list != null && list.size() > 0;
    }

    /**
     * 判断集合是否为空
     *
     * @param list 集合
     * @param <T>  泛型类
     * @return 布尔值
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() <= 0;
    }

    /**
     * 如果对象为空返回默认值
     *
     * @param t           对象
     * @param deaultValue 默认值
     * @param <T>         泛型类
     * @return T
     */
    public static <T> T ifNull(T t, T deaultValue) {
        return t == null ? deaultValue : t;
    }
}
