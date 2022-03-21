package com.zwx.guatalumni.common.utils;

/**
 * Created by licz on 2016-05-23.
 */
public class TempFileVo {
    private String fileName;            //文件名称
    private String fileType;            //文件扩展类型
    private String fileAbsolutePath;    //文件绝对路径
    private String fileRelativePath;    //文件相对路径

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }

    public String getFileRelativePath() {
        return fileRelativePath;
    }

    public void setFileRelativePath(String fileRelativePath) {
        this.fileRelativePath = fileRelativePath;
    }
}
