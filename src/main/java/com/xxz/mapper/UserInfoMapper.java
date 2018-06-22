package com.xxz.mapper;

import com.xxz.model.UserInfo;
import tk.mybatis.mapper.common.Mapper;
public interface UserInfoMapper extends Mapper<UserInfo> {

    int deleteUserAll(Long[] id);
}