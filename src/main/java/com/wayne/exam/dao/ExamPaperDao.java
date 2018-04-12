package com.wayne.exam.dao;

import com.wayne.exam.entity.ExamPaper;

public interface ExamPaperDao {

	/**
	 * 新增考卷信息
	 * @param exampaper
	 * @return int
	 * @author wayne
	 * @date 2018年4月8日下午8:26:46
	 */
	int insertExamPaper(ExamPaper examPaper);
	
	/**
	 * 更新考卷信息
	 * @param examPaper
	 * @return int
	 * @author wayne
	 * @date 2018年4月8日下午10:37:42
	 */
	int updateExamPaper(ExamPaper examPaper);
	
}
