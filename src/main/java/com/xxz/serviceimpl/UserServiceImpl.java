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

    @Override
    public int deleteUserById(Long userId) {
        try {
            if (userId > 0)
                return this.userInfoMapper.deleteByPrimaryKey(userId);
            LOG.error("userId is less than 0");
        } catch (Exception e) {
            LOG.error("deleteUserById error : {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public int saveUser(UserInfo userInfo) {
        try {
            if (userInfo != null)
               return this.userInfoMapper.insert(userInfo);
            LOG.error("user can not null");
        } catch (Exception e) {
            LOG.error("saveUser error : {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public int saveUserSelective(UserInfo userInfo) {
        try {
            if (userInfo != null)
                return this.userInfoMapper.insertSelective(userInfo);
            LOG.error("user can not null");
        } catch (Exception e) {
            LOG.error("saveUserSelective error : {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public List<UserInfo> selectUserAll() {
        try {
            return this.userInfoMapper.selectUserAll();
        } catch (Exception e) {
            LOG.error("selectUserById error : {}", e.getMessage());
        }
        return null;
    }

    @Override
    public UserInfo selectUserById(Long userId) {
        try {
            if (userId > 0)
                return this.userInfoMapper.selectByPrimaryKey(userId);
            LOG.error("userId is less than 0");
        } catch (Exception e) {
            LOG.error("selectUserById error : {}", e.getMessage());
        }
        return null;
    }

    @Override
    public int updateByIdSelective(UserInfo userInfo) {
        try {
            if (userInfo != null || userInfo.getUserId() <= 0)
                return this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
            LOG.error("userInfo can not null or userId less than 0");
        } catch (Exception e) {
            LOG.error("updateByIdSelective error : {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public int updateById(UserInfo userInfo) {
        try {
            if (userInfo != null || userInfo.getUserId() <= 0)
                return this.userInfoMapper.updateByPrimaryKey(userInfo);
            LOG.error("userInfo can not null or userId less than 0");
        } catch (Exception e) {
            LOG.error("updateByIdSelective error : {}", e.getMessage());
        }
        return 0;
    }
}
