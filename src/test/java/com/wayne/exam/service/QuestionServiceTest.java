package com.wayne.exam.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wayne.exam.BaseTest;
import com.wayne.exam.entity.Question;

public class QuestionServiceTest extends BaseTest {

	@Autowired
	private QuestionService questionService;
	
	@Test
	@Ignore
	public void testSelectQuestion() {
		List<Object> list = questionService.selectQuestionTitle(1,1);
		System.out.println("list:"+list);
	}
	
	@Test
	public void testselectSingleSelection() {
		List<Question> list = questionService.selectSingleSelection("计算机二级真题",2015);
		System.out.println("list:"+list);
	}
}
