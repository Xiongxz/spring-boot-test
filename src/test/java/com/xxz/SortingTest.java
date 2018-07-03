package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
    @Test
    public void bubbleSort(){
        int[] ints = {1,2,4,5,7,78,23,34,33,33,4,5,23,32,43,65,78,9809,9,0,-1,-12,12};
        for (int i = 0; i < ints.length-1; i++) {
            boolean flag = true;
            for(int j = 0 ;j<ints.length-1-i;j++){
                int temp ;
                if(ints[j]>ints[j+1]){
                    temp = ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void ArraysSortTest(){
        Integer[] ints = {1,2,3,56,7,3,-1,0,45};
        Arrays.sort(ints,(x,y) ->x.compareTo(y));
        System.out.println(Arrays.toString(ints));
    }
}
