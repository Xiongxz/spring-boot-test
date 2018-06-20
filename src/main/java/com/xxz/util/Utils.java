package com.xxz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utils {
    /**
     * 日志
     */
    public static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    /**
     * 文件上传
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 泛型类测试
     * @param o
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T getObjectTest(T o) throws IllegalAccessException, InstantiationException {
        LOG.info("Utils对象类型：{}", o);
        return  o;
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().toLowerCase();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    /**
     * 去null
     *
     * @param str
     * @return
     */
    static public String outofnull(String str) {
        if (str == null) {
            str = "";
        } else if (str.toLowerCase().equals("null")) {
            str = "";
        }
        return str.trim();
    }

    /**
     * 生成固定大小随机数
     * @param minNumber 最大数
     * @param maxNumber 最小数
     * @return 返回随机数 公式（ 最大取值-最小取值+1）
     */
    public synchronized static int randomNumber(int minNumber,int maxNumber){
        Random rand = new Random();
        return rand.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    /**
     * M选N
     * @param a M
     * @param num n
     * @return
     */
    public static List<String> combine(String[] a, int num) {
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
