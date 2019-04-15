package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * SingleChoices类	单选选项
 * @author 李少石
 * @version 2017-11-29
 */
@Component
public class SingleChoices {
	
	/**
	 * 单选选项id
	 */
	private String singleChoices_id;
	
	/**
	 * 单选题id
	 */
	private String singleChoice_id;
	
	/**
	 * 单选题选项内容
	 */
	private String singleChoice_choice;
	
	/**
	 * 无参构造函数
	 */
	public SingleChoices() {
		super();
	}

	/**
	 * 带参数构造函数
	 * @param singleChoices_id	单选选项id
	 * @param singleChoice_id	单选题id
	 * @param singleChoice_choice	单选题选项内容
	 */
	public SingleChoices(String singleChoices_id, String singleChoice_id, String singleChoice_choice) {
		super();
		this.singleChoices_id = singleChoices_id;
		this.singleChoice_id = singleChoice_id;
		this.singleChoice_choice = singleChoice_choice;
	}
	
	/**
	 * 获取单选选项id
	 * @return
	 */
	public String getSingleChoices_id() {
		return singleChoices_id;
	}
	
	/**
	 * 设置单选选项id
	 * @param singleChoices_id	单选选项id
	 */
	public void setSingleChoices_id(String singleChoices_id) {
		this.singleChoices_id = singleChoices_id;
	}
	
	/**
	 * 获取单选题id
	 * @return
	 */
	public String getSingleChoice_id() {
		return singleChoice_id;
	}
	
	/**
	 * 设置单选题id
	 * @param singleChoice_id	单选题id
	 */
	public void setSingleChoice_id(String singleChoice_id) {
		this.singleChoice_id = singleChoice_id;
	}
	
	/**
	 * 获取单选题选项内容
	 * @return
	 */
	public String getSingleChoice_choice() {
		return singleChoice_choice;
	}
	
	/**
	 * 设置单选题选项内容
	 * @param singleChoice_choice	单选题选项内容
	 */
	public void setSingleChoice_choice(String singleChoice_choice) {
		this.singleChoice_choice = singleChoice_choice;
	}
	
	/**
	 * 通过字符串显示信息
	 */
	@Override
	public String toString() {
		return "SingleChoices [singleChoices_id=" + singleChoices_id + ", singleChoice_id=" + singleChoice_id
				+ ", singleChoice_choice=" + singleChoice_choice + "]";
	}
	
	
}
