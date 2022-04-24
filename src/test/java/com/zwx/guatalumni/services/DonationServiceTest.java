package com.zwx.guatalumni.services;

import com.zwx.guatalumni.module.donation.service.DonationService;
import com.zwx.guatalumni.module.donation.service.DonationStatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DonationServiceTest {

    @Autowired
    DonationService donationService;

    @Autowired
    DonationStatisticsService donationStatisticsService;

    @Test
    public void test() {
//        donationService.getList().forEach(System.out::println);
//        System.out.println(donationService.getOne("1").toString());
//        donationStatisticsService.getOneRankLatest("1").forEach(System.out::println);
//        donationStatisticsService.getOneRank("1").forEach(System.out::println);

        Integer a = 100000;
        System.out.println(Math.round(1400/a.floatValue()*100));
    }
}
