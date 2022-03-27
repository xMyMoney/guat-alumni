package com.zwx.guatalumni.module.information.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 静态页面
 * </p>
 *
 * @author zwx
 * @since 2022-03-27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaticPage implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 内容
     */
    private String content;

}
