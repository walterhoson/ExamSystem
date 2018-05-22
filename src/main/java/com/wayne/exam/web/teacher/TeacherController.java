package com.wayne.exam.web.teacher;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wayne.exam.entity.UserInfo;
import com.wayne.exam.service.UserInfoService;
import com.wayne.exam.util.HttpServletRequestUtil;
import com.wayne.exam.util.MD5Util;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
	Logger logger = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/login")
	public String index() {
		return "login-teacher";
	}

	@RequestMapping("/regist")
	public String regist() {
		return "register-teacher";
	}

	@RequestMapping("/forgot")
	public String forgot() {
		return "forgot-teacher";
	}

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	private String loginCheck(HttpServletRequest request) {
		logger.info("----start loginCheck---- ");
		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		logger.debug("userName:" + userName + "password:" + password);
		password = MD5Util.getMd5(password);
		UserInfo user = userInfoService.getUserInfoByNameAndPwd(userName, password);
		if (user != null) {
			Integer role = user.getUserRole();
			// if (role == 1) {
			// modelMap.put("success", true);
			// // modelMap.put("role", "admin");
			// request.getSession().setAttribute("user", user);
			// } else if (role == 2) {
			// modelMap.put("success", true);
			// // modelMap.put("role", "teacher");
			// } else if (role == 3) {
			// modelMap.put("success", true);
			// HttpSession session = request.getSession();
			// session.setAttribute("userId", user.getUserId());
			// // modelMap.put("role", "normal user");
			// }
			if (role == 2) {
				return "redirect:/question/index";
			} else {
				return "redirect:error";
			}
		} else {
			return "redirect:error";
		}
	}

	/*
	 * @RequestMapping(value = "register", method = RequestMethod.POST)
	 * 
	 * @ResponseBody
	 */
	/*
	 * public Map<String, Object> registerUser(HttpServletRequest request) {
	 * logger.info("----registerUser----"); Map<String, Object> modelMap = new
	 * HashMap<String, Object>(); UserInfo userInfo = null; ObjectMapper mapper =
	 * new ObjectMapper(); String userInfoStr =
	 * HttpServletRequestUtil.getString(request, "userInfoStr");
	 * logger.debug("userInfoStr:" + userInfoStr); try { userInfo =
	 * mapper.readValue(userInfoStr, UserInfo.class); } catch (Exception e) {
	 * modelMap.put("success", false); modelMap.put("errMsg", e.toString()); return
	 * modelMap; } if (userInfo != null && userInfo.getPassword() != null &&
	 * userInfo.getUserName() != null) { try { UserInfoExecution result =
	 * userInfoService.register(userInfo); if (result.getState() ==
	 * UserInfoStateEnum.SUCCESS.getState()) { modelMap.put("success", true); } else
	 * { modelMap.put("success", true); modelMap.put("errMsg",
	 * result.getStateInfo()); } } catch (RuntimeException e) {
	 * modelMap.put("success", false); modelMap.put("errMsg", e.toString()); return
	 * modelMap; } } else { modelMap.put("success", false); modelMap.put("errMsg",
	 * UserInfoStateEnum.NULL_AUTH_INFO); } return modelMap; }
	 */

	/**
	 * 注册教师账户
	 * 
	 * @param request
	 * @return String
	 * @author wayne
	 * @date 2018年4月30日上午10:51:29
	 */
	@RequestMapping(value = "register_teacher", method = RequestMethod.POST)
	public String registerTeacher(HttpServletRequest request) {
		logger.info("----registerTeacher----");
		UserInfo userInfo = new UserInfo();
		String trueName = HttpServletRequestUtil.getString(request, "trueName");
		String email = HttpServletRequestUtil.getString(request, "email");
		String tel = HttpServletRequestUtil.getString(request, "tel");
		String password = HttpServletRequestUtil.getString(request, "password");
		logger.debug("userInfoStr:" + trueName + email + tel + password);
		try {
			userInfo.setUserName(trueName);
			userInfo.setEmail(email);
			userInfo.setPassword(password);
			userInfo.setPhoneNum(tel);
			// 老师权限为2
			userInfo.setUserRole(2);
			String result = userInfoService.register(userInfo);
			if ("用户创建成功".equals(result)) {
				return "redirect:login";
			} else {
				return result;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
