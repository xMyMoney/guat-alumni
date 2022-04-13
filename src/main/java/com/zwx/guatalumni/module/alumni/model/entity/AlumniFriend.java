package com.zwx.guatalumni.module.alumni.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 校友关系
 * </p>
 *
 * @author zwx
 * @since 2022-04-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniFriend implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 校友id
     */
    private Integer alumniId;

    /**
     * 好友id
     */
    private Integer friendId;

    public AlumniFriend(Integer alumniId, Integer applyId) {
        this.alumniId = alumniId;
        this.friendId = applyId;
    }
}
