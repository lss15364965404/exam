package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * 班级类
 * @author 李少石
 * @version 2018-04-18
 */
@Component
public class Class {

	/**
	 * 班级id
	 */
	private String class_id;
	/**
	 * 班级名称
	 */
	private String class_name;

	/**
	 * 无参构造函数
	 */
	public Class() {
		super();
	}

	/**
	 * 带参数的构造函数
	 * @param class_id
	 * @param class_name
	 */
	public Class(String class_id, String class_name) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	@Override
	public String toString() {
		return "Class [class_id=" + class_id + ", class_name=" + class_name + "]";
	}
	
	
	
}
