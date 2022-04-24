package com.zwx.guatalumni.services;

import com.zwx.guatalumni.module.aliyun.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class SmsServiceTest {

    @Autowired
    SmsService smsService;

    @Test
    public void test() {
        smsService.sendNoticeSms(1,"返校",null);
    }
}
