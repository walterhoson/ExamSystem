package com.wayne.exam.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wayne.exam.dao.QuestionDao;
import com.wayne.exam.entity.Question;
import com.wayne.exam.service.QuestionService;
import com.wayne.exam.util.UpLoadExcelUtil;

@Service
public class QuestionServiceImpl implements QuestionService {

	Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	private QuestionDao questionDao;

	@Override
	@Transactional
	public int insertQuestion(String name, MultipartFile mFile, String localFile) {
		logger.info("---start insertQuestionService---");
		UpLoadExcelUtil upLoadExcelUtil = new UpLoadExcelUtil();
		List<Question> excelList = upLoadExcelUtil.getExcelInfo(name, mFile, localFile);
		for (Question question : excelList) {
			question.setCreator("admin");
			question.setCreateTime(new Date());
			question.setLastModify(new Date());
			questionDao.insertQuestion(question);
		}
		logger.info("---end insertQuestionService---");
		return excelList.size();
	}

	@Override
	public List<Object> selectQuestionTitle(int first, int second) {
		String title = "";
		if (first == 0) {// 考级
			if (second == 0) {
				title = "计算机二级真题";
			} else if (second == 1) {
				title = "程序员";
			} else if (second == 2) {
				title = "软件设计师";
			}
		} else if (first == 1) {// 学科
			if (second == 0) {
				title = "JAVA程序设计";
			} else if (second == 1) {
				title = "数据结构";
			} else if (second == 2) {
				title = "数据库原理与应用";
			}
		}
		List<Integer> list = questionDao.queryQuestionYearByTitle(title);
		System.out.println("list1:" + list);
		Collections.sort(list);
		System.out.println("list2:" + list);
		Collections.reverse(list);
		System.out.println("list3:" + list);
		List<Object> subjectList = new ArrayList<Object>();
		for (Integer year : list) {
			Map<String, Object> subjectMap = new HashMap<String, Object>();
			subjectMap.put("year", year);
			subjectMap.put("title", title);
			subjectList.add(subjectMap);
		}
		return subjectList;
	}

	public List<Question> selectSingleSelection(String title, Integer year) {
		// type=1，表示单选
		Integer type = 1;
		List<Question> questionList = questionDao.queryQuestion(title, year, type);
		return questionList;
	}

}
