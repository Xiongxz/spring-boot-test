package com.xxz.service;

import com.xxz.model.Mybatistest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Xiong xz
 * @Date: 2018/6/9 0009 21:30
 * @Description:
 */
@Service
public interface MybatisTestService {
    int saveMybatisTest(Mybatistest mybatistest);

    int batchMybatisTest(List<Mybatistest> list);

    List<Mybatistest> selectByIdorName(Integer id,String name);
}
