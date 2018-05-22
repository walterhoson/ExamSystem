package com.wayne.exam.dao;

import org.apache.ibatis.annotations.Param;

import com.wayne.exam.entity.UserInfo;

public interface UserInfoDao {
	
	/**
	 * 插入用户信息
	 * @param userInfo
	 * @return int
	 * @author wayne
	 * @date 2018年4月12日下午10:35:55
	 */
	int insertUserInfo(UserInfo userInfo);
	
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return UserInfo
	 * @author wayne
	 * @date 2018年4月12日下午11:19:43
	 */
	UserInfo queryUserInfoById(Long id);
	
	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return int
	 * @author wayne
	 * @date 2018年4月14日下午2:02:23
	 */
	int queryUserInfoByName(@Param(value="userName") String userName);
	
	/**
	 * 通过用户名和密码验证登陆用户
	 * @param userName
	 * @param password
	 * @return UserInfo
	 * @author wayne
	 * @date 2018年4月13日上午12:11:17
	 */
	UserInfo queryUserInfoByNameAndPwd(@Param(value="userName") String userName, @Param(value="password") String password);
	
	

}
