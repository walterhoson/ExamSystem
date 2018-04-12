package com.wayne.exam.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wayne.exam.entity.Question;

public interface QuestionService {

	/**
	 * 插入题库
	 * @param name
	 * @param file
	 * @param localfile
	 * @return List<Question>
	 * @author wayne
	 * @date 2018年4月9日下午11:10:18
	 */
	List<Question> insertQuestion(String name, MultipartFile file, String localfile);

}
