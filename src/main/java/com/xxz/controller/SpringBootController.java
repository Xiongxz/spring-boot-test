package com.xxz.controller;

import java.util.List;

import com.xxz.model.UserInfo;
import com.xxz.model.userInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxz.service.SpringBootService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SpringBootController {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private SpringBootService sbs;

	@RequestMapping(value={"/selectAll"})
	public List<userInformation> springboottests(){
		System.out.println("成功进入！端口号："+port);
		return sbs.queryAll();
	}

	@RequestMapping(value={"/login"})
	public String index(){
		return "/index";
	}

	@RequestMapping(value={"/selectById"})
	public UserInfo selectById(HttpServletRequest request){
		System.out.println("根据ID查询测试sss！端口号："+port+"请求userId:"+request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("id"));
		UserInfo user = this.sbs.selectByPrimaryKey(userId);
		return user;
	}
}
