package com.wayne.exam.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wayne.exam.BaseTest;
import com.wayne.exam.entity.Role;

public class RoleDaoTest extends BaseTest{
	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void testQueryRole() {
		List<Role> roleList = roleDao.queryRole();
		assertEquals(3,roleList.size());
	}

}
