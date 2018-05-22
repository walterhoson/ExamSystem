package com.wayne.exam.web.examing;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Exam")
public class ExamingController {

	Logger logger = LoggerFactory.getLogger(ExamingController.class);
	
	
	/**每做一题，保存一次数据库，
	 * 用户点击进入对应的试卷时，如：点击计算机二级真题（2015），
	 * 在es_exam_paper中保存对应paperName(试卷名),userId,question_id,answer,is_locked(是否锁定，未完成=0，完成=1)
	 * 答第一题时，将答案存入user_answer字段，
	**/
	@RequestMapping(value = "/listExam", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> Examing(HttpServletRequest request) {
		
		
		
		
		
		
		return null;
		
	}
	
	

}
