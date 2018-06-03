package com.xxz;

import com.xxz.model.UserInfo;
import com.xxz.util.SidWorker;
import com.xxz.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MavenspringbootApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(MavenspringbootApplicationTests.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userInfoTest() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        map.add("userId", String.valueOf(SidWorker.nextSid()));
        map.add("userName", "测试");
        map.add("passWord", "123456789");
        map.add("userAge", "18");
        map.add("startDate", new Date().toString());
        /*
         perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
         andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
         andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
         andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
         */
        mockMvc.perform(MockMvcRequestBuilders.post("/saveuser")//构造请求
                .accept(MediaType.APPLICATION_JSON_UTF8).params(map))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())//添加一个结果处理器
                .andReturn().getResponse().getContentAsString();
    }

    //@Test
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
            System.out.println("userName : " + userInfos.getUserName());
        } catch (Exception e) {
            LOG.info("error message : {}", e.getMessage());
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
