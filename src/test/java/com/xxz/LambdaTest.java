package com.xxz;

import com.xxz.model.UserInfo;
import com.xxz.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2018/6/18 0018 22:00
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    public static final Logger LOG = LoggerFactory.getLogger(LambdaTest.class);

    @Test
    public void lambdaTest() {
        List<String> listString = Arrays.asList("测试1", "测试2", "测试3", "测试4", "测试5", "测试6", "测试7", "测试8");
        List<UserInfo> listUserInfo = new ArrayList<>();
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            listUserInfo.add(new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
            map.put(Utils.randomNumber(0, 6), new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
        }
        listString.forEach(e -> System.out.println(e));
        //String s = "ss";
        //String n = "nn";
        //String d=(s,n) -> System.out.println();
        map.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));
    }
}
