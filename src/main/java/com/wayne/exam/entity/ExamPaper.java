package com.wayne.exam.entity;

import java.util.Date;

public class ExamPaper {
	
	private Integer id;
	private String paperName;
	private Integer userId;
	private Integer questionId;
	private String userAnswers;
	private String answers;
	private Date checkoutTime;
	private Integer score;
	private Integer isLocked;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(String userAnswers) {
		this.userAnswers = userAnswers;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public Date getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}
	

}
