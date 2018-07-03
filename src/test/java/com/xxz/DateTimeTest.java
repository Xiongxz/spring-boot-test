package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Author Xiong xz
 * @Date 2018/6/22 0022  9:10
 * @Since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DateTimeTest {
    @Test
    public void dateTimeTest() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterAll = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("系统语言环境：" + Locale.getDefault());

        System.out.println("默认时区-yyyy-MM-dd :" + LocalDate.now());
        System.out.println(Instant.now());
        //同上
        //System.out.println(LocalDate.now(Clock.systemDefaultZone()));

        String dateTimeNow = dateTimeFormatterAll.format(LocalDateTime.now());
        System.out.println("默认时区-yyyy-MM-dd HH:mm:ss : " + dateTimeNow);

        System.out.println("带时区的完整时间 : " + ZonedDateTime.now());

        System.out.println("转换为时间类型 ： " + LocalDateTime.parse(dateTimeNow, dateTimeFormatterAll));
    }
}
