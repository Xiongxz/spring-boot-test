package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xiong xz
 * @Date 2018/6/22 0022  16:35
 * @Since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SortingTest {
    @Test
    public void sortTest() {
        List<Integer> sortList = Arrays.asList(1, 2, 34, 5, 76, 43, 334, 2323, 43, 5, 4, 2, 0);
        List<String> sortListString = Arrays.asList("一","二","三","四","五","六","测试","八");
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"sss");
        map.put(21,"sss");
        map.put(1,"sss");
        map.put(0,"sss");
        /*集合排序*/
        //Collections.sort(sortList,(x,y) ->y.compareTo(x));
        //sortList.sort((x,y) ->y.compareTo(x));
        /*Collections.sort(sortList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
        sortListString.sort((a,b) ->a.compareTo(b));
        /*****out******/
        sortList.forEach(System.out::println);
        sortListString.forEach(System.out::println);
    }
}
