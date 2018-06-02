package com.xxz.util;

import com.alibaba.fastjson.JSON;
import com.xxz.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
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
}
