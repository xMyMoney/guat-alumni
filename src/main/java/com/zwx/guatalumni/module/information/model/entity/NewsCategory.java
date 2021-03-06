package com.zwx.guatalumni.module.information.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 新闻分类表
 * </p>
 *
 * @author zwx
 * @since 2022-03-07
 */
@Data
public class NewsCategory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否已删除
     */
    private String isDelete;
}
