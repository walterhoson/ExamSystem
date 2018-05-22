package com.wayne.exam.enums;

/**
 * 使用枚举表述常量数据字典
 * 
 * @author wayne
 * @time 2018年4月12日 下午7:48:49
 */
public enum UserInfoStateEnum {

	// SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(-1002, "用户信息为空");
	LOGINFAIL(-1, "密码或帐号输入有误"), SUCCESS(0, "操作成功"), NULL_AUTH_INFO(-1006, "注册信息为空"), ONLY_ONE_ACCOUNT(-1007,
			"最多只能绑定一个本地帐号"), ISEXIST(-1008, "用户名已经存在"),NOTEXIST(-1009,"用户不存在");

	private int state;

	private String stateInfo;

	private UserInfoStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static UserInfoStateEnum stateOf(int index) {
		for (UserInfoStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}