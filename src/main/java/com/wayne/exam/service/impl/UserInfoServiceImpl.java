package com.wayne.exam.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wayne.exam.dao.UserInfoDao;
import com.wayne.exam.entity.UserInfo;
import com.wayne.exam.service.UserInfoService;
import com.wayne.exam.util.MD5Util;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	/*
	 * @Override
	 * 
	 * @Transactional public UserInfoExecution addUserInfo(UserInfo userInfo) { if
	 * (userInfo == null) { return new UserInfoExecution(UserInfoStateEnum.EMPTY); }
	 * else { try { int effectedNum = userInfoDao.insertUserInfo(userInfo); if
	 * (effectedNum <= 0) { return new
	 * UserInfoExecution(UserInfoStateEnum.INNER_ERROR); } else {// 创建成功 // userInfo
	 * = userInfoDao.queryUserInfoById(userInfo.getUserId()); return new
	 * UserInfoExecution(UserInfoStateEnum.SUCCESS, userInfo); } } catch (Exception
	 * e) { throw new RuntimeException("addUserInfo error: " + e.getMessage()); } }
	 * }
	 */

	@Override
	public UserInfo getUserInfoByNameAndPwd(String userName, String password) {
		return userInfoDao.queryUserInfoByNameAndPwd(userName, password);
	}

	@Override
	@Transactional
	public String register(UserInfo userInfo) throws RuntimeException {
		int num = userInfoDao.queryUserInfoByName(userInfo.getUserName());
		if (num == 0) {
			try {
				userInfo.setCreateTime(new Date());
				userInfo.setPassword(MD5Util.getMd5(userInfo.getPassword()));
				try {
					int effectedNum = userInfoDao.insertUserInfo(userInfo);
					if (effectedNum <= 0) {
						throw new RuntimeException("账号创建失败");
					} else {
						return "用户创建成功";
					}
				} catch (Exception e) {
					throw new RuntimeException("insertUserInfo error: " + e.getMessage());
				}
			} catch (Exception e) {
				throw new RuntimeException("register error: " + e.getMessage());
			}
		} else {
			return "用户已存在";
		}

	}

	@Override
	public UserInfo getUserInfoById(Long userId) {
		return userInfoDao.queryUserInfoById(userId);
	}

}
