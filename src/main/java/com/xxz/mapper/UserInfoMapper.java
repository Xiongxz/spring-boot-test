package com.xxz.mapper;

import com.xxz.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {

    UserInfo getUserInfoById(@Param("userId") Long userId);

    UserInfo getUserInfoByUserAndPassword(@Param("userName") String userName, @Param("passWord") String passWord);

    int deleteUserAll(Long[] id);
}