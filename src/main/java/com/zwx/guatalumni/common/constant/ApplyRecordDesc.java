package com.zwx.guatalumni.common.constant;

/**
 * @author x
 */

public enum ApplyRecordDesc {

    /**
     * 返校申请
     */
    BackSchool(0,"返校"),
    /**
     * 学位证明申请
     */
    DEGREE(1,"学位证明"),
    /**
     * 毕业证明申请
     */
    GRADUATION(2,"毕业证明"),

    /**
     * 捐赠申请
     */
    DONATION(3,"捐赠"),

    /**
     * 身份认证
     */
    AUTH(4,"身份认证");

    private int applyType;
    private String applyDesc;

    ApplyRecordDesc(int applyType, String applyDesc) {
        this.applyType = applyType;
        this.applyDesc = applyDesc;
    }

    public int getApplyType() {
        return applyType;
    }

    public String getApplyDesc() {
        return applyDesc;
    }
}
