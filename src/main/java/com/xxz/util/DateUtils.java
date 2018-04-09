package com.xxz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xxz on 2018/4/9 0009
 */
public class DateUtils {
    /**
     * 获取当前时间-格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 获取当前时间-格式：yyyy-MM-dd
     * @return
     */
    public static String getCurrentDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
    }
}
