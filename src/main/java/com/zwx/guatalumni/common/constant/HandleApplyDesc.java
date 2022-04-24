package com.zwx.guatalumni.common.constant;

/**
 * @author x
 */

public enum HandleApplyDesc {

    /**
     * 待通过
     */
    STAY(0,"待通过"),
    /**
     * 申请通过
     */
    AGREE(1,"通过"),

    /**
     * 申请不通过
     */
    REFUSE(2,"不通过");


    private final int status;
    private final String desc;

    HandleApplyDesc(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }


}
