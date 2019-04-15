package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 填空题类
 * @author 李少石
 *
 */
@Component
public class FillBlank {
	
	/**
	 * 填空题id
	 */
	private String fillBlank_id;
	
	/**
	 * 出题老师的id
	 */
	private String teacher_id;
	/**
	 * 出题老师的name
	 */
	private String teacher_name;
	/**
	 * 填空题问题
	 */
	private String fillBlank_question;
	
	/**
	 * 填空题答案
	 */
	private String fillBlank_answer;
	
	/**
	 * 填空题阶段
	 */
	private String fillBlank_stage;
	
	/**
	 * 学生做题次数
	 */
	private String fillBlank_useNum;
	
	/**
	 * 学生做对次数
	 */
	private String fillBlank_rightNum;
	
	/**
	 * 正确率
	 */
	private String fillBlank_accuracy;

	/**
	 * 无参构造方法
	 */
	public FillBlank() {
		super();
	}

	

	public FillBlank(String fillBlank_id, String teacher_id, String teacher_name, String fillBlank_question,
			String fillBlank_answer, String fillBlank_stage, String fillBlank_useNum, String fillBlank_rightNum,
			String fillBlank_accuracy) {
		super();
		this.fillBlank_id = fillBlank_id;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.fillBlank_question = fillBlank_question;
		this.fillBlank_answer = fillBlank_answer;
		this.fillBlank_stage = fillBlank_stage;
		this.fillBlank_useNum = fillBlank_useNum;
		this.fillBlank_rightNum = fillBlank_rightNum;
		this.fillBlank_accuracy = fillBlank_accuracy;
	}



	/**
	 * 得到填空题的id
	 * @return
	 */
	public String getFillBlank_id() {
		return fillBlank_id;
	}

	/**
	 * 设置填空题id
	 * @param fillBlank_id
	 */
	public void setFillBlank_id(String fillBlank_id) {
		this.fillBlank_id = fillBlank_id;
	}

	/**
	 * 得到填空题出题老师id
	 * @return
	 */
	public String getTeacher_id() {
		return teacher_id;
	}

	/**
	 * 设置填空题出题老师id
	 * @param teacher_id
	 */
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	/**
	 * 得到填空题问题
	 * @return
	 */
	public String getFillBlank_question() {
		return fillBlank_question;
	}

	/**
	 * 设置填空题问题
	 * @param fillBlank_question
	 */
	public void setFillBlank_question(String fillBlank_question) {
		this.fillBlank_question = fillBlank_question;
	}

	/**
	 * 得到填空题答案
	 * @return
	 */
	public String getFillBlank_answer() {
		return fillBlank_answer;
	}

	/**
	 * 设置填空题答案
	 * @param fillBlank_answer
	 */
	public void setFillBlank_answer(String fillBlank_answer) {
		this.fillBlank_answer = fillBlank_answer;
	}

	/**
	 * 得到填空题阶段
	 * @return
	 */
	public String getFillBlank_stage() {
		return fillBlank_stage;
	}

	/**
	 * 设置填空题阶段
	 * @param fillBlank_stage
	 */
	public void setFillBlank_stage(String fillBlank_stage) {
		this.fillBlank_stage = fillBlank_stage;
	}

	/**
	 * 得到填空题使用次数
	 * @return
	 */
	public String getFillBlank_useNum() {
		return fillBlank_useNum;
	}

	/**
	 * 设置填空题使用次数
	 * @param fillBlank_useNum
	 */
	public void setFillBlank_useNum(String fillBlank_useNum) {
		this.fillBlank_useNum = fillBlank_useNum;
	}

	/**
	 * 得到填空题正确次数
	 * @return
	 */
	public String getFillBlank_rightNum() {
		return fillBlank_rightNum;
	}

	/**
	 * 设置填空题正确次数
	 * @param fillBlank_rightNum
	 */
	public void setFillBlank_rightNum(String fillBlank_rightNum) {
		this.fillBlank_rightNum = fillBlank_rightNum;
	}

	/**
	 * 得到填空题正确率
	 * @return
	 */
	public String getFillBlank_accuracy() {
		return fillBlank_accuracy;
	}

	/**
	 * 设置填空题正确率
	 * @param fillBlank_accuracy
	 */
	public void setFillBlank_accuracy(String fillBlank_accuracy) {
		this.fillBlank_accuracy = fillBlank_accuracy;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	@Override
	public String toString() {
		return "FillBlank [fillBlank_id=" + fillBlank_id + ", teacher_id=" + teacher_id + ", teacher_name="
				+ teacher_name + ", fillBlank_question=" + fillBlank_question + ", fillBlank_answer=" + fillBlank_answer
				+ ", fillBlank_stage=" + fillBlank_stage + ", fillBlank_useNum=" + fillBlank_useNum
				+ ", fillBlank_rightNum=" + fillBlank_rightNum + ", fillBlank_accuracy=" + fillBlank_accuracy + "]";
	}


}
