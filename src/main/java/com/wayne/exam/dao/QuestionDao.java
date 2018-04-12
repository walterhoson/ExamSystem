package com.wayne.exam.dao;

import com.wayne.exam.entity.Question;

public interface QuestionDao {
	
	/**
	 * 插入选择题题库
	 * @param questionChoice
	 * @return int
	 * @author wayne
	 * @date 2018年4月9日下午4:41:54
	 */
	//int insertQuestionChoice(QuestionChoice questionChoice);
	
	/**
	 * 插入判断和填空题题库
	 * @param questionJudgeAndFillin
	 * @return int
	 * @author wayne
	 * @date 2018年4月9日下午4:43:42
	 */
	//int insertQuestionJudgeAndFillin(QuestionJudgeAndFillin questionJudgeAndFillin);
	
	/**
	 * 插入题库
	 * @param question
	 * @return int
	 * @author wayne
	 * @date 2018年4月10日下午1:41:12
	 */
	int insertQuestion(Question question);
	

}
