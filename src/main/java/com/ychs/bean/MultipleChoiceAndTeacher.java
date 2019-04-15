package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 多选题类
 * @author 齐俐珺
 *
 */
@Component
public class MultipleChoiceAndTeacher {

	/**
	 * 多选题id
	 */
	private String multipleChoice_id;
	
	/**
	 * 老师id
	 */
	private String teacher_id;
	
	/**
	 * 老师name
	 */
	private String teacher_name;
	
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
	public MultipleChoiceAndTeacher() {
		super();
	}

	public MultipleChoiceAndTeacher(String multipleChoice_id, String teacher_id, String teacher_name,
			String multipleChoice_question, String multipleChoiceAnswer_ids, String multipleChoice_stage,
			String multipleChoice_useNum, String multipleChoice_rightNum, String multipleChoice_accuracy) {
		super();
		this.multipleChoice_id = multipleChoice_id;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.multipleChoice_question = multipleChoice_question;
		this.multipleChoiceAnswer_ids = multipleChoiceAnswer_ids;
		this.multipleChoice_stage = multipleChoice_stage;
		this.multipleChoice_useNum = multipleChoice_useNum;
		this.multipleChoice_rightNum = multipleChoice_rightNum;
		this.multipleChoice_accuracy = multipleChoice_accuracy;
	}

	public String getMultipleChoice_id() {
		return multipleChoice_id;
	}

	public void setMultipleChoice_id(String multipleChoice_id) {
		this.multipleChoice_id = multipleChoice_id;
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

	public String getMultipleChoice_question() {
		return multipleChoice_question;
	}

	public void setMultipleChoice_question(String multipleChoice_question) {
		this.multipleChoice_question = multipleChoice_question;
	}

	public String getMultipleChoiceAnswer_ids() {
		return multipleChoiceAnswer_ids;
	}

	public void setMultipleChoiceAnswer_ids(String multipleChoiceAnswer_ids) {
		this.multipleChoiceAnswer_ids = multipleChoiceAnswer_ids;
	}

	public String getMultipleChoice_stage() {
		return multipleChoice_stage;
	}

	public void setMultipleChoice_stage(String multipleChoice_stage) {
		this.multipleChoice_stage = multipleChoice_stage;
	}

	public String getMultipleChoice_useNum() {
		return multipleChoice_useNum;
	}

	public void setMultipleChoice_useNum(String multipleChoice_useNum) {
		this.multipleChoice_useNum = multipleChoice_useNum;
	}

	public String getMultipleChoice_rightNum() {
		return multipleChoice_rightNum;
	}

	public void setMultipleChoice_rightNum(String multipleChoice_rightNum) {
		this.multipleChoice_rightNum = multipleChoice_rightNum;
	}

	public String getMultipleChoice_accuracy() {
		return multipleChoice_accuracy;
	}

	public void setMultipleChoice_accuracy(String multipleChoice_accuracy) {
		this.multipleChoice_accuracy = multipleChoice_accuracy;
	}

	@Override
	public String toString() {
		return "MultipleChoiceAndTeacher [multipleChoice_id=" + multipleChoice_id + ", teacher_id=" + teacher_id
				+ ", teacher_name=" + teacher_name + ", multipleChoice_question=" + multipleChoice_question
				+ ", multipleChoiceAnswer_ids=" + multipleChoiceAnswer_ids + ", multipleChoice_stage="
				+ multipleChoice_stage + ", multipleChoice_useNum=" + multipleChoice_useNum
				+ ", multipleChoice_rightNum=" + multipleChoice_rightNum + ", multipleChoice_accuracy="
				+ multipleChoice_accuracy + "]";
	}
	
	


	
	
	
	
}
