package com.xxz;

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
public class StringTest {
    @Test
    public void utilsStringTest(){
        String sData = "233232";
        String eData = "";
        assert(StringUtils.isBlank(sData)):"该字符串不为空";
    }
}
