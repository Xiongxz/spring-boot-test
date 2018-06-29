package com.xxz;

import com.xxz.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2018/6/29 0029 21:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringBufferTest {
    @Test
    public void stringBufferTest() {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("A");
        String astr = "A";
        String bstr = "A";
        System.out.println(a + "." + b);
        System.out.println(a.equals(b));//StringBuffer类继承Object类的equals方法，比较的是对象的地址，这里是两个对象，返回false
        System.out.println(a.equals(astr));//返回false，需要比较内容时，可以将StringBuffer用toString()转换
        System.out.println(a == b);//比较内存地址返回false

        System.out.println(astr.equals(bstr));//String类重写equals方法，所以比较字符串的内容
        System.out.println(astr == bstr);//比较内存地址，String不可变，指向同一个地址返回true


        StringBuffer c = new StringBuffer("C");
        StringBuffer d = new StringBuffer("D");

        String cstr = "C";
        String dstr = "D";
        cont(c, d);
        System.out.println(c + "." + d);

        UserInfo u1 = new UserInfo();
        UserInfo u2 = new UserInfo();
        /**
         * @see Object#equals(Object)
         * 全部返回false应为Object 类的equals方法判断的是对象引用的地址，使用的是==
         */
        System.out.println("对象 equals : " +u1.equals(u2));
        System.out.println(u1==u2);


    }
    static void cont(StringBuffer c, StringBuffer d) {
        c.append(d);
        d = c;
        // 是因为StringBuffer d)这里是局部变量，你把d=c;这里确实等于CD,但是这个变量的范围是这个方法，方法结束，变量消失，带不出去的。
        System.out.println("方法内的 d : " + d);
    }
}
