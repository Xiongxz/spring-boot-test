package com.xxz.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xxz.util.Utils;
import com.xxz.util.ZYJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.rmi.CORBA.Util;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: xxz
 * @Date: 2018/5/26 0026 14:11
 * @Description:login interceptor variable
 */
@Controller
public class UserController {

    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userlogin")
    public void userLogin(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, HttpServletRequest request, HttpServletResponse response) {
        String sendRedirectUrl="index";//登录后要重定向的URL
        try {
            LOG.info("username: {},password: {}", username, password);
            if (!username.equals("admin") | !password.equals("1")) {
                request.setAttribute("errors", "登陆失败,请输入正确的账号或密码！");
                sendRedirectUrl = "login.html";
                RequestDispatcher dispatcher = request.getRequestDispatcher(sendRedirectUrl);
                dispatcher.forward(request, response);
                return ;
            }
            response.sendRedirect(sendRedirectUrl);
        } catch (Exception e) {
            request.setAttribute("errors", "System error");
        }
    }
}
