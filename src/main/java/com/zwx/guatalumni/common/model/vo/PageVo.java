package com.zwx.guatalumni.common.model.vo;

import com.zwx.guatalumni.common.base.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author x
 */
@Data
@Builder
public class PageVo<T> implements BaseEntity {

    /**
     * 查询数据列表
     */
    private List<T> list;
    /**
     * 总数，当 total 不为 0 时分页插件不会进行 count 查询
     */
    private int total;

    public PageVo(List<T> list, long total) {
        this.list = list;
        this.total = Integer.parseInt(String.valueOf(total));
    }

    public PageVo(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }
}
