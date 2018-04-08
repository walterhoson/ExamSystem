package com.wayne.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wayne.exam.dao.RoleDao;
import com.wayne.exam.entity.Role;
import com.wayne.exam.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getRoleList() {
		return roleDao.queryRole();
	}

}
