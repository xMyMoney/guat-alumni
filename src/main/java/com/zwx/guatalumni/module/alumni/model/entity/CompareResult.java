package com.zwx.guatalumni.module.alumni.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 对比结果记录
 * </p>
 *
 * @author zwx
 * @since 2022-04-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompareResult implements Serializable {

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
     * 校友id
     */
    private Integer alumniId;

    /**
     * 对比状态
     */
    private Integer resultStatus;

    /**
     * 对比描述
     */
    private String resultInfo;


    public CompareResult(Integer alumniId, Integer resultStatus, String resultInfo) {
        this.alumniId = alumniId;
        this.resultStatus = resultStatus;
        this.resultInfo = resultInfo;
    }

    public CompareResult(Integer alumniId, Integer resultStatus) {
        this.alumniId = alumniId;
        this.resultStatus = resultStatus;
    }
}
