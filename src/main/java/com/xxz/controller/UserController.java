package com.xxz.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xxz.configconsts.ConfigConsts;
import com.xxz.model.UserInfo;
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
import javax.servlet.http.HttpSession;

/**
 * @Auther: xxz
 * @Date: 2018/5/26 0026 14:11
 * @Description:login interceptor variable
 */
@Controller
public class UserController {

    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @PostMapping("/userlogin")
    public ModelAndView userLogin(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, HttpServletRequest request, HttpServletResponse response) {
        String sendRedirectUrl = "redirect:/index.html";//登录后要重定向的URL
        HttpSession session = request.getSession();
        ModelAndView mav=new ModelAndView();
        UserInfo user = new UserInfo();
        try {
            LOG.info("UserName: {} and PassWord: {}", username, password);
            if (!username.equals(user.getUserName()) | !password.equals(user.getPassWord())) {
                mav.addObject("loginvalidate", "登陆失败,请输入正确的账号或密码！");
                sendRedirectUrl = "redirect:/login.html";
                mav.setViewName(sendRedirectUrl);
            }
            session.setAttribute(ConfigConsts.USER_SESSION, user);
            mav.setViewName(sendRedirectUrl);
            return mav;
        } catch (Exception e) {
            mav.addObject("loginvalidate", "System error");
        }
        return mav;
    }
}
