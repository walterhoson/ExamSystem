package com.wayne.exam.service.impl;

import java.util.Date;
import java.util.List;

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
public class QuestionServiceImpl implements QuestionService{
	
	Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);
	
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	@Transactional
	public List<Question> insertQuestion(String name, MultipartFile mFile, String localFile) {
		logger.info("---start insertQuestionService---");
		UpLoadExcelUtil upLoadExcelUtil = new UpLoadExcelUtil();
		List<Question> excelList = upLoadExcelUtil.getExcelInfo(name, mFile, localFile);
		for(Question question : excelList) {
			question.setCreator("admin");
			question.setCreateTime(new Date());
			question.setLastModify(new Date());
			questionDao.insertQuestion(question);
		}
		logger.info("---end insertQuestionService---");
		return excelList;
	}


}
