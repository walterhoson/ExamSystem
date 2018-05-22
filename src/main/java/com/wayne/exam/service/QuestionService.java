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
	 * @return int 成功插入题库数量
	 * @author wayne
	 * @date 2018年4月9日下午11:10:18
	 */
	int insertQuestion(String name, MultipartFile file, String localfile);
	
	
	/**
	 * 用户输入对应考试大类名称，如：计算机二级，列出对应考试所有考卷的名称+年份  计算机二级（2017）
	 * @param first
	 * @param second
	 * @return List<Object>
	 * @author wayne
	 * @date 2018年4月16日上午11:48:53
	 */
	List<Object> selectQuestionTitle(int first,int second);
	
	
	/**
	 * 查询对应年份的对应考卷的题目
	 * @param title
	 * @param year
	 * @return List<Question>
	 * @author wayne
	 * @date 2018年4月17日下午1:06:26
	 */
	List<Question> selectSingleSelection(String title,Integer year);

}
