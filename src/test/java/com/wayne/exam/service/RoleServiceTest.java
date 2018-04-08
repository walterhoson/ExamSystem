package com.wayne.exam.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wayne.exam.BaseTest;
import com.wayne.exam.dao.RoleDao;
import com.wayne.exam.entity.Role;

public class RoleServiceTest extends BaseTest{
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testGetRoleList() {
		List<Role> roleList = roleService.getRoleList();
		assertEquals("admin",roleList.get(0).getCode());
	}
	
	

}
