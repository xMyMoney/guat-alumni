package com.zwx.guatalumni.services;

import com.zwx.guatalumni.common.model.vo.OptionsTreeVo;
import com.zwx.guatalumni.module.alumni.service.AcademyService;
import com.zwx.guatalumni.module.alumni.service.AlumniService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlumniCenterTest {

    @Autowired
    AcademyService academyService;

    @Autowired
    AlumniService alumniService;

    @Test
    public void test() {
        for (OptionsTreeVo treeVo : academyService.getTree()) {
            System.out.println(treeVo);
        }
    }

    @Test
    public void export() {
        alumniService.export();
    }
}
