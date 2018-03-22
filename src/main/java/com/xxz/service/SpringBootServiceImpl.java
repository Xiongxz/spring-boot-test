package com.xxz.service;

import com.xxz.dao.SpringDataDao;
import com.xxz.dao.UserInfoMapper;
import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public UserInfo selectByPrimaryKey(Integer userId) {
		return uim.selectByPrimaryKey(userId);
	}

}
