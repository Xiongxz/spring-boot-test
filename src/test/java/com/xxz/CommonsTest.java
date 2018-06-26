package com.xxz;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @Auther: Administrator
 * @Date: 2018/6/21 0021 22:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonsTest {
    @Test
    public void utilsStringTest() {
        String str = "测试-ss1";
        //isEmpty
        System.out.println("数组为空返回true : " + ArrayUtils.isEmpty(new int[]{}));
        System.out.println("为空返回true : " + StringUtils.isEmpty(null));
        System.out.println("不为空返回true :" + StringUtils.isNotEmpty(""));
        System.out.println("任何一个为空返回true ： " + StringUtils.isAnyEmpty("ss", "3", "4", ""));
        System.out.println("全部为空返回true : " + StringUtils.isAllEmpty("", "", null));
        System.out.println("全部为小写返回true : " + StringUtils.isAllLowerCase("ABCc"));
        System.out.println("全部为大写返回true : " + StringUtils.isAllUpperCase("abcA"));
        System.out.println("包含某个字符串 : " + str.contains("ss"));
        str = str.substring(0, str.lastIndexOf("s"));
        System.out.println(str);
        System.out.println("首字母大写 : " + StringUtils.capitalize("asc"));
        System.out.println(StringUtils.chomp(null));
        System.out.println("全部为数字组成为true : " + StringUtils.isNumeric("99990"));
        System.out.println("删除空白符 : " + StringUtils.trimToNull("aaa"));
        String strs = "  ";
        System.out.println("默认字符函数-如果第一个参数为空，这返回第二个默认参数 : " + StringUtils.defaultIfBlank(strs, null));
    }
}
