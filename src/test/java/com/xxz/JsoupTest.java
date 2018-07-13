package com.xxz;

import com.xxz.model.Food_Type;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xiongxz
 * @Date: 2018/7/12 13:06
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupTest {

    /**
     * @param url 访问路径
     * @return
     */
    public Document getDocument(String url) {
        try {
            //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void jsoupTestFood() {
        //爬取食品分类http://db.foodmate.net/2760-2014/additives-category-catid-1.html
        JsoupTest t = new JsoupTest();
        Document doc = t.getDocument("http://db.foodmate.net/2760-2014/additives-category-catid-1.html?m=additives&a=category&q=");
        Elements elements1 = doc.select("table");
        Elements elements2 = elements1.select("[class=py_ py2]");
        List<Food_Type> listFoodType = new ArrayList<>();//爬取的结果集
        for (int i = 0; i < elements2.size(); i++) {
            Food_Type food_type = new Food_Type();
            String noStr = elements2.get(i).select("td").get(0).text();
            String nameStr = elements2.get(i).select("a").text();
            food_type.setId(noStr);
            food_type.setName(nameStr);
            listFoodType.add(food_type);
            //System.out.println("食品一级 : 第 +" + i + "次" +"分类编号 ：" + noStr + "分类名称：" + nameStr);
        }
        //listFoodType.forEach((x) -> System.out.println("编码：" +x.getId()+"名称："+x.getName()));
        List<Food_Type> foodData = new ArrayList<>();//封装pid
        for (Food_Type food_type : listFoodType) {
            Food_Type food_typeData = new Food_Type();
            String leftStr = StringUtils.substringBeforeLast(food_type.getId(), ".");
            String rightStr = StringUtils.substringAfterLast(food_type.getId(), ".");
            //System.out.println("ID：" + food_type.getId() + "left：" + leftStr + "right：" + rightStr + "名称 ：" + food_type.getName());
            food_typeData.setName(food_type.getName());
            food_typeData.setId(food_type.getId());
            //设置父ID
            for (Food_Type foodTypes : listFoodType) {
                int num = StringUtils.countMatches(food_type.getId(), ".");
                if (rightStr.equals("0")) {
                    food_typeData.setParent_Id("0");
                    break;
                }
                if (num == 1) {
                    if (foodTypes.getId().contains(leftStr)) {
                        food_typeData.setParent_Id(foodTypes.getId());
                        break;
                    }
                } else {
                    if (foodTypes.getId().equals(leftStr)) {
                        food_typeData.setParent_Id(foodTypes.getId());
                        break;
                    }
                }
            }
            foodData.add(food_typeData);
        }
        System.out.println("结果集长度：" + foodData.size());
        foodData.forEach(x -> System.out.println("编码：" + x.getId() + "---->父级ID ：" + x.getParent_Id() + "---->名称：" + x.getName()));
    }


    @Test
    public void jsoupTest() {
        JsoupTest t = new JsoupTest();
        Document doc = t.getDocument("http://www.weather.com.cn/weather/101230101.shtml");
        // 获取目标HTML代码
        Elements elements1 = doc.select("[class=t clearfix]");
        //今天
        Elements elements2 = elements1.select("[class=sky skyid lv2 on]");
        String today = elements2.get(0).text();
        System.out.println("今日天气： " + today);

        //几号
        Elements elements3 = elements1.select("h1");
        String number = elements3.get(0).text();
        System.out.println("日期： " + number);

        // 天气
        Elements elements4 = elements1.select("[class=wea]");
        String rain = elements4.get(0).text();
        System.out.println("天气： " + rain);

        // 最高温度
        Elements elements5 = elements1.select("span");
        String highTemperature = elements5.get(0).text() + "°C";
        System.out.println("最高温：" + highTemperature);

        // 最低温度
        Elements elements6 = elements1.select(".tem i");
        String lowTemperature = elements6.get(0).text();
        System.out.println("最低温：" + lowTemperature);

        // 风力
        Elements elements7 = elements1.select(".win i");
        String wind = elements7.get(2).text();
        System.out.println("风力：" + wind);

    }
}
