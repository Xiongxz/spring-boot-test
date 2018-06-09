package com.xxz.serviceimpl;

import com.xxz.mapper.MybatistestMapper;
import com.xxz.model.Mybatistest;
import com.xxz.service.MybatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Xiong xz
 * @Date: 2018/6/9 0009 21:31
 * @Description:
 */
@Service
public class MybatisTestServiceImpl implements MybatisTestService{
    @Autowired
    private MybatistestMapper mybatistestMapper;


    @Override
    public int saveMybatisTest(Mybatistest mybatistest) {
       return this.mybatistestMapper.insert(mybatistest);
    }

    @Override
    public int batchMybatisTest(List<Mybatistest> list) {
        return this.mybatistestMapper.batchMybatisTest(list);
    }

    @Override
    public List<Mybatistest> selectByIdorName(Integer id, String name) {
        return this.mybatistestMapper.selectByIdorName(id,name);
    }

}
