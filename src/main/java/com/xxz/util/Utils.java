package com.xxz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class Utils {

    /*public static String uploadFile(byte[] file,String fileName,String filePath) throws Exception {
        if(request instanceof MultipartHttpServletRequest){
            try {
            MultipartFile file =  ((MultipartHttpServletRequest) request).getFile("file");
            String filePath = request.getSession().getServletContext().getRealPath("img/");
            String fileName = file.getOriginalFilename();
            String newName = getUUID()+fileName.substring(fileName.indexOf("."),fileName.length());
            File targetFile = new File(filePath);
            if(!file.isEmpty()){
                System.out.println("文件路径: " + filePath);
                System.out.println("文件名称：" + fileName);
                System.out.println("文件新名称：" + newName );
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                FileOutputStream out = new FileOutputStream(filePath+newName);
                out.write(file.getBytes());
                out.flush();
                out.close();
                return filePath+newName;
            }
        } catch (Exception e) {
                e.printStackTrace();}
        }
        return "";
    }*/
    public static void uploadFile(byte[] file,String filePath,String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().toLowerCase();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    static public String outofnull(String str) {
        if (str == null) {
            str = "";
        } else if (str.toLowerCase().equals("null")) {
            str = "";
        }
        return str.trim();
    }
}
