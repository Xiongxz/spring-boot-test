package com.xxz;

import com.xxz.model.UserInfo;
import com.xxz.util.Utils;
import org.apache.catalina.User;
import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MavenspringbootApplicationTests {
    public static final Logger LOG = LoggerFactory.getLogger(MavenspringbootApplicationTests.class);

    @Test
    public void classGeneric() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(123L);
        userInfo.setUserName("熊爷爷");
        userInfo.setPassWord("mima");
        userInfo.setUserAge(18);
        userInfo.setStartDate(new Date());
        try {
            LOG.info("泛型类测试：{}", Utils.getObjectTest(userInfo));
            UserInfo userInfos = Utils.getObjectTest(userInfo);
            System.out.println("userName : "+userInfos.getUserName());
        }catch (Exception e){
            LOG.info("error message : {}",e.getMessage());
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }

    //@Test
    public void dataTest() {
        TreeSet<UserInfo> set = new TreeSet();
        Set sets = new HashSet();
        set.add(new UserInfo(65L, "adminpwd", new Date(), 12, "熊相正"));
        set.add(new UserInfo(65L, "adminpwd", new Date(), 12, "熊相正"));
        set.add(new UserInfo(65L, "adminpwd", new Date(), 12, "熊相正"));
        set.add(new UserInfo(65L, "adminpwd", new Date(), 12, "熊相正"));
        System.out.println(set);
    }
}
