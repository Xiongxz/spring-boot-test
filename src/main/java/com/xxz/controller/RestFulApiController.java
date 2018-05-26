package com.xxz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Administrator
 * @Date: 2018/5/26 0026 23:44
 * @Description:参数绑定测试类
 */
@RestController
@RequestMapping("/api")
public class RestFulApiController {
    public static final Logger LOG = LoggerFactory.getLogger(RestFulApiController.class);

    /**
     * GET
     * RequestParam参数绑定(映射)
     *
     * @param userId
     * @param userName
     * @return
     */
    @GetMapping("/getapi")
    public String getApi(@RequestParam(name = "userId", required = true) String userId,
                         @RequestParam(name = "userName", required = true) String userName) {
        LOG.info("getApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }

    /**
     * POST
     * RequestParam参数绑定(映射)
     *
     * @param userId
     * @param userName
     * @return
     */
    @PostMapping("/postapi")
    public String postApi(@RequestParam(name = "userId", required = true) String userId,
                          @RequestParam(name = "userName", required = true) String userName) {
        LOG.info("postApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }

    /**
     * @param userId
     * @param userName
     * @return
     * @PathVariable绑定URI模板变量值
     */
    @GetMapping("/{userId}/{userName}")
    public String getPathVariableApi(@PathVariable(name = "userId", required = true) String userId,
                                     @PathVariable(name = "userName", required = true) String userName) {
        LOG.info("getPathVariableApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }

    /**
     * @param userId
     * @param userName
     * @return
     * @PathVariable绑定URI模板变量值
     */
    @PostMapping("/{userId}/{userName}")
    public String postPathVariableApi(@PathVariable(name = "userId", required = true) String userId,
                                      @PathVariable(name = "userName", required = true) String userName) {
        LOG.info("postPathVariableApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }
}
