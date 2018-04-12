package com.wayne.exam.service;

import java.util.List;

import com.wayne.exam.entity.Role;

public interface RoleService {
	
	/**
	 * 获取权限List
	 * @return List<Role>
	 * @author wayne
	 * @date 2018年4月9日下午4:47:22
	 */
	List<Role> getRoleList();

}
