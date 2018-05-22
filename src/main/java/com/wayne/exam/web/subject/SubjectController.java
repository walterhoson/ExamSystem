package com.wayne.exam.web.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wayne.exam.service.QuestionService;
import com.wayne.exam.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/Subject")
public class SubjectController {

	Logger logger = LoggerFactory.getLogger(SubjectController.class);

	@Autowired
	private QuestionService questionService;

	/*
	 * chooseNumOne:  1=>考级   
	 * chooseNumTwo:  0=>计算机二级    1=>程序员    2=>软件设计师
	 * chooseNumOne:  2=>学科
	 * chooseNumTwo:  0=>JAVA程序设计    1=>数据结构    2=>数据库原理与应用
	 * 前端发送url:XXX/listSubject/chooseNumOne=1&chooseNumTwo=2 ,返回json格式的考卷名称
	 */
	@RequestMapping(value = "/listSubject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listSubject(HttpServletRequest request) {
		logger.info("----start listSubject----");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Object> subjectList = new ArrayList<Object>();
		int chooseNumOne = HttpServletRequestUtil.getInt(request, "chooseNumOne");
		int chooseNumTwo = HttpServletRequestUtil.getInt(request, "chooseNumTwo");
		logger.debug("chooseNumOne:" + chooseNumOne + ", chooseNumTwo" + chooseNumTwo);
		try {
			subjectList = questionService.selectQuestionTitle(chooseNumOne, chooseNumTwo);
			modelMap.put("rows", subjectList);
			modelMap.put("total", subjectList.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.debug("modelMap:" + modelMap);
		return modelMap;
	}
	
	
	
	/*@RequestMapping(value = "/listSubject1", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listSubject1(HttpServletRequest request) {
		logger.info("----start listSubject----");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Object> subjectList = new ArrayList<Object>();
		String title = HttpServletRequestUtil.getString(request, "title");
		logger.debug("title:" + title);
		try {
			subjectList = questionService.selectQuestionTitle(title);
			modelMap.put("rows", subjectList);
			modelMap.put("total", subjectList.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.debug("modelMap:" + modelMap);
		return modelMap;
	}*/

}
