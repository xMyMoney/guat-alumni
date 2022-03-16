package com.zwx.guatalumni.module.information.model.vo;

import com.zwx.guatalumni.module.information.model.entity.NewsCategory;

public class NewsCategoryVo extends NewsCategory {
    /**
     * 新闻数量
     */
    private Integer newsCount;

    public NewsCategoryVo(Integer newsCount) {
        this.newsCount = newsCount;
    }

    public Integer getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "newsCount=" + newsCount +
                '}';
    }
}
