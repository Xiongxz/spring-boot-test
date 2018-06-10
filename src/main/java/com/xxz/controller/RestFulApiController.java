package com.xxz.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Auther: Administrator
 * @Date: 2018/5/26 0026 23:44
 * @Description:参数绑定测试类
 * 具体使用举例说明：
 *@Api()
 *用于类；表示标识这个类是swagger的资源
 *tags–表示说明
 *value–也是说明，可以使用tags替代
 *但是tags如果有多个值，会生成多个list
 *swagger详见： http://www.mamicode.com/info-detail-2106701.html
 */
@Api(tags = "RestFulApi测试", description = "用于测试RestFul风格Api")
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
     *
     *@ApiOperation() 用于方法；表示一个http请求的操作
     *value用于方法描述
     *notes用于提示内容
     *tags可以重新分组（视情况而用）
     *
     * @ApiImplicitParam() 用于方法
     * 表示单独的请求参数
     * @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
     * name–参数ming
     * value–参数说明
     * dataType–数据类型
     * paramType–参数类型
     * example–举例说明
     */
    @ApiOperation(value = "获取用户信息", notes = "测试@RequestParam注解绑定 get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "用户姓名", dataType = "string", paramType = "query", required = true)
    })
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
     *
     * @ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
     * name–参数名
     * value–参数说明
     * required–是否必填
     */
    @ApiOperation(value = "获取用户信息", notes = "测试@RequestParam注解绑定 post请求")
    @PostMapping("/postapi")
    public String postApi(@ApiParam(name = "userId", value = "用户ID", required = true) @RequestParam(name = "userId", required = true) String userId,
                          @ApiParam(name = "userName", value = "用户姓名", required = true) @RequestParam(name = "userName", required = true) String userName) {
        LOG.info("postApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }

    /**
     * @param userId
     * @param userName
     * @return
     * @PathVariable绑定URI模板变量值
     */
    @ApiOperation(value ="获取用户信息",notes = "测试@PathVariable注解绑定 get请求")
    @GetMapping("/{userId}/{userName}")
    public String getPathVariableApi(@ApiParam(name = "userId",value = "用户Id",required = true) @PathVariable(name = "userId", required = true) String userId,
                                     @ApiParam(name = "userName",value = "用户姓名",required = true) @PathVariable(name = "userName", required = true) String userName) {
        LOG.info("getPathVariableApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }

    /**
     * @param userId
     * @param userName
     * @return
     * @PathVariable绑定URI模板变量值
     */
    @ApiOperation(value ="获取用户信息",notes = "测试@PathVariable注解绑定 post请求")
    @PostMapping("/{userId}/{userName}")
    public String postPathVariableApi(@ApiParam(name = "userId",value = "用户Id",required = true) @PathVariable(name = "userId", required = true) String userId,
                                      @ApiParam(name = "userName",value = "用户姓名",required = true) @PathVariable(name = "userName", required = true) String userName) {
        LOG.info("postPathVariableApi ------ userID : {} and userName : {}", userId, userName);
        return userId + userName;
    }
}
