package com.xxz.service;

import com.xxz.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/2 0002 20:41
 * @Description:
 */
@Service
public interface UserService {
    int deleteUserById(Long userId);

    int saveUser(UserInfo userInfo);

    int saveUserSelective(UserInfo userInfo);

    List<UserInfo> selectUserAll();

    UserInfo selectUserById(Long userId);

    int updateByIdSelective(UserInfo userInfo);

    int updateById(UserInfo userInfo);
}
