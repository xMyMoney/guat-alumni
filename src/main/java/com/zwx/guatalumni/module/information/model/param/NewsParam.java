package com.zwx.guatalumni.module.information.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;

/**
 * 公告请求参数
 */
public class NewsParam extends BasePageParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    private Integer categoryId;

    public NewsParam() {
    }

    public NewsParam(String title, String content, Integer categoryId) {
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }

    public NewsParam(Integer current, Integer pageSize, String title, String content, Integer categoryId) {
        super(current, pageSize);
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "NewsParam{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
