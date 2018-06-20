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
        int selectNumber = 3;
        List<String> listString = Arrays.asList("测试1", "测试2", "测试3", "测试4", "测试5", "测试6", "测试7", "测试8");
        int[] ints = {1, 2, 3, 4, 5};
        List<UserInfo> listUserInfo = new ArrayList<>();
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            listUserInfo.add(new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
            map.put(Utils.randomNumber(0, 6), new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
        }
        //listString.forEach(e -> System.out.println(e));
        //map.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6};
        String[] strArray = new String[intArray.length];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = String.valueOf(intArray[i]);
        }
       /* for (String s : strArray) {
            System.out.println(s);
        }*/

        List<String> listtest = Utils.combine(strArray, selectNumber);
        int num = 0;
        String with = "3";
        listtest.sort((x, j) -> x.compareTo(j));
        listtest.forEach(System.out::println);
        String l = listtest.stream().filter(x ->x.startsWith(with,x.length())).findAny().orElse("null");
        //List<String> ll=filters(listtest,"3");
        System.out.println("该组合人数：" + l);
        listtest.stream().filter(x -> x.endsWith(with)).forEach(x -> System.out.println(strArray.length + " 选 " + selectNumber + "组合：" + x));
    }

    public <E> E  filters(List<E> t,String filtersName){
        return t.stream().filter(d ->String.valueOf(t).indexOf(filtersName)!=-1).findAny().orElse(null);
    }


    public IntSummaryStatistics summaryStatistics(List<Object> t){
        return t.stream().mapToInt((x) -> Integer.parseInt(x.toString())).summaryStatistics();
    }
}
