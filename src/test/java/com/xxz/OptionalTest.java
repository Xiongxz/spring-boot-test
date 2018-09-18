package com.xxz;

import com.xxz.model.Person;
import com.xxz.model.UserInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @description:
 * @author: Xiongxz
 * @create: 2018-09-18 11:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {
    @Test
    public void opTest() {
        UserInfo one = new UserInfo();
        UserInfo two = new UserInfo();
        UserInfo three = null;
        Optional<UserInfo> optional = Optional.ofNullable(one);
        System.out.println(optional.isPresent());
        System.out.println(Objects.nonNull(one));
        System.out.println(Objects.isNull(three));
        //System.out.println(optional.get());
    }
}
