package com.xxz.mapper;

import com.xxz.model.Mybatistest;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MybatistestMapper extends Mapper<Mybatistest> {
    int batchMybatisTest(List<Mybatistest> list);

    List<Mybatistest> selectByIdorName(@Param("id") Integer id,@Param("name") String name);
}