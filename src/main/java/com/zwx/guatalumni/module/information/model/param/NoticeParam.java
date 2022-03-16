package com.zwx.guatalumni.module.information.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;

/**
 * 公告请求参数
 */
public class NoticeParam extends BasePageParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    public NoticeParam() {
    }

    public NoticeParam(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoticeParam(Integer pageCur, Integer pageSize, String title, String content) {
        super(pageCur, pageSize);
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NoticeParam{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
