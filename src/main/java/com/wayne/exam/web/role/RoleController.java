package com.wayne.exam.web.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wayne.exam.entity.Role;
import com.wayne.exam.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/listrole", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listRole() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Role> list = new ArrayList<Role>();
		try {
			list = roleService.getRoleList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}

}
