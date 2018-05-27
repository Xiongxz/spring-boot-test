package com.xxz.service;

import com.xxz.dao.SpringDataDao;
import com.xxz.mapper.UserInfoMapper;
import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpringBootServiceImpl implements SpringBootService {

    @Autowired
    private SpringDataDao sdd;

    @Autowired
    private UserInfoMapper uim;

    @Override
    public List<userInformation> queryAll() {
        return sdd.findAll();
    }

    @Override
    public UserInfo selectByPrimaryKey(Long userId) {
        return uim.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserInfo ui) {
        uim.insert(ui);
    }

}
