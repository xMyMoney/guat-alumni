package com.zwx.guatalumni.common.utils;

/**
 * Created by yijx on 2017/5/11.
 * <p>
 * SimpleDateFormat 类不都是线程安全�? 在多线程调用时会出问�?
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConcurrentDateUtil {

    public enum DateType {
        YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
    }

    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String dateStr) throws ParseException {
        threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return threadLocal.get().parse(dateStr);
    }

    public static Date parse(String dateStr, String formant) throws ParseException {
        threadLocal.set(new SimpleDateFormat(formant));
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return threadLocal.get().format(date);
    }

    public static String format(Date date, String formant) {
        threadLocal.set(new SimpleDateFormat(formant));
        return threadLocal.get().format(date);
    }

    public static Date dateCalc(Date date, DateType dateType, int calcValue, String format) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        switch (dateType) {
            case YEAR:
                cal.add(Calendar.YEAR, calcValue);
                break;
            case MONTH:
                cal.add(Calendar.MONTH, calcValue);
                break;
            case DAY:
                cal.add(Calendar.DATE, calcValue);
                break;
            case HOUR:
                cal.add(Calendar.HOUR, calcValue);
                break;
            case MINUTE:
                cal.add(Calendar.MINUTE, calcValue);
                break;
            case SECOND:
                cal.add(Calendar.SECOND, calcValue);
                break;
        }
        return parse(format(cal.getTime()), format);
    }
}
