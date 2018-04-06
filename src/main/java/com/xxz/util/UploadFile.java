package com.xxz.util;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
@Service
public class UploadFile {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        System.out.println("文件:"+file);
        System.out.println("文件路径:"+filePath);
        System.out.println("文件名称："+fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
