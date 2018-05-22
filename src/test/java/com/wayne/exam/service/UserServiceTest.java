package com.wayne.exam.service;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wayne.exam.BaseTest;
import com.wayne.exam.dto.UserInfoExecution;
import com.wayne.exam.entity.UserInfo;
import com.wayne.exam.util.MD5Util;

public class UserServiceTest extends BaseTest {

	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void testAddUser() {
		UserInfo userInfo = new UserInfo();
		logger.info("----testAddUser----");
		userInfo.setUserName("test1");
		String pwd = "123456789";
		String MD5Pwd = MD5Util.getMd5(pwd);
		userInfo.setPassword(MD5Pwd);
		userInfo.setUserRole(3);
		userInfo.setSubject("计算机二级真题");
		String result = userInfoService.register(userInfo);
		logger.debug("执行结果：" + result);
	}

	@Test
	@Ignore
	public void testCheckLogin() {
		logger.info("----testCheckLogin----");
		String userName = "test1";
		String pwd = "123456789";
		String MD5Pwd = MD5Util.getMd5(pwd);                      
		logger.debug("MD5Pwd:" + MD5Pwd);
		UserInfo userInfo = userInfoService.getUserInfoByNameAndPwd(userName, MD5Pwd);
		logger.debug(userInfo.toString());
	}


}
