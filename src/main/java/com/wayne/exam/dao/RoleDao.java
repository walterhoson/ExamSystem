package com.wayne.exam.dao;

import java.util.List;

import com.wayne.exam.entity.Role;

public interface RoleDao {
	/**
	 * 列出权限列表
	 * @return List<Role>
	 * @author wayne
	 * @date 2018年4月7日上午10:43:09
	 */
	List<Role> queryRole();

}	