package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * MultipleChoices类	多选选项表
 * @author 李少石
 * @version 2017-11-29
 */
@Component
public class MultipleChoices {

	/**
	 * 多选选项ID
	 */
	private String multipleChoices_id;
	
	/**
	 * 多选题ID
	 */
	private String multipleChoice_id;
	
	/**
	 * 多选题选项内容
	 */
	private String multipleChoice_choice;

	/**
	 * 无参数构造函数
	 */
	public MultipleChoices() {
		super();
	}
	
	/**
	 * 带参数构造函数
	 * @param multipleChoices_id	多选选项ID
	 * @param multipleChoice_id		多选题ID
	 * @param multipleChoice_choice	多选题选项内容
	 */
	public MultipleChoices(String multipleChoices_id, String multipleChoice_id, String multipleChoice_choice) {
		super();
		this.multipleChoices_id = multipleChoices_id;
		this.multipleChoice_id = multipleChoice_id;
		this.multipleChoice_choice = multipleChoice_choice;
	}
	
	/**
	 * 获取多选选项ID
	 * @return
	 */
	public String getMultipleChoices_id() {
		return multipleChoices_id;
	}

	/**
	 * 设置多选选项ID
	 * @param multipleChoices_id 多选选项ID
	 */
	public void setMultipleChoices_id(String multipleChoices_id) {
		this.multipleChoices_id = multipleChoices_id;
	}

	/**
	 * 获取多选题ID
	 * @return
	 */
	public String getMultipleChoice_id() {
		return multipleChoice_id;
	}

	/**
	 * 设置多选题ID
	 * @param multipleChoice_id 多选题ID
	 */
	public void setMultipleChoice_id(String multipleChoice_id) {
		this.multipleChoice_id = multipleChoice_id;
	}

	/**
	 * 获取多选题选项内容
	 * @return
	 */
	public String getMultipleChoice_choice() {
		return multipleChoice_choice;
	}

	/**
	 * 设置多选题选项内容
	 * @param multipleChoice_choice 多选题选项内容
	 */
	public void setMultipleChoice_choice(String multipleChoice_choice) {
		this.multipleChoice_choice = multipleChoice_choice;
	}
	
	/**
	 * 通过字符串显示信息
	 */
	@Override
	public String toString() {
		return "MultipleChoices [multipleChoices_id=" + multipleChoices_id + ", multipleChoice_id=" + multipleChoice_id
				+ ", multipleChoice_choice=" + multipleChoice_choice + "]";
	}
	
	
	
	
}
