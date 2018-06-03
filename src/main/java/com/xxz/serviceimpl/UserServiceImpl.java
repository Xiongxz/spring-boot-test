package com.xxz.serviceimpl;

import com.xxz.mapper.UserInfoMapper;
import com.xxz.model.UserInfo;
import com.xxz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Xiong xz
 * @Date: 2018/6/2 0002 20:40
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 通用mapper
     *
     * @return
     */
    @Override
    public List<UserInfo> selectAll() {
        return this.userInfoMapper.selectAll();
    }

    @Override
    public int saveUser(UserInfo userInfo) {
        return this.userInfoMapper.insert(userInfo);
    }


}
