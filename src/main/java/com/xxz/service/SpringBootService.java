package com.xxz.service;

import java.util.List;

import com.xxz.model.UserInfo;
import org.springframework.stereotype.Service;

import com.xxz.model.userInformation;
@Service
public interface SpringBootService {
	
	List<userInformation> queryAll();

	UserInfo selectByPrimaryKey(Integer userId);
}
