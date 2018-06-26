package com.xxz.controller;

import com.xxz.exception.AesException;
import com.xxz.util.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Auther: Xiongxz
 * @Date: 2018/6/26 0026 20:41
 * @Description: 微信服务器校验
 */
@RestController
public class WeChat {
    public static final Logger LOG = LoggerFactory.getLogger(WeChat.class);

    @GetMapping("/wechat")
    public void checkWchat(HttpServletRequest request, HttpServletResponse response) throws AesException, UnsupportedEncodingException {
        LOG.info("Enter the check!!!");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String signature =  request.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String timestamp =  request.getParameter("timestamp");//时间戳
        String nonce =  request.getParameter("nonce");//随机数
        String echostr =  request.getParameter("echostr");//随机字符串
        String token = "XXZ654962327ZXCVBNM"; // 这里填写自己的 token(微信配置)
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(signature.equals(SHA1.getSHA1(token,timestamp,nonce,echostr))){
                LOG.info("check success!!!");
                out.write(echostr);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
}
