package com.wayne.exam.service;

import com.wayne.exam.entity.UserInfo;

public interface UserInfoService {
	
	/**
	 * 新增用户
	 * @param user
	 * @return int
	 * @author wayne
	 * @date 2018年4月12日下午7:37:12
	 */
	//UserInfoExecution addUserInfo(UserInfo userInfo);
	
	/**
	 * 注册
	 * @param userInfo
	 * @return String
	 * @throws RuntimeException 
	 * @author wayne
	 * @date 2018年4月13日下午10:43:58
	 */
	String register(UserInfo userInfo) throws RuntimeException;
	
	
	/**
	 * 通过传入用户名和密码验证用户登录
	 * @param userName
	 * @param pwd
	 * @return UserInfo
	 * @author wayne
	 * @date 2018年4月13日上午12:31:28
	 */
	UserInfo getUserInfoByNameAndPwd(String userName,String password);
	
	
	/**
	 * 通过userId查询用户信息
	 * @param userId
	 * @return UserInfo
	 * @author wayne
	 * @date 2018年4月14日下午6:55:31
	 */
	UserInfo getUserInfoById(Long userId);
	
	
	
	
	

}
