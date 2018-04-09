package com.xxz.service;

import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SpringBootService {
	
	List<userInformation> queryAll();

	UserInfo selectByPrimaryKey(Long userId);

	void save(UserInfo ui);
}
