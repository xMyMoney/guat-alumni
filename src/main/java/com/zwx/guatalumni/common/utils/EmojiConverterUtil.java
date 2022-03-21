package com.zwx.guatalumni.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cao_zf
 * @ClassName EmojiConverterUtil
 * @create: 2021-04-25 17:41:43
 * @version: V1.3.0
 * @slogan: Great haste makes great waste
 * @description :
 */
public class EmojiConverterUtil {
    /**
     * @param str 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException exception
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     */
    public static String emojiConvert(String str) {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

//    /**
//     * @param str 转换后的字符串
//     * @return 转换前的字符串
//     * exception
//     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
//     */
//    public static String emojiRecovery2(String str) {
//        String patternString = "\\[\\[(.*?)\\]\\]";
//
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(str);
//
//        StringBuffer sb = new StringBuffer();
//        while (matcher.find()) {
//            try {
//                matcher.appendReplacement(sb,
//                        URLDecoder.decode(matcher.group(1), "UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//
//            }
//        }
//        matcher.appendTail(sb);
//        return sb.toString();
//    }
}
