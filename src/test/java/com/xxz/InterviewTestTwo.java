package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2018/7/1 0001 21:37
 * @Description: 测试jdk8中接口定义默认方法和静态方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewTestTwo implements InterviewTest.interfaceOne{
     @Test
     public void interviewTestTwo(){
         System.out.println(InterviewTest.interfaceOne.getStrTestOne());//接口中的静态方法，需要创建实例使用
         System.out.println(this.getStrTestTwo());//默认方法
     }
}
