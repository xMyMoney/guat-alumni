package com.zwx.guatalumni.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author cao_zf
 * @ClassName DateTimeUtil
 * @create: 2021-04-16 08:14:12
 * @version: V1.3.0
 * @slogan: Great haste makes great waste
 * @description : 时间处理工具类
 */
public class DateUtil {
    /**
     * 一般的格式化日期成字符串
     *
     * @param date    date
     * @param pattern pattern
     * @return String
     */
    public static String formatDate(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            try {
                return dateFormat.format(date);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 一般的格式化日期成字符串
     *
     * @param ldt     localDateTime
     * @param pattern pattern
     * @return String
     */
    public static String formatLDT(LocalDateTime ldt, String pattern) {
        if (ldt != null && pattern != null && pattern.length() > 0) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
                return df.format(ldt);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 一般的格式化日期成字符串
     *
     * @param ldt     LocalDate
     * @param pattern pattern
     * @return String
     */
    public static String formatLD(LocalDate  ldt, String pattern) {
        if (ldt != null && pattern != null && pattern.length() > 0) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
                return df.format(ldt);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 一般的将字符串转化成日期
     *
     * @param dateStr date string
     * @param pattern pattern
     * @return Date
     */
    public static Date parseToDate(String dateStr, String pattern) {
        if (dateStr != null && !"".equals(dateStr.trim())) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            try {
                return dateFormat.parse(dateStr);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * Date转换LocalDateTime
     *
     * @param date date
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLDT(Date date) {
        if (date != null) {
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            return instant.atZone(zoneId).toLocalDateTime();
        }
        return null;
    }
    /**
     * String转换LocalDate
     *
     * @param date date
     * @return LocalDateTime
     */
    public static LocalDate formatLD(String date,String pattern) {
        if (StringUtils.isNotBlank(date) && pattern != null && pattern.length() > 0) {
            try {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
                return LocalDate.parse(date, fmt);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
