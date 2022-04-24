package com.zwx.guatalumni.services;

import com.zwx.guatalumni.module.alumni.service.BackApplyService;
import com.zwx.guatalumni.module.alumni.service.ProveApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplyServiceTest {

    @Autowired
    BackApplyService backApplyService;

    @Autowired
    ProveApplyService proveApplyService;

    @Test
    public void test() {
        backApplyService.listByApplyId("1").forEach(System.out::println);
        proveApplyService.listByApplyId("1").forEach(System.out::println);
    }
}
