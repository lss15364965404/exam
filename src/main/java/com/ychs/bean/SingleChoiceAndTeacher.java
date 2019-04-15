package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 单选题的查询结果bean
 * @author FENG
 *
 */
@Component
public class SingleChoiceAndTeacher {
	/**
	 * 出题老师的名字
	 */
	private String teacher_name;
	
	/**
	 * 出题老师id
	 */
	private String teacher_id;
	/**
	 * 单选题ID
	 */
	private String singleChoice_id;
	/**
	 * 单选题题目
	 */
	private String singleChoice_question;
	
	/**
	 * 单选题答案选项ID
	 */
	private String singleChoiceAnswer_id;
	
	/**
	 * 单选题正确答案选项ID
	 */
	private String singleChoice_choice;
	
	/**
	 * 题目阶段
	 */
	private String singleChoice_stage;
	
	/**
	 * 学生做题次数
	 */
	private String singleChoice_useNum;
	
	/**
	 * 学生答对次数
	 */
	private String singleChoice_rightNum;
	
	/**
	 * 题目正确率
	 */
	private String singleChoice_accuracy;
	

	public SingleChoiceAndTeacher() {
		super();
	}

	public SingleChoiceAndTeacher(String teacher_name, String teacher_id, String singleChoice_id,
			String singleChoice_question, String singleChoiceAnswer_id, String singleChoice_choice,
			String singleChoice_stage, String singleChoice_useNum, String singleChoice_rightNum,
			String singleChoice_accuracy) {
		super();
		this.teacher_name = teacher_name;
		this.teacher_id = teacher_id;
		this.singleChoice_id = singleChoice_id;
		this.singleChoice_question = singleChoice_question;
		this.singleChoiceAnswer_id = singleChoiceAnswer_id;
		this.singleChoice_choice = singleChoice_choice;
		this.singleChoice_stage = singleChoice_stage;
		this.singleChoice_useNum = singleChoice_useNum;
		this.singleChoice_rightNum = singleChoice_rightNum;
		this.singleChoice_accuracy = singleChoice_accuracy;
	}

	public String getSingleChoice_choice() {
		return singleChoice_choice;
	}

	public void setSingleChoice_choice(String singleChoice_choice) {
		this.singleChoice_choice = singleChoice_choice;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getSingleChoice_question() {
		return singleChoice_question;
	}

	public void setSingleChoice_question(String singleChoice_question) {
		this.singleChoice_question = singleChoice_question;
	}

	public String getSingleChoiceAnswer_id() {
		return singleChoiceAnswer_id;
	}

	public void setSingleChoiceAnswer_id(String singleChoiceAnswer_id) {
		this.singleChoiceAnswer_id = singleChoiceAnswer_id;
	}

	public String getSingleChoice_stage() {
		return singleChoice_stage;
	}

	public void setSingleChoice_stage(String singleChoice_stage) {
		this.singleChoice_stage = singleChoice_stage;
	}

	public String getSingleChoice_useNum() {
		return singleChoice_useNum;
	}

	public void setSingleChoice_useNum(String singleChoice_useNum) {
		this.singleChoice_useNum = singleChoice_useNum;
	}

	public String getSingleChoice_rightNum() {
		return singleChoice_rightNum;
	}

	public void setSingleChoice_rightNum(String singleChoice_rightNum) {
		this.singleChoice_rightNum = singleChoice_rightNum;
	}

	public String getSingleChoice_accuracy() {
		return singleChoice_accuracy;
	}

	public void setSingleChoice_accuracy(String singleChoice_accuracy) {
		this.singleChoice_accuracy = singleChoice_accuracy;
	}

	
	public String getSingleChoice_id() {
		return singleChoice_id;
	}

	public void setSingleChoice_id(String singleChoice_id) {
		this.singleChoice_id = singleChoice_id;
	}


	@Override
	public String toString() {
		return "SingleChoiceAndTeacher [teacher_name=" + teacher_name + ", teacher_id=" + teacher_id + ", singleChoice_id="
				+ singleChoice_id + ", singleChoice_question=" + singleChoice_question + ", singleChoiceAnswer_id="
				+ singleChoiceAnswer_id + ", singleChoice_stage=" + singleChoice_stage + ", singleChoice_useNum="
				+ singleChoice_useNum + ", singleChoice_rightNum=" + singleChoice_rightNum + ", singleChoice_accuracy="
				+ singleChoice_accuracy + "]";
	}

	
	
}
