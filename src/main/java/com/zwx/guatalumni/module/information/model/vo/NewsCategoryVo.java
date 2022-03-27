package com.zwx.guatalumni.module.information.model.vo;

import com.zwx.guatalumni.module.information.model.entity.NewsCategory;
import lombok.Data;

@Data
public class NewsCategoryVo extends NewsCategory {
    /**
     * 新闻数量
     */
    private Integer newsCount;

}
