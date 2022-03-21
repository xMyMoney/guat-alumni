package com.zwx.guatalumni.common.constant;

/**
 * @name: TreeLevelEnum
 * @author: andy
 * @date: 2016-04-22
 * @version: v1.0
 * @Description: 项目树结构等级
 */
public enum StoreTimeLevel {
    //年份
    YEAR(0),
    //月份
    MONTH(1),
    //天
    DAY(2),
    //小时
    HOUR(3);

    private int value = 0;

    StoreTimeLevel(int value) {
        this.value = value;
    }

    /**
     * int到enum的转换函数
     *
     * @param value
     * @return
     */
    public static StoreTimeLevel valueOf(int value) {
        switch (value) {
            case 1:
                return MONTH;
            case 2:
                return DAY;
            case 3:
                return HOUR;
            default:
                return YEAR;
        }

    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
