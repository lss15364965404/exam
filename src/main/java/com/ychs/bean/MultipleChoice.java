package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 多选题类
 * @author 齐俐珺
 *
 */
@Component
public class MultipleChoice {

	/**
	 * 多选题id
	 */
	private String multipleChoice_id;
	
	/**
	 * 老师id
	 */
	private String teacher_id;
	/**
	 * 多选题问题
	 */
	private String multipleChoice_question;
	
	/**
	 * 多选题答案id
	 */
	private String multipleChoiceAnswer_ids;
	
	/**
	 * 多选题阶段
	 */
	private String multipleChoice_stage;
	
	/**
	 * 多选题使用次数
	 */
	private String multipleChoice_useNum;
	
	/**
	 * 多选题正确次数
	 */
	private String multipleChoice_rightNum;
	
	/**
	 * 多选题正确率
	 */
	private String multipleChoice_accuracy;
	
	/**
	 * 无参构造方法
	 */
	public MultipleChoice() {
		super();
	}

	/**
	 * 有参数构造方法
	 * @param multipleChoice_id 多选题id
	 * @param multipleChoice_question 多选题问题
	 * @param multipleChoiceAnswer_ids 多选题答案id
	 * @param multipleChoice_stage 多选题阶段
	 * @param multipleChoice_useNum 多选题使用次数
	 * @param multipleChoice_rightNum 多选题正确次数
	 * @param multipleChoice_accuracy 多选题正确率
	 */
	public MultipleChoice(String teacher_id,String multipleChoice_id, String multipleChoice_question, String multipleChoiceAnswer_ids,
			String multipleChoice_stage, String multipleChoice_useNum, String multipleChoice_rightNum,
			String multipleChoice_accuracy) {
		super();
		this.multipleChoice_id = multipleChoice_id;
		this.teacher_id = teacher_id;
		this.multipleChoice_question = multipleChoice_question;
		this.multipleChoiceAnswer_ids = multipleChoiceAnswer_ids;
		this.multipleChoice_stage = multipleChoice_stage;
		this.multipleChoice_useNum = multipleChoice_useNum;
		this.multipleChoice_rightNum = multipleChoice_rightNum;
		this.multipleChoice_accuracy = multipleChoice_accuracy;
	}
	
	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	/**
	 * 得到多选题id
	 * @return 多选题id
	 */
	public String getMultipleChoice_id() {
		return multipleChoice_id;
	}

	/**
	 * 设置多选题id
	 * @param multipleChoice_id 多选题id
	 */
	public void setMultipleChoice_id(String multipleChoice_id) {
		this.multipleChoice_id = multipleChoice_id;
	}

	/**
	 * 得到多选题问题
	 * @return 多选题问题
	 */
	public String getMultipleChoice_question() {
		return multipleChoice_question;
	}

	/**
	 * 设置多选题问题
	 * @param multipleChoice_question 多选题问题
	 */
	public void setMultipleChoice_question(String multipleChoice_question) {
		this.multipleChoice_question = multipleChoice_question;
	}

	/**
	 * 得到多选题答案id
	 * @return 多选题答案id
	 */
	public String getMultipleChoiceAnswer_ids() {
		return multipleChoiceAnswer_ids;
	}

	/**
	 * 设置多选题答案id
	 * @param multipleChoiceAnswer_ids
	 */
	public void setMultipleChoiceAnswer_ids(String multipleChoiceAnswer_ids) {
		this.multipleChoiceAnswer_ids = multipleChoiceAnswer_ids;
	}

	/**
	 * 得到多选题阶段
	 * @return 多选题阶段
	 */
	public String getMultipleChoice_stage() {
		return multipleChoice_stage;
	}

	/**
	 * 设置多选题id
	 * @param multipleChoice_stage 多选题id
	 */
	public void setMultipleChoice_stage(String multipleChoice_stage) {
		this.multipleChoice_stage = multipleChoice_stage;
	}

	/**
	 * 得到学生做题次数
	 * @return
	 */
	public String getMultipleChoice_useNum() {
		return multipleChoice_useNum;
	}
	
	/**
	 * 设置学生做题次数
	 * @param multipleChoice_useNum 学生做题次数
	 */
	public void setMultipleChoice_useNum(String multipleChoice_useNum) {
		this.multipleChoice_useNum = multipleChoice_useNum;
	}

	/**
	 * 得到学生答对次数
	 * @return
	 */
	public String getMultipleChoice_rightNum() {
		return multipleChoice_rightNum;
	}

	/***
	 * 设置学生答对次数
	 * @param multipleChoice_rightNum 学生答对次数
	 */
	public void setMultipleChoice_rightNum(String multipleChoice_rightNum) {
		this.multipleChoice_rightNum = multipleChoice_rightNum;
	}

	/**
	 * 得到题目正确率
	 * @return
	 */
	public String getMultipleChoice_accuracy() {
		return multipleChoice_accuracy;
	}

	/**
	 * 设置题目正确率
	 * @param multipleChoice_accuracy 题目正确率
	 */
	public void setMultipleChoice_accuracy(String multipleChoice_accuracy) {
		this.multipleChoice_accuracy = multipleChoice_accuracy;
	}
	
	@Override
	public String toString() {
		return "MultipleChoice [multipleChoice_id=" + multipleChoice_id + ", multipleChoice_question="
				+ multipleChoice_question + ", multipleChoiceAnswer_ids=" + multipleChoiceAnswer_ids
				+ ", multipleChoice_stage=" + multipleChoice_stage + ", multipleChoice_useNum=" + multipleChoice_useNum
				+ ", multipleChoice_rightNum=" + multipleChoice_rightNum + ", multipleChoice_accuracy="
				+ multipleChoice_accuracy + "]";
	}
	
}
