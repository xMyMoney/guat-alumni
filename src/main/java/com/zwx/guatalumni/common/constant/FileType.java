package com.zwx.guatalumni.common.constant;

/**
 * @name: FileType
 * @author: andy
 * @date: 2016-04-22
 * @version: v1.0
 * @Description: 文件类型
 */
public enum FileType {
    XLS(".xls", "xls"),                          //Excel2003
    XLSX(".xlsx", "xlsx"),                          //Excel2007
    JPG(".jpg", "jpg"),                           //jpg
    PNG(".png", "png");                           //png

    private String extendName = null;
    private String value = null;

    FileType(String extendName, String value) {
        this.extendName = extendName;
        this.value = value;
    }

    public String getExtendName() {
        return extendName;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
