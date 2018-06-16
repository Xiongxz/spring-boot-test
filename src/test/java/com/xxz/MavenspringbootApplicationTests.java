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

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MavenspringbootApplicationTests {

    public static final Logger LOG = LoggerFactory.getLogger(MavenspringbootApplicationTests.class);

    @Autowired
    private MockMvc mockMvc;

    /**
     * 接口测试
     *
     * @throws Exception
     */
    //@Test
    public void userInfoTest() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        map.add("userId", String.valueOf(SidWorker.nextSid()));
        map.add("userName", "测试");
        map.add("passWord", "123456789");
        map.add("userAge", "18");
        map.add("startDate", new Date().toString());
         /* perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
         andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
         andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
         andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；*/
        mockMvc.perform(MockMvcRequestBuilders.post("/saveuser")//构造请求
                .accept(MediaType.APPLICATION_JSON_UTF8).params(map))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())//添加一个结果处理器
                .andReturn().getResponse().getContentAsString();
    }

    /**
     * 泛型类测试
     */
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

    /**
     * 集合测试
     */
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

    /**
     * 随机取值测试
     */
    //@Test
    public void randomNumberTest() {
        Integer[] subjectId = {50, 51, 52, 53, 54, 55, 56};
        StringBuffer subjectIdsGroup = new StringBuffer("");
        String iterationValue = "";
        for (int a = 0; a < 100; a++) {
            subjectIdsGroup.setLength(0);//清空
            for (int i = 0; i < 3; i++) {
                while (true) {
                    iterationValue = String.valueOf(subjectId[Utils.randomNumber(0, 6)]);
                    if (subjectIdsGroup.indexOf(iterationValue) != -1) {//包含
                        continue;
                    } else {
                        subjectIdsGroup.append(iterationValue);
                        break;
                    }
                }
                if (i < 2) {
                    subjectIdsGroup.append(",");
                }
            }
            System.out.println("随机取选课ID：" + a + "----" + subjectIdsGroup);
        }
    }

    /*组合测试*/
    @Test
    public void proportionTest() {
        String[] str = {"物理", "化学", "生物", "政治", "历史", "地理", "技术"};
        String[] intTemp = {"23", "123", "32", "242"};
        //物理	化学	生物	政治	历史	地理
        //LOG.info("length {} " ,str.length);
        //LOG.info("比例 {} ", intTemp.length * 6 * 5 * 4 * 3);
        List<String> list = this.combine(intTemp, 3);
        list.forEach(System.out::println);


    }

    /**
     * 求组合数
     * 从m中取n个组合
     *
     * @param m
     * @param n
     * @return 组合
     */
    private List<Integer> proportionNumberTest(Integer[] m, int n) {
        int count = 0;
        List<Integer> listNumber = new ArrayList<>();//总计组合
        List<Integer> listTemp = new ArrayList<>();//临时
        if (m.length > 0 && n > 0) {
            while (true) {
                for (int i = 0; i < m.length; i++) {
                    //m[i]+",";
                }
            }
        } else {
            return null;
        }
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

    /**
     * lambda测试
     */
    //@Test
    public void lambdaTest() {
        //List
        List<Integer> listInteger = Arrays.asList(2, 3, 32, 33, 12, 2, 1, 3, 4, 4, 5, 55, 5);
        List<String> listString = Arrays.asList("测试", "haha", "分", "访问", "范围分为", "废物废物", "范围分为范文芳", "方法", "固定", "检验员", "废物s", "23", "qqa");
        List<UserInfo> userInfoList = new ArrayList<>();
        List<UserInfo> userInfoLists = new ArrayList<>();
        Map<Integer, Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            userInfoList.add(new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
            map.put(Utils.randomNumber(0, 6), new UserInfo(Long.valueOf(Utils.randomNumber(0, 6)), "123456", new Date(), 12, "测试"));
        }
        //userInfoLists = userInfoList.stream().collect(Collectors.toList());
        Integer[] integers = {1, 2, 34, 543, 454, 4353, 243, 22, 4, 5, 6};
        listInteger.sort((Integer::compare));//排序
        listInteger.forEach(x -> System.out.println("listInteger : " + x));//迭代
        listString.stream().filter((x) -> x.endsWith("s")).forEach((s) -> System.out.println("包含某个字符串 ：" + s));
        listString.stream().filter((x) -> !x.endsWith("s")).forEach((s) -> System.out.println("排除某个字符串 ：" + s));
        //listString.forEach(System.out::println);

        userInfoList.sort((a, b) -> b.getUserId().compareTo(a.getUserId()));//排序
        userInfoList.forEach((userInfo -> System.out.println(userInfo.getUserId() + "--" + userInfo.getUserName())));//迭代操作数据
        System.out.println(userInfoList.stream().count() + "," + userInfoList.size());
        int listMax = userInfoList.stream().mapToInt((x) -> x.getUserId().intValue()).max().getAsInt();
        int listMix = userInfoList.stream().mapToInt((x) -> x.getUserId().intValue()).min().getAsInt();
        int listSum = userInfoList.stream().mapToInt((x) -> x.getUserId().intValue()).sum();
        double listavg = userInfoList.stream().mapToInt((x) -> x.getUserId().intValue()).average().getAsDouble();
        System.out.println("max : " + listMax + " min : " + listMix + " sum : " + listSum + " avg : " + listavg);
        //listInteger.forEach(x -> lambdaTest());
        //listInteger.forEach(System.out::println);
    }

    //@Test
    public void listenerTest() {

    }
}
