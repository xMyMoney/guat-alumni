package com.zwx.guatalumni.common.utils;

public class PageUtil {

    public static int getStartIndex(int current,int pageSize) {
        return (current - 1) * pageSize;
    }
}
