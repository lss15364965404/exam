package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * SingleChoice类	单选题表
 * @author 李少石
 * @version 2017-11-29
 */
@Component
public class SingleChoice {
	
	/**
	 * 单选题ID
	 */
	private String singleChoice_id;
	
	/**
	 * 出题老师id
	 */
	private String teacher_id;
	/**
	 * 单选题题目
	 */
	private String singleChoice_question;
	
	/**
	 * 单选题答案选项ID
	 */
	private String singleChoiceAnswer_id;
	
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
	
	/**
	 * 无参数构造函数
	 */
	public SingleChoice() {
		super();
	}
	
	/**
	 * 有参构造方法
	 * @param singleChoice_id 单选题id
	 * @param teacher_id 出题老师id
	 * @param singleChoice_question 单选题问题
	 * @param singleChoiceAnswer_id 单选题答案id
	 * @param singleChoice_stage 阶段
	 * @param singleChoice_useNum 使用次数
	 * @param singleChoice_rightNum 正确次数
	 * @param singleChoice_accuracy 正确率
	 */
	public SingleChoice(String singleChoice_id, String teacher_id, String singleChoice_question,
			String singleChoiceAnswer_id, String singleChoice_stage, String singleChoice_useNum,
			String singleChoice_rightNum, String singleChoice_accuracy) {
		super();
		this.singleChoice_id = singleChoice_id;
		this.teacher_id = teacher_id;
		this.singleChoice_question = singleChoice_question;
		this.singleChoiceAnswer_id = singleChoiceAnswer_id;
		this.singleChoice_stage = singleChoice_stage;
		this.singleChoice_useNum = singleChoice_useNum;
		this.singleChoice_rightNum = singleChoice_rightNum;
		this.singleChoice_accuracy = singleChoice_accuracy;
	}
	
	/**
	 * 得到单选题id
	 * @return
	 */
	public String getSingleChoice_id() {
		return singleChoice_id;
	}

	/**
	 * 设置单选题id
	 * @param singleChoice_id
	 */
	public void setSingleChoice_id(String singleChoice_id) {
		this.singleChoice_id = singleChoice_id;
	}

	/**
	 * 得到出题老师id
	 * @return
	 */
	public String getTeacher_id() {
		return teacher_id;
	}

	/**
	 * 设置出出题老师id
	 * @param teacher_id
	 */
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	/**
	 * 得到单选题问题
	 * @return
	 */
	public String getSingleChoice_question() {
		return singleChoice_question;
	}

	/**
	 * 设置单选题答案
	 * @param singleChoice_question
	 */
	public void setSingleChoice_question(String singleChoice_question) {
		this.singleChoice_question = singleChoice_question;
	}

	/**
	 * 得到单选题答案id
	 * @return
	 */
	public String getSingleChoiceAnswer_id() {
		return singleChoiceAnswer_id;
	}

	/**
	 * 设置单选题答案id
	 * @param singleChoiceAnswer_id
	 */
	public void setSingleChoiceAnswer_id(String singleChoiceAnswer_id) {
		this.singleChoiceAnswer_id = singleChoiceAnswer_id;
	}

	/**
	 * 得到单选题阶段
	 * @return
	 */
	public String getSingleChoice_stage() {
		return singleChoice_stage;
	}

	/**
	 * 设置单选题阶段
	 * @param singleChoice_stage
	 */
	public void setSingleChoice_stage(String singleChoice_stage) {
		this.singleChoice_stage = singleChoice_stage;
	}

	/**
	 * 得到单选题使用次数
	 * @return
	 */
	public String getSingleChoice_useNum() {
		return singleChoice_useNum;
	}

	/**
	 * 设置单选题使用次数
	 * @param singleChoice_useNum
	 */
	public void setSingleChoice_useNum(String singleChoice_useNum) {
		this.singleChoice_useNum = singleChoice_useNum;
	}

	/**
	 * 得到单选题正确次数
	 * @return
	 */
	public String getSingleChoice_rightNum() {
		return singleChoice_rightNum;
	}

	/**
	 * 设置单选题正确次数
	 * @param singleChoice_rightNum
	 */
	public void setSingleChoice_rightNum(String singleChoice_rightNum) {
		this.singleChoice_rightNum = singleChoice_rightNum;
	}

	/**
	 * 得到单选题正确率
	 * @return
	 */
	public String getSingleChoice_accuracy() {
		return singleChoice_accuracy;
	}

	/**
	 * 设置单选题正确率
	 * @param singleChoice_accuracy
	 */
	public void setSingleChoice_accuracy(String singleChoice_accuracy) {
		this.singleChoice_accuracy = singleChoice_accuracy;
	}

	/**
	 * 转化为字符串
	 */
	@Override
	public String toString() {
		return "SingleChoice [singleChoice_id=" + singleChoice_id + ", teacher_id=" + teacher_id
				+ ", singleChoice_question=" + singleChoice_question + ", singleChoiceAnswer_id="
				+ singleChoiceAnswer_id + ", singleChoice_stage=" + singleChoice_stage + ", singleChoice_useNum="
				+ singleChoice_useNum + ", singleChoice_rightNum=" + singleChoice_rightNum + ", singleChoice_accuracy="
				+ singleChoice_accuracy + "]";
	}

	
	
	
	
	
	
}
