package com.xxz.controller;

import com.xxz.configconsts.ConfigConsts;
import com.xxz.model.UserInfo;
import com.xxz.serviceimpl.UserServiceImpl;
import com.xxz.util.SidWorker;
import com.xxz.util.Utils;
import com.xxz.util.ZYJSONResult;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: xxz
 * @Date: 2018/5/26 0026 14:11
 * @Description:login interceptor variable
 */
@Api(value = "用户接口", tags = "用户接口", description = "包含用户登录，CRUD")
@Controller
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

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
        ModelAndView mav = new ModelAndView();
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

    @PostMapping("/login")
    @ResponseBody
    public ZYJSONResult shiroLogin(@RequestParam(name = "username", required = true) String userName, @RequestParam(name = "password", required = true) String passWord) {
        if (StringUtils.isAnyBlank(userName, passWord))
            return ZYJSONResult.errorException("userName or passWord is empty");

        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ZYJSONResult.ok();
        } catch (AuthenticationException e) {
            return ZYJSONResult.errorMsg(e.getMessage());
        }
    }

    @PostMapping("/saveuser")
    @ResponseBody
    public ZYJSONResult saveUser(@ModelAttribute UserInfo userInfo) {
        userInfo.setUserId(SidWorker.nextSid());
        userInfo.setUserName("admin");
        userInfo.setPassWord(Utils.getUUID());
        userInfo.setUserAge(18);
        userInfo.setStartDate(new Date());
        userInfo.setEndDate(LocalDateTime.now());
        return ZYJSONResult.ok(this.userServiceImpl.saveUser(userInfo));
    }

    @DeleteMapping("/deleteuserall")
    @ResponseBody
    public ZYJSONResult deleteUserAll() {
        Long[] id = {2018070615292517800L, 2018070615321764100L, 2018070615321893500L, 2018070615322007500L};
        return ZYJSONResult.ok(this.userServiceImpl.deleteUserAll(id));
    }

    @GetMapping("/getuserinfobyid")
    @ResponseBody
    public ZYJSONResult getUserInfoById(@RequestParam(name = "userId", required = true) Long userId) {
        return ZYJSONResult.ok(this.userServiceImpl.getUserInfoById(userId));
    }

    @GetMapping("/getuserall")
    @ResponseBody
    public ZYJSONResult getUserAll() {
        LOG.info("通用Mapper查询测试");
        return ZYJSONResult.ok(this.userServiceImpl.selectAll());
    }
}
