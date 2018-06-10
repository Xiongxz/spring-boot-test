package com.xxz.controller;

import com.xxz.model.Mybatistest;
import com.xxz.serviceimpl.MybatisTestServiceImpl;
import com.xxz.util.ZYJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xiong xz
 * @Date: 2018/6/9 0009 17:28
 * @Description: 用于Mybatis测试
 */
@RestController
@Api(value = "测试Swagger",tags = "测试Swagger")
public class MybatisController {
    public static final Logger LOG = LoggerFactory.getLogger(MybatisController.class);

    @Autowired
    private MybatisTestServiceImpl mybatisTestService;

    @ApiOperation(value="通用mapper保存单个数据测试", notes = "添加测试")
    @PostMapping("/savemybatistest")
    public ZYJSONResult saveMybatisTest(){
        return ZYJSONResult.ok(mybatisTestService.saveMybatisTest(new Mybatistest(null,"熊相正")));
    }

    @ApiOperation(value="批量插入测试", notes = "批量测试")
    @PostMapping("/savebatchmybatistest")
    public ZYJSONResult savebatchMybatisTest(){
        List<Mybatistest> listData= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Mybatistest mybatistest = new Mybatistest();
            mybatistest.setName("熊相正测试"+i);
            listData.add(mybatistest);
        }
        LOG.info("数据长度 {} ",listData.size());
        return  ZYJSONResult.ok(this.mybatisTestService.batchMybatisTest(listData));
    }

    @ApiOperation(value="查询测试", notes = "查询测试")
    @GetMapping("/selectbyidorname")
    public ZYJSONResult selectByIdorName(){
        return ZYJSONResult.ok(this.mybatisTestService.selectByIdorName(30,"熊相正测试0"));
    }
}
