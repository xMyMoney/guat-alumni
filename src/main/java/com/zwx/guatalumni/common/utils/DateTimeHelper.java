package com.zwx.guatalumni.common.utils;


import com.zwx.guatalumni.common.constant.CommonConstant;
import com.zwx.guatalumni.common.constant.StoreTimeLevel;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

;

/**
 * Created by yijx on 2015/5/6.
 */
public class DateTimeHelper {

    private static String DATE_FORMAT = "yyyy-MM-dd 00:00:00";
    private static String DATE_FORMAT_PATTERN = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";

    /**
     * 获取当前日期和utc 1970 的天数
     *
     * @param date
     * @return
     */
    public static long getMinutesFromUTC(Date date) {
        long ret = 0;
        Date newDate = new Date();
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            newDate = format.parse(format.format(date));
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        ret = newDate.getTime() / 1000 / 60 / 60 / 24;
        return ret;
    }

    /**
     * 返回 分钟数对应的日期
     *
     * @param days
     * @return
     */
    public static Date getDayofDays(long days) {
        Date date = new Date(days * 24 * 60 * 60 * 1000);
        return date;
    }

    /**
     * 获取从 1970 到现在的天数
     *
     * @param date
     * @return
     */
    public static long getDaysFromUTC(Date date) {
        long ret = 0;
        Date newDate = new Date();
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            newDate = format.parse(format.format(date));
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        ret = newDate.getTime() / 1000 / 60 / 60 / 24;
        return ret + 1;
    }

    public static Date getNextMonth(Date date, int cycle) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(format.parse(format.format(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.MONTH, cycle);
        return c.getTime();
    }

    /**
     * 日期转字符串类型
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    /**
     * 日期转字符串类型
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        return stringToDate(str, "yyyy-MM-dd");
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @param format
     * @return
     */
    public static Date stringToDate(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        if (StringUtil.validEmpty(str)) {
            try {
                date = sdf.parse(str);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 比较开始和结束日期大小是否正确
     *
     * @param beginTime
     * @return
     */
    public static boolean validMonth(String beginTime) {
        if (StringUtil.validEmpty(beginTime)) {
            return validBeginEndTime(stringToDate(beginTime, "yyyy-MM"), stringToDate(dateToString(new Date()), "yyyy-MM"));
        }
        return true;
    }

    /**
     * 校验字符串日期的格式是否正确, 默认yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public static boolean validDateFormat(String dateStr) {
        if (!StringUtil.validEmpty(dateStr)) {
            return false;
        }

        Pattern datePattern = Pattern.compile(DATE_FORMAT_PATTERN);
        Matcher matcher = datePattern.matcher(dateStr);
        if (matcher.find()) {
            return validDateFormat(dateStr, CommonConstant.DATETIME_FORMAT);
        } else {
            return false;
        }
    }

    /**
     * 校验字符串日期的格式是否正确
     *
     * @param str
     * @param format
     * @return
     */
    public static boolean validDateFormat(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (!StringUtil.validEmpty(str)) {
            return false;
        }

        try {
            Date date = sdf.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Calendar转字符串类型
     *
     * @param cal
     * @return
     */
    public static String calendarToString(Calendar cal) {
        return dateToString(cal.getTime());
    }


    /**
     * Calendar转字符串类型
     *
     * @param cal
     * @return
     */
    public static String calendarToString(Calendar cal, String format) {
        return dateToString(cal.getTime(), format);
    }


    /**
     * 字符串转Calendar
     *
     * @param str
     * @return
     */
    public static Calendar stringToCalendar(String str) {
        Date date = stringToDate(str, "yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * 字符串转Calendar
     *
     * @param str
     * @return
     */
    public static Calendar stringToCalendar(String str, String format) {
        Date date = stringToDate(str, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * 字符串转TimeStamp
     *
     * @param str
     * @return
     */
    public static Timestamp stringToTimestamp(String str) {
        Date date = stringToDate(str, CommonConstant.DATETIME_FORMAT);
        Timestamp timestamp = null;
        if (date != null) {
            timestamp = new Timestamp(date.getTime());
        }
        return timestamp;
    }

    /**
     * TimeStamp转字符串
     *
     * @param timestamp
     * @return
     */
    public static String timestampToString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstant.DATETIME_FORMAT);
        String string = dateFormat.format(timestamp);
        return string;
    }


    /**
     * 日期添加
     *
     * @param date
     * @param calType 需求修改的日历类型，eg.Calendar.HOUR
     * @param amount  需求修改的数量
     * @return
     */
    public static Date dateAdd(Date date, int calType, int amount) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calType, amount);
        return calendar.getTime();
    }

    /**
     * 日期添加
     *
     * @param dateStr
     * @param calType 需求修改的日历类型，eg.Calendar.HOUR
     * @param amount  需求修改的数量
     * @return
     */
    public static Date dateAdd(String dateStr, int calType, int amount) {
        if (!StringUtil.validEmpty(dateStr)) {
            return null;
        }
        Date date = stringToDate(dateStr, CommonConstant.DATETIME_FORMAT);
        if (date == null) {
            return null;
        }
        return dateAdd(date, calType, amount);
    }

    /**
     * 字符串转TimeStamp
     *
     * @param str
     * @param format
     * @return
     */
    public static Timestamp stringToTimestamp(String str, String format) {
        Date date = stringToDate(str, format);
        Timestamp timestamp = null;
        if (date != null) {
            timestamp = new Timestamp(date.getTime());
        }
        return timestamp;
    }

    /**
     * 获取两个日期间隔月份数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getIntervalMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        if (date1.getTime() <= date2.getTime()) {
            cal1.setTime(date1);
            cal2.setTime(date2);
        } else {
            cal1.setTime(date2);
            cal2.setTime(date1);
        }

        int months = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH) + (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12;
        if (cal2.get(Calendar.DAY_OF_MONTH) < cal1.get(Calendar.DAY_OF_MONTH)) {
            months = months - 1;
        }
        return months;
    }


    /**
     * 补全开始日期
     *
     * @param beginDate
     * @return
     */
    public static String compeleteBeginDateFormat(String beginDate) {
        if (!StringUtil.validEmpty(beginDate)) {
            return null;
        }

        // 格式不正确，返回原值
        if (!validDateFormat(beginDate)) {
            return beginDate;
        }

        String dateFormat = "1970-01-01 00:00:00";
        if (beginDate.length() < dateFormat.length()) {
            beginDate = beginDate + dateFormat.substring(beginDate.length(), dateFormat.length());
        }
        return beginDate;
    }

    /**
     * 补全结束日期
     *
     * @param endDate
     * @return
     */
    public static String compeleteEndDateFormat(String endDate) {
        if (!StringUtil.validEmpty(endDate)) {
            return null;
        }

        // 格式不正确，返回原值
        if (!validDateFormat(endDate)) {
            return endDate;
        }

        String dateFormat = "1970-12-31 23:59:59";
        if (endDate.length() < dateFormat.length()) {
            endDate = endDate + dateFormat.substring(endDate.length(), dateFormat.length());
        }
        return endDate;
    }

    /**
     * 获取日期的分钟数（一天之内的）
     *
     * @param date
     * @return
     */
    public static int getMinutesByDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
    }

    /**
     * 比较开始和结束日期大小是否正确，其中一个为null，则默认为true
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean validBeginEndTime(Date beginTime, Date endTime) {
        if (beginTime != null && endTime != null) {
            return beginTime.getTime() <= endTime.getTime();
        }
        return true;
    }

    /**
     * 比较开始和结束日期大小是否正确
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean validBeginEndTime(String beginTime, String endTime) {
        if (StringUtil.validEmpty(beginTime) && StringUtil.validEmpty(endTime)) {
            return validBeginEndTime(stringToDate(beginTime, CommonConstant.DATE_FORMAT), stringToDate(endTime, CommonConstant.DATE_FORMAT));
        }
        return true;
    }


    /**
     * 根据日期获取文件目录
     *
     * @param date
     * @return
     */
    public static String filePathByDate(Date date) {
        String path = "";
        path = dateToString(date, "yyyy") + "/" + dateToString(date, "MM") + "/" + dateToString(date, "dd") + "/";
        //path = dateToString(date, "yyyy") + File.separator + dateToString(date, "MM") + File.separator + dateToString(date, "dd") + File.separator;
        return path;
    }


    /**
     * 根据日期获取文件的url ，类似于： 路径必须是  /xxx/xxx/xxx/,否则手机界面显示不了
     * http://120.24.95.234/resource/attachment/2016/04/26/1_51_20160426150907_1_0X0.png
     *
     * @param date
     * @return
     */
    public static String fileUrlPathByDate(Date date) {
        String path = "";
        path = dateToString(date, "yyyy") + "/" + dateToString(date, "MM") + "/" + dateToString(date, "dd") + "/";
        return path;
    }


    /**
     * 验证 日期是否在固定的天数之类
     *
     * @param beginTime
     * @param endTime
     * @param days
     * @return
     */
    public static boolean validBeginEndTimeDay(String beginTime, String endTime, long days) {
        boolean ret = false;
        Date begin = stringToDate(beginTime, CommonConstant.DATETIME_FORMAT);
        Date end = stringToDate(endTime, CommonConstant.DATETIME_FORMAT);
        long actualDays = (end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000);
        if (actualDays > days) {
            ret = false;
        } else {
            ret = true;
        }

        return ret;
    }

    /**
     * 根据日期生成能效查询日期（数字类型）
     *
     * @param date
     * @param level
     * @return
     */
    public static int getETLDataTimeByDate(Date date, StoreTimeLevel level) {
        String result = "";
        switch (level) {
            case HOUR:
                result = dateToString(date, "yyyyMMddHH");
                break;
            case DAY:
                result = dateToString(date, "yyyyMMdd");
                break;
            case MONTH:
                result = dateToString(date, "yyyyMM");
                break;
            default:
                result = dateToString(date, "yyyy");
        }
        return StringUtil.StringParseInt(result);
    }



    /**
     * 根据月份数获取英文月份名称
     *
     * @param month
     * @return
     */
    public static String getEngMonthNameByMonth(int month) {
        String engMonth = "";
        switch (month) {
            case 1:
                engMonth = "January";
                break;
            case 2:
                engMonth = "February";
                break;
            case 3:
                engMonth = "March";
                break;
            case 4:
                engMonth = "April";
                break;
            case 5:
                engMonth = "May";
                break;
            case 6:
                engMonth = "June";
                break;
            case 7:
                engMonth = "July";
                break;
            case 8:
                engMonth = "Aguest";
                break;
            case 9:
                engMonth = "September";
                break;
            case 10:
                engMonth = "October";
                break;
            case 11:
                engMonth = "November";
                break;
            default:
                engMonth = "December";
        }
        return engMonth;
    }

    /**
     * 根据开始时间可结束时间获取List<String>  String yyyyMM; 2015-01-00
     *
     * @param beginTime 2015-01-01 01:00:00
     * @param endTime
     * @return
     */
    public static List<String> betweenBeginAndEndList(String beginTime, String endTime) {
        Calendar beginCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        beginCal.clear();
        endCal.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
        List<String> dates = new ArrayList<String>();
        try {

            Date beginTimeDate = sdf.parse(beginTime);

            Date endTimeDate = sdf.parse(endTime);

            beginCal.setTime(beginTimeDate);

            endCal.setTime(endTimeDate);

            while (beginCal.getTime().compareTo(endCal.getTime()) <= 0) {
                dates.add(sdf2.format(beginCal.getTime()).toString());
                beginCal.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }

    /**
     * 获取一个月的每一天时间字符串 如 【2016-06-01 00:00:00, 2016-06-02 00:00:00】
     *
     * @param date
     * @return
     */
    public static List<String> getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        List<String> dates = new ArrayList<String>();
        //获取当月的最大天数
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < lastDay; i++) {

            calendar.set(Calendar.DAY_OF_MONTH, i + 1);

            dates.add(sdf.format(calendar.getTime()).toString());
        }
        return dates;
    }

    public static List<String> getDaysOfMonth(Date date, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<String> dates = new ArrayList<String>();
        //获取当月的最大天数
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < lastDay; i++) {

            calendar.set(Calendar.DAY_OF_MONTH, i + 1);

            dates.add(sdf.format(calendar.getTime()));
        }
        return dates;
    }

    /**
     * 获取一天的开始时间
     *
     * @return
     */
    public static String dayBeginTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date date = new Date();
        Calendar c3 = Calendar.getInstance();
        c3.setTime(date);
        return sdf.format(c3.getTime()).toString();
    }

    /**
     * 获取一天的结束时间
     *
     * @return
     */
    public static String dayEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Date date = new Date();
        Calendar c3 = Calendar.getInstance();
        c3.setTime(date);
        return sdf.format(c3.getTime()).toString();
    }

    /**
     * 获取本日
     *
     * @return
     */
    public static String getToday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return format.format(date);
    }

    /**
     * 获取本月
     *
     * @return
     */
    public static String getThisMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        return format.format(date);
    }

    /**
     * 获取本年
     *
     * @return
     */
    public static String getThisYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return format.format(date);
    }

    public static int getDaysByYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取日期的分钟数（一天之内的）
     *
     * @param date
     * @return
     */
    public static int getMinutesByDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取某月结束时间
     */
    public static String genLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendarToString(calendar, "yyyy-MM-dd 23:59:59");
    }

    /**
     * 获取某月开始时间
     */
    public static String genFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendarToString(calendar, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取某年开始时间
     */
    public static String genFirstDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        return calendarToString(calendar, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 把long型的时间转换为string型的时间 例如 201608090012转换为2016-08-09 00:12
     */
    public static String longToString(Long date, String longFormat, String stringFormat) {
        return dateToString(stringToDate(date.toString(), longFormat), stringFormat);
    }

    /**
     * 把long型的时间转换为string型的时间 例如 201608090012转换为2016-08-09 00:12
     */
    public static String longToString(Long date) {
        return dateToString(stringToDate(date.toString(), "yyyyMMddHHmm"), "yyyy-MM-dd HH:mm");
    }

    /**
     * 根据年月获取该月的最大天数
     *
     * @return
     */
    public static Integer getMaxDayByYearAndMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 将日期以指定格式输出
     *
     * @param date   - new Date()
     * @param format - "yyyy-MM-dd"
     * @return 2015-11-23
     */
    public static String formatToString(Date date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 当前时间提前一个月
     *
     * @param date   202106
     * @param format yyyyMM
     * @return 202105
     */
    public static String getPerMonthDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(getPerMonthDate(date));
    }

    /**
     * 当前时间提前一个月
     *
     * @param date   202106
     * @return date 202105
     */
    public static Date getPerMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 当前时间提前一个月
     *
     * @param date   202106
     * @param format yyyyMM
     * @return 202006
     */
    public static String getPerYearDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(getPerYearDate(date));
    }

    /**
     * 当前时间提前一个月
     *
     * @param date   202106
     * @return date 202006
     */
    public static Date getPerYearDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取今天开始时间
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取今天结束时间
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获取本月的阿拉伯数字
     * @return
     */
    public static Integer getNowMonth() {
        Calendar nowMonth = Calendar.getInstance();
        return nowMonth.get(Calendar.MONTH) + 1;
    }

}
