package com.wayne.exam.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wayne.exam.entity.UserInfo;
import com.wayne.exam.service.UserInfoService;
import com.wayne.exam.util.HttpServletRequestUtil;
import com.wayne.exam.util.MD5Util;

@Controller
@RequestMapping("/Login")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> loginCheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		if (userName != null && password != null) {
			password = MD5Util.getMd5(password);
			UserInfo user = userInfoService.getUserInfoByNameAndPwd(userName, password);
			if (user != null) {
				Integer role = user.getUserRole();
				if (role == 1) {
					modelMap.put("success", true);
					// modelMap.put("role", "admin");
					request.getSession().setAttribute("user", user);
				} else if (role == 2) {
					modelMap.put("success", true);
					// modelMap.put("role", "teacher");
				} else if (role == 3) {
					modelMap.put("success", true);
					// modelMap.put("role", "normal user");
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

}
