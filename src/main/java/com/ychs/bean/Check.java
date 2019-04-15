package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 判断题类
 * @author 李少石
 * @version 2018-03-10
 */
@Component
public class Check {
	
	/**
	 * 判断题id
	 */
	private String check_id;
	
	/**
	 * 出题老师id
	 */
	private String teacher_id;
	
	/**
	 * 出题老师name
	 */
	private String teacher_name;
	
	/**
	 * 判断题问题
	 */
	private String check_question;
	
	
	/**
	 * 判断题答案
	 */
	private String check_answer;
	
	/**
	 * 判断题题目阶段
	 */
	private String check_stage;
	
	/**
	 * 判断题、学生做题次数
	 */
	private String check_useNum;
	
	/**
	 * 判断题、学生答对次数
	 */
	private String check_rightNum;
	
	/**
	 * 判断题、正确率
	 */
	private String check_accuracy;

	/**
	 * 无参构造方法
	 */
	public Check() {
		super();
	}

	public Check(String check_id, String teacher_id, String teacher_name, String check_question, String check_answer,
			String check_stage, String check_useNum, String check_rightNum, String check_accuracy) {
		super();
		this.check_id = check_id;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.check_question = check_question;
		this.check_answer = check_answer;
		this.check_stage = check_stage;
		this.check_useNum = check_useNum;
		this.check_rightNum = check_rightNum;
		this.check_accuracy = check_accuracy;
	}

	public String getCheck_id() {
		return check_id;
	}

	public void setCheck_id(String check_id) {
		this.check_id = check_id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getCheck_question() {
		return check_question;
	}

	public void setCheck_question(String check_question) {
		this.check_question = check_question;
	}

	public String getCheck_answer() {
		return check_answer;
	}

	public void setCheck_answer(String check_answer) {
		this.check_answer = check_answer;
	}

	public String getCheck_stage() {
		return check_stage;
	}

	public void setCheck_stage(String check_stage) {
		this.check_stage = check_stage;
	}

	public String getCheck_useNum() {
		return check_useNum;
	}

	public void setCheck_useNum(String check_useNum) {
		this.check_useNum = check_useNum;
	}

	public String getCheck_rightNum() {
		return check_rightNum;
	}

	public void setCheck_rightNum(String check_rightNum) {
		this.check_rightNum = check_rightNum;
	}

	public String getCheck_accuracy() {
		return check_accuracy;
	}

	public void setCheck_accuracy(String check_accuracy) {
		this.check_accuracy = check_accuracy;
	}

	@Override
	public String toString() {
		return "Check [check_id=" + check_id + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name
				+ ", check_question=" + check_question + ", check_answer=" + check_answer + ", check_stage="
				+ check_stage + ", check_useNum=" + check_useNum + ", check_rightNum=" + check_rightNum
				+ ", check_accuracy=" + check_accuracy + "]";
	}

	
}
