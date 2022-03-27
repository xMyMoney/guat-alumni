package com.zwx.guatalumni;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class GuatAlumniApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        System.out.println(new SimpleDateFormat().parse("2022-02-11"));
    }

}
