package com.zwx.guatalumni.module.information.model.param;

import com.zwx.guatalumni.common.base.BasePageParam;

public class NewsCategoryParam extends BasePageParam {
    private Integer id;
    private String name;

    public NewsCategoryParam() {
    }

    public NewsCategoryParam(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public NewsCategoryParam(Integer current, Integer pageSize, Integer id, String name) {
        super(current, pageSize);
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
