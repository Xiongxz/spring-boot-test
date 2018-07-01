package com.xxz;

import com.xxz.service.MybatisTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2018/7/1 0001 20:42
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewTest {
    @Test
    public void interviewTest() {
        System.out.println(0^0);
        System.out.println(0xaa | 0x55);
    }


    abstract class abstractOne{

    }
    abstract class abstractTwo{

    }
    interface interfaceOne{
        /**
         *java8中接口可以定义可以添加具体方法，可以是静态的也可以是非静态的，非静态的方法前面要使用关键字defualt
         * @return
         */
        public static String getStrTestOne(){
            return "One";
        }
        default String getStrTestTwo(){
            return "Two";
        }
    }
    interface interfaceTwo{

    }
    interface interfaceThree{

    }
}
