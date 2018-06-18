package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/18 0018 15:26
 * @Description: m选n组合测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyChoiceNnber {
    public static final Logger LOG = LoggerFactory.getLogger(ManyChoiceNnber.class);

    @Test
    public void mcnTest() {
        int num = 3;
        String[] strings = {"1", "3", "2", "4", "6", "5"};
        List<String> listOne = this.combine(strings, num);

        //listOne.forEach(System.out::println);
        System.out.println("组合个数 one: " + listOne.size());

        List<String> listTwo = getPart(num, "124365");
        System.out.println("组合个数 two:" + listTwo.size());
        //listTwo.forEach(System.out::println);

        System.out.println("组合个数：" + C(9, 3));
        System.out.println("组合个数："+CombinatorialNumber(9, 3));

    }

    public int CombinatorialNumber(int m, int n) {
        int num = 1;
        int ms = m;
        int ns = n*n;
        for (int i = n; i > 0; i--) {
            num *= m;
            m--;
        }
        System.out.println("公式 ： " + num);
        return num/(n*2);
    }

    public static int C(int below, int up)//应用组合数的互补率简化计算量
    {
        int helf = below / 2;
        if (up > helf) {
            System.out.print(up + "---->");
            up = below - up;
            System.out.print(up + "\n");

        }
        int denominator = A(up, up);//A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
        //分子
        int numerator = A(up, below);//分子的排列数
        System.out.println(" 计算组合个数： " + numerator + "/" + denominator);
        return numerator / denominator;

    }

    //求排列数
    public static int A(int up, int bellow) {
        int result = 1;
        for (int i = up; i > 0; i--) {
            result *= bellow;
            bellow--;
        }
        return result;
    }
   /* private static ArrayList<String> getPartStepOne(int num, String s) {
        return getPart(num, alignmentString(s));
    }*/

    private static String alignmentString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (c[i] > c[j]) {
                    char t = c[i];
                    c[i] = c[j];
                    c[j] = t;
                }
            }
        }
        return new String(c);
    }

    private static ArrayList<String> getPart(int num, String s) {
        ArrayList<String> finalss = new ArrayList<String>();
        if (num == 1) {
            char[] c = s.toCharArray();
            String laststr = "";
            for (int i = 0; i < s.length(); i++) {
                String newstr = new String(c, i, 1);
                if (laststr.equals(newstr))
                    continue;
                laststr = newstr;
                finalss.add(newstr);
            }
            return finalss;
        }
        if (num >= s.length()) {
            finalss.add(s);
            return finalss;
        }
        int len = s.length();
        char lastc = ' ';
        for (int i = 0; i < (len - num + 1); i++) {
            char c = s.charAt(i);
            if (lastc == c)
                continue;
            lastc = c;
            ArrayList<String> al = getPart(num - 1, s.substring(i + 1));
            for (String ss : al) {
                finalss.add(c + ss);
            }
        }
        return finalss;
    }

    private List<String> combine(String[] a, int num) {
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else
                b[i] = "0";
        }

        int point = 0;
        int nextPoint = 0;
        int count = 0;
        int sum = 0;
        String temp = "1";
        while (true) {
            // 判断是否全部移位完毕
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if (b[i].equals("1"))
                    sum += 1;
            }
            // 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("1")) {
                    point = i;
                    sb.append(a[point]);
                    sb.append(" ");
                    count++;
                    if (count == num)
                        break;
                }
            }
            // 往返回值列表添加数据
            list.add(sb.toString());

            // 当数组的最后num位全部为1 退出
            if (sum == num) {
                break;
            }
            sum = 0;

            // 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i].equals("1") && b[i + 1].equals("0")) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }
            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++)
                for (int j = i; j < point - 1; j++) {
                    if (b[i].equals("0")) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                    }
                }
            // 清空 StringBuffer
            sb.setLength(0);
            count = 0;
        }
        //
        System.out.println("数据长度 " + list.size());
        return list;
    }
}
