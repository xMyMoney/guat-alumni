package com.zwx.guatalumni.services;

import com.zwx.guatalumni.module.activity.model.param.ActivityCategoryParam;
import com.zwx.guatalumni.module.activity.service.ActivityCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    ActivityCategoryService activityCategoryService;

    @Test
    public void test() {
        ActivityCategoryParam param = new ActivityCategoryParam();
        param.setCurrent(1);
        param.setPageSize(5);
        activityCategoryService.findList(param).getList().forEach(System.out::println);
    }
}
