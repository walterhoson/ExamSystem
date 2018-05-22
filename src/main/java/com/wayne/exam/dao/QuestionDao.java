package com.wayne.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wayne.exam.entity.Question;

public interface QuestionDao {

	/**
	 * 插入选择题题库
	 * 
	 * @param questionChoice
	 * @return int
	 * @author wayne
	 * @date 2018年4月9日下午4:41:54
	 */
	// int insertQuestionChoice(QuestionChoice questionChoice);

	/**
	 * 插入判断和填空题题库
	 * 
	 * @param questionJudgeAndFillin
	 * @return int
	 * @author wayne
	 * @date 2018年4月9日下午4:43:42
	 */
	// int insertQuestionJudgeAndFillin(QuestionJudgeAndFillin
	// questionJudgeAndFillin);

	/**
	 * 插入题库
	 * 
	 * @param question
	 * @return int
	 * @author wayne
	 * @date 2018年4月10日下午1:41:12
	 */
	int insertQuestion(Question question);

	/**
	 * 通过标题找到对应的考卷的年份
	 * 
	 * @param title
	 * @return List<String>
	 * @author wayne
	 * @date 2018年4月16日上午11:47:05
	 */
	List<Integer> queryQuestionYearByTitle(@Param(value = "title") String title);

	/**
	 * 通过标题和年份查询出当前所选测试卷中所有的题目
	 * 
	 * @param title
	 * @param year
	 * @return List<String>
	 * @author wayne
	 * @date 2018年4月17日上午11:23:12
	 */
	List<Question> queryQuestion(@Param(value = "title") String title, @Param(value = "year") Integer year,
			@Param(value = "type") Integer type);

}
