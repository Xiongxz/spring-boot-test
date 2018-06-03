package com.xxz.mapper;

import com.xxz.model.UserInfo;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@RegisterMapper
public interface UserInfoMapper extends Mapper<UserInfo> {

}