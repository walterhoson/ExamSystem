package com.wayne.exam.entity;

import java.util.Date;

public class QuestionJudgeAndFillin {
	private Integer id;
	private String title;
	private String content;
	private Integer duration;
	private String answer;
	private String examingPoint;
	private String keyword;
	private String reference;
	private Date createTime;
	private String creator;
	private Date lastModify;
	private Integer exposeTimes;
	private Integer rightTimes;
	private Integer wrongTimes;
	private Integer difficulty;
	private String analysis;
	private Integer score;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExamingPoint() {
		return examingPoint;
	}
	public void setExamingPoint(String examingPoint) {
		this.examingPoint = examingPoint;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getLastModify() {
		return lastModify;
	}
	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}
	public Integer getExposeTimes() {
		return exposeTimes;
	}
	public void setExposeTimes(Integer exposeTimes) {
		this.exposeTimes = exposeTimes;
	}
	public Integer getRightTimes() {
		return rightTimes;
	}
	public void setRightTimes(Integer rightTimes) {
		this.rightTimes = rightTimes;
	}
	public Integer getWrongTimes() {
		return wrongTimes;
	}
	public void setWrongTimes(Integer wrongTimes) {
		this.wrongTimes = wrongTimes;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

}
