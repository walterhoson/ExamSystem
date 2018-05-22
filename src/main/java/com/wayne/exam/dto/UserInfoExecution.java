package com.wayne.exam.dto;

import java.util.List;

import com.wayne.exam.entity.UserInfo;
import com.wayne.exam.enums.UserInfoStateEnum;

/**
 * 封装执行后的结果
 * 
 * @author wayne
 * @time 2018年4月12日 下午7:48:33
 */
public class UserInfoExecution {

	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 操作的userInfo
	private UserInfo userInfo;
	
	// 获取的userInfo列表
	private List<UserInfo> userInfoList;
	

	public UserInfoExecution() {
	}

	//失败后的构造器
	public UserInfoExecution(UserInfoStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	//成功后的构造器
	public UserInfoExecution(UserInfoStateEnum stateEnum, UserInfo userInfo) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userInfo = userInfo;
	}
	
	// 成功后的构造器
	public UserInfoExecution(UserInfoStateEnum stateEnum,
			List<UserInfo> userInfoList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userInfoList = userInfoList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	
	

}
