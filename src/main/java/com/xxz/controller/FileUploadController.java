package com.xxz.controller;

import com.xxz.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Xiong xz
 * @Date: 2018/6/5 0005 23:10
 * @Description: 文件上传与下载
 */
@RestController
public class FileUploadController {
    public static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/redirectfileupload")
    public ModelAndView redirectFileUpload() {
        return new ModelAndView("fileupload");
    }

    @PostMapping("/fileupload")
    public void fileUpload(@RequestParam(name = "file") MultipartFile[] files, HttpServletRequest request) {
        LOG.info("图片上传开始,文件长度：{} " ,files.length);
        if (null != LOG && files.length > 0) {
            for (MultipartFile fileIt : files) {
                if (fileIt != null) {
                    String fileName = fileIt.getOriginalFilename();
                    fileName=fileName.substring(fileName.indexOf("."),fileName.length());
                    String fileType = fileIt.getContentType();
                    fileName = Utils.getUUID()+fileName;
                    String filePath="c:\\img\\";
                    try {
                        Utils.uploadFile(fileIt.getBytes(), filePath, fileName);
                    } catch (Exception e) {
                       LOG.error("system error : {}" ,e.getMessage());
                    }
                }
            }
        } else {
            LOG.info("file is null");
        }
    }

}
