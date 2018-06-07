package com.xxz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
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
}
