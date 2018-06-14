package com.xxz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * springboot启动类，从上往下扫描，所以在包目录顶层
 * 否则注入失败
 *
 * @author xxz
 */
@SpringBootApplication
@MapperScan("com.xxz.mapper")//使用通用mapper注解

public class PandaspringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(PandaspringbootApplication.class, args);
    }
}
