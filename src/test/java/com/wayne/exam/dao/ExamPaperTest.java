package com.wayne.exam.dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wayne.exam.BaseTest;
import com.wayne.exam.entity.ExamPaper;

public class ExamPaperTest extends BaseTest{
	@Autowired
	private ExamPaperDao examPaperDao;

	@Test
	@Ignore
	public void testInsertExamPaper() {
		ExamPaper examPaper = new ExamPaper();
		examPaper.setPaperName("test1");
		examPaper.setUserId(1);
		examPaper.setQuestionId(2);
		examPaper.setWrongAnswers("A,B,C,D");
		examPaper.setAnswers("A,B,C,D");
/*		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 1, 1); // 年月日 也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
		Date date = calendar.getTime();// date就是你需要的时间
*/		examPaper.setCheckoutTime(new Date());
		examPaper.setScore(100);
		examPaper.setIsLocked(0);
		int effectedNum = examPaperDao.insertExamPaper(examPaper);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testUpdateExamPaper() {
		ExamPaper examPaper = new ExamPaper();
		examPaper.setId(3);
		examPaper.setPaperName("test3");
		examPaper.setUserId(1);
		examPaper.setQuestionId(2);
		examPaper.setCheckoutTime(new Date());
		examPaper.setScore(100);
		examPaper.setIsLocked(1);
		int effectedNum = examPaperDao.updateExamPaper(examPaper);
		assertEquals(1,effectedNum);
		
		System.out.println("effectedNum:"+effectedNum);
	}
	
	
	
}
