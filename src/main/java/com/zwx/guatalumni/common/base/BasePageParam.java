package com.zwx.guatalumni.common.base;

public abstract class BasePageParam {
    private Integer current;
    private Integer pageSize;

    public BasePageParam() {
    }

    public BasePageParam(Integer current, Integer pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
