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
    List<UserInfo> selectAll();
    int deleteUserAll(Long[] id);
    int saveUser(UserInfo userInfo);
}
